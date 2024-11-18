package vn.com.gsoft.config.service;

import org.springframework.stereotype.Service;
import vn.com.gsoft.config.model.Profile;

@Service
public interface ConfigService {
    Profile get(String application, boolean enable);

    Profile get(String application, String profile, boolean enable);

    Profile get(String application, String profile, String label, boolean enable);

    String encrypt(String value);
}
