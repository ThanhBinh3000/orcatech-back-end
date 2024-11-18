package vn.com.gsoft.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vn.com.gsoft.config.model.Profile;
import vn.com.gsoft.config.service.ConfigService;

@RestController
public class EnvController {

    @Autowired
    private ConfigService configService;

    @GetMapping("/{application}")
    public Profile get(@PathVariable() String application) {
        return configService.get(application, true);
    }

    @GetMapping("/{application}/{profile}")
    public Profile get(@PathVariable() String application, @PathVariable() String profile) {
        return configService.get(application, profile, true);
    }

    @GetMapping("/{application}/{profile}/{label}")
    public Profile get(@PathVariable() String application, @PathVariable() String profile,
                       @PathVariable() String label) {
        return configService.get(application, profile, label, true);
    }

    @GetMapping("/encrypt/{value}")
    public String encrypt(@PathVariable() String value) {
        return configService.encrypt(value);
    }
}
