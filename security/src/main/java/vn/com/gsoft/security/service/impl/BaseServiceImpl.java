package vn.com.gsoft.security.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import vn.com.gsoft.security.model.system.Profile;
import vn.com.gsoft.security.service.BaseService;

@Service
@Slf4j
public class BaseServiceImpl implements BaseService {

    @Override
    public Profile getLoggedUser() throws Exception {
        try {
            return (Profile) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception ex) {
            throw new Exception("Token invalid");
        }
    }
}