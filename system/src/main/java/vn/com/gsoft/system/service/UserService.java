package vn.com.gsoft.system.service;

import vn.com.gsoft.system.model.system.Profile;

import java.util.Optional;

public interface UserService {
    Optional<Profile> findUserByToken(String token);

}
