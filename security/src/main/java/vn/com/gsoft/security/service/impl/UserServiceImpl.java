package vn.com.gsoft.security.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import vn.com.gsoft.security.constant.CachingConstant;
import vn.com.gsoft.security.entity.*;
import vn.com.gsoft.security.model.dto.ChooseCompany;
import vn.com.gsoft.security.model.dto.CompanyReq;
import vn.com.gsoft.security.model.dto.CompanyRes;
import vn.com.gsoft.security.model.system.CodeGrantedAuthority;
import vn.com.gsoft.security.model.system.Profile;
import vn.com.gsoft.security.repository.*;
import vn.com.gsoft.security.service.RedisListService;
import vn.com.gsoft.security.service.RoleService;
import vn.com.gsoft.security.service.UserService;
import vn.com.gsoft.security.util.system.DataUtils;
import vn.com.gsoft.security.util.system.JwtTokenUtil;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private RedisListService redisListService;
    @Autowired
    private SettingsRepository settingsRepository;
    @Autowired
    private ApplicationSettingRepository applicationSettingRepository;


    @Override
    @Cacheable(value = CachingConstant.USER_TOKEN, key = "#token+ '-' +#username")
    public Optional<Profile> findUserByToken(String token, String username) {
        log.warn("Cache findUserByToken missing: {}", username);
        redisListService.addValueToListEnd(username, token);
        return findUserByUsername(username);
    }

    @Override
    public Optional<Profile> findUserByUsername(String username) {
        Optional<UserProfile> user = userProfileRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BadCredentialsException("Username not found!");
        }
        UserProfile userProfile = user.get();
        Set<CodeGrantedAuthority> privileges = new HashSet<>();
        List<Company> companyList = companyRepository.findByUserId(userProfile.getId());
        Company company = null;
        List<Role> roles = new ArrayList<>();
        List<Settings> settings = new ArrayList<>();
        List<ApplicationSetting> applicationSettings = new ArrayList<>();
        if (companyList.size() == 1) {
            company = companyList.get(0);
            settings = settingsRepository.findByCompanyId(company.getCompanyId());
            applicationSettings = applicationSettingRepository.findByCompanyId(company.getCompanyId());
            CompanyReq req = new CompanyReq();
            req.setCompanyId(company.getCompanyId());
            req.setUserIdQueryData(userProfile.getId());
            CompanyRes companyRes = DataUtils.convertOne(companyRepository.getUserRoleCompany(req), CompanyRes.class);
            company.setRole(companyRes.getRole());
            // check user có phải user hệ thống không
            List<Role> roleList = roleService.findByUserId(userProfile.getId());
            roles = roleService.findByUserIdAndCompanyId(userProfile.getId(), company.getCompanyId());
            roles.addAll(roleList);
            List<Long> roleIds = roles.stream()
                    .map(Role::getId) // Extract the ID from each role
                    .collect(Collectors.toList());
            List<Privilege> privilegeObjs = privilegeRepository.findByRoleIdInAndEntityId(roleIds);
            for (Privilege p : privilegeObjs) {
                privileges.add(new CodeGrantedAuthority(p.getCode()));
            }
        } else {
            List<Role> roleList = roleService.findByUserId(userProfile.getId());
            roles.addAll(roleList);
            List<Long> roleIds = roles.stream()
                    .map(Role::getId) // Extract the ID from each role
                    .collect(Collectors.toList());
            List<Privilege> privilegeObjs = privilegeRepository.findByRoleIdInAndEntityId(roleIds);
            for (Privilege p : privilegeObjs) {
                privileges.add(new CodeGrantedAuthority(p.getCode()));
            }
        }
        return Optional.of(new Profile(
                userProfile.getId(),
                userProfile.getUsername(),
                userProfile.getPassword(),
                userProfile.getFullName(),
                userProfile.getIsActive() && (userProfile.getEnableNT() != null ? userProfile.getEnableNT() : true),
                true,
                true,
                true,
                company, roles, companyList,
                settings, privileges,
                applicationSettings));
    }

    @Override
    public Optional<Profile> findByUsernameWhenChoose(String username) {
        Optional<UserProfile> user = userProfileRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BadCredentialsException("Username not found!");
        }
        UserProfile userProfile = user.get();
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ChooseCompany chooseCompany = (ChooseCompany) requestAttributes.getAttribute("chooseCompany", RequestAttributes.SCOPE_REQUEST);
        Set<CodeGrantedAuthority> privileges = new HashSet<>();
        List<Company> companyList = companyRepository.findByCompanyId(userProfile.getCompanyId());
        Optional<Company> company = companyRepository.findById(chooseCompany.getId());
        CompanyReq req = new CompanyReq();
        req.setCompanyId(company.get().getCompanyId());
        req.setUserIdQueryData(userProfile.getId());
        CompanyRes companyRes = DataUtils.convertOne(companyRepository.getUserRoleCompany(req), CompanyRes.class);
        company.get().setRole(companyRes == null ? null : companyRes.getRole());
        List<Settings> settings = settingsRepository.findByCompanyId(company.get().getCompanyId());
        List<ApplicationSetting> applicationSettings = applicationSettingRepository.findByCompanyId(company.get().getCompanyId());
        // check user có phải user hệ thống không
        List<Role> roleList = roleService.findByUserId(userProfile.getId());
        List<Role> roles = roleService.findByUserIdAndCompanyId(userProfile.getId(), company.get().getCompanyId());
        roles.addAll(roleList);
        List<Long> roleIds = roles.stream()
                .map(Role::getId) // Extract the ID from each role
                .collect(Collectors.toList());
        List<Privilege> privilegeObjs = privilegeRepository.findByRoleIdInAndEntityId(roleIds);
        for (Privilege p : privilegeObjs) {
            privileges.add(new CodeGrantedAuthority(p.getCode()));
        }
        return Optional.of(new Profile(
                userProfile.getId(),
                userProfile.getUsername(),
                userProfile.getPassword(),
                userProfile.getFullName(),
                userProfile.getIsActive() && (userProfile.getEnableNT() != null ? userProfile.getEnableNT() : true),
                true,
                true,
                true,
                company.get(),
                roles, companyList,
                settings, privileges,
                applicationSettings));
    }

    @Override
    @CachePut(value = CachingConstant.USER_TOKEN, key = "#token+ '-' +#username")
    public Optional<Profile> chooseCompany(String token, String username) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            ChooseCompany chooseCompany = (ChooseCompany) requestAttributes.getAttribute("chooseCompany", RequestAttributes.SCOPE_REQUEST);
            if (chooseCompany != null) {
                redisListService.addValueToListEnd(username, token);
                return findByUsernameWhenChoose(username);
            }
        }
        return Optional.ofNullable(null);
    }

    @Override
    public UserProfile findByUsername(String username) {
        return userProfileRepository.findByUsername(username).orElse(null);
    }

    @Override
    public void save(UserProfile username) {
        userProfileRepository.save(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findUserByUsername(username).get();
    }
}