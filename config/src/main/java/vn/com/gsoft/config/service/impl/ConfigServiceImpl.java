package vn.com.gsoft.config.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.com.gsoft.config.entity.ServiceConfig;
import vn.com.gsoft.config.model.Profile;
import vn.com.gsoft.config.model.ProfileSource;
import vn.com.gsoft.config.repository.ServiceConfigRepository;
import vn.com.gsoft.config.service.ConfigService;
import vn.com.gsoft.config.utils.DecryptionEnvironmentPostProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ServiceConfigRepository configRepository;
    @Value("${org.springframework.boot.env.secretKey}")
    private String secretKey;

    @Override
    public Profile get(String application, boolean enable) {
        Profile result = new Profile();
        result.setName(application);
        ProfileSource ps = new ProfileSource();
        ps.setName("LOCAL");
        List<ServiceConfig> configs = configRepository.findByApplicationAndEnable(application, enable);
        for(ServiceConfig c: configs){
            if (c.getValue() instanceof String && c.getValue().contains("ENC(")) {
                String value = c.getValue();
                Pattern pattern = Pattern.compile("ENC\\([^)]+\\)");
                Matcher matcher = pattern.matcher(c.getValue());

                int count = 0;
                while (matcher.find()) {
                    count++;
                }
                for (int i = 0; i < count; i++) {
                    int start = c.getValue().indexOf("ENC(");
                    int end = start + 29;
                    String maHoa = c.getValue().substring(start, end);
                    String decryptedValue = DecryptionEnvironmentPostProcessor.decryptValue(secretKey, maHoa);
                    value = value.replace(maHoa, decryptedValue);
                }
                c.setValue(value);
            }
        }
        Map<String, String> mapConfig = configs.stream().collect(Collectors.toMap(ServiceConfig::getKey, ServiceConfig::getValue));
        ps.setSource(mapConfig);
        result.setPropertySources(Arrays.asList(ps));
        return result;
    }

    @Override
    public Profile get(String application, String profile, boolean enable) {
        Profile result = new Profile();
        result.setName(application);
        result.setProfiles(Arrays.asList(profile.split(",")));
        ProfileSource ps = new ProfileSource();
        ps.setName("LOCAL");
        List<ServiceConfig> configs = configRepository.findByApplicationAndProfileInAndEnable(application, Arrays.asList(profile.split(",")), enable);
        for(ServiceConfig c: configs){
            if (c.getValue() instanceof String && c.getValue().contains("ENC(")) {
                String value = c.getValue();
                Pattern pattern = Pattern.compile("ENC\\([^)]+\\)");
                Matcher matcher = pattern.matcher(c.getValue());

                int count = 0;
                while (matcher.find()) {
                    count++;
                }
                for (int i = 0; i < count; i++) {
                    int start = c.getValue().indexOf("ENC(");
                    int end = start + 29;
                    String maHoa = c.getValue().substring(start, end);
                    String decryptedValue = DecryptionEnvironmentPostProcessor.decryptValue(secretKey, maHoa);
                    value = value.replace(maHoa, decryptedValue);
                }
                c.setValue(value);
            }
        }
        Map<String, String> mapConfig = configs.stream()
                .filter(config -> config.getKey() != null && config.getValue() != null).collect(Collectors.toMap(ServiceConfig::getKey, ServiceConfig::getValue));
        ps.setSource(mapConfig);
        result.setPropertySources(Arrays.asList(ps));
        return result;
    }

    @Override
    public Profile get(String application, String profile, String label, boolean enable) {
        Profile result = new Profile();
        result.setName(application);
        result.setProfiles(Arrays.asList(profile.split(",")));
        result.setLabel(label);
        ProfileSource ps = new ProfileSource();
        ps.setName("LOCAL");
        List<ServiceConfig> configs = configRepository.findByApplicationAndProfileInAndLabelAndEnable(application, Arrays.asList(profile.split(",")), label, enable);
        for(ServiceConfig c: configs){
            if (c.getValue() instanceof String && c.getValue().contains("ENC(")) {
                String value = c.getValue();
                Pattern pattern = Pattern.compile("ENC\\([^)]+\\)");
                Matcher matcher = pattern.matcher(c.getValue());

                int count = 0;
                while (matcher.find()) {
                    count++;
                }
                for (int i = 0; i < count; i++) {
                    int start = value.indexOf("ENC(");
                    int end = start + 29;
                    String maHoa = value.substring(start, end);
                    String decryptedValue = DecryptionEnvironmentPostProcessor.decryptValue(secretKey, maHoa);
                    value = value.replace(maHoa, decryptedValue);
                }
                c.setValue(value);
            }
        }
        Map<String, String> mapConfig = configs.stream()
                .filter(config -> config.getKey() != null && config.getValue() != null).collect(Collectors.toMap(ServiceConfig::getKey, ServiceConfig::getValue));
        ps.setSource(mapConfig);
        result.setPropertySources(Arrays.asList(ps));
        return result;
    }

    @Override
    public String encrypt(String value) {
        return DecryptionEnvironmentPostProcessor.encryptValue(secretKey, value);
    }
}
