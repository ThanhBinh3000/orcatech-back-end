package vn.com.gsoft.security.service;

import vn.com.gsoft.security.model.system.Profile;

public interface BaseService {
    Profile getLoggedUser() throws Exception;
}