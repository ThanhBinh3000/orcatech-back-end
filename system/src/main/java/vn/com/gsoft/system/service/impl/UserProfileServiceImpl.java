package vn.com.gsoft.system.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.com.gsoft.system.constant.EntityConstant;
import vn.com.gsoft.system.constant.RecordStatusContains;
import vn.com.gsoft.system.entity.UserProfile;
import vn.com.gsoft.system.model.dto.UserProfileReq;
import vn.com.gsoft.system.repository.UserProfileRepository;
import vn.com.gsoft.system.service.UserProfileService;

import java.util.Date;
import java.util.Optional;

@Log4j2
@Service
public class UserProfileServiceImpl extends BaseServiceImpl<UserProfile, UserProfileReq, Long> implements UserProfileService {
    private final UserProfileRepository hdrRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository hdrRepo,
                                  PasswordEncoder passwordEncoder) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserProfile create(UserProfileReq req) throws Exception {
        Optional<UserProfile> userProfile = this.hdrRepo.findByUsername(req.getUsername());
        if (userProfile.isPresent())
            throw new Exception("UserName already exists!");
        UserProfile e = new UserProfile();
        BeanUtils.copyProperties(req, e, "id");
        if (e.getRecordStatusId() == null) {
            e.setRecordStatusId(RecordStatusContains.ACTIVE);
        }
        if (e.getIsActive() == null) {
            e.setIsActive(true);
        }
        if (e.getEnableNT() == null) {
            e.setEnableNT(true);
        }
        e.setCreated(new Date());
        e.setEntityId(EntityConstant.GUEST);
        e.setPassword(this.passwordEncoder.encode(e.getPassword()));
        return this.hdrRepo.save(e);
    }
}
