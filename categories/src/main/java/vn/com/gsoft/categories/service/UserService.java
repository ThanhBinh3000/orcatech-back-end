package vn.com.gsoft.categories.service;

import vn.com.gsoft.categories.model.system.Profile;

import java.util.Optional;

public interface UserService {
    Optional<Profile> findUserByToken(String token);

}
