package vn.com.gsoft.config.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecryptionEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Properties props = new Properties();
        environment.getPropertySources().forEach(propertySource -> {
            if (propertySource instanceof EnumerablePropertySource) {
                EnumerablePropertySource<?> eps = (EnumerablePropertySource<?>) propertySource;
                for (String key : eps.getPropertyNames()) {
                    Object value = eps.getProperty(key);
                    if (value instanceof String && ((String) value).contains("ENC(")) {

                        Pattern pattern = Pattern.compile("ENC\\([^)]+\\)");
                        Matcher matcher = pattern.matcher((String) value);

                        int count = 0;
                        while (matcher.find()) {
                            count++;
                        }
                        for (int i = 0; i < count; i++) {
                            int start = ((String) value).indexOf("ENC(");
                            int end = start + 29;
                            String maHoa = ((String) value).substring(start, end);
                            String decryptedValue = decryptValue(environment, maHoa);
                            value = ((String) value).replace(maHoa, decryptedValue);
                        }
                        props.setProperty(key, (String) value);
                    }
                }
            }
        });
        environment.getPropertySources().addFirst(new PropertiesPropertySource("decryptedProperties", props));
    }

    public static String decryptValue(ConfigurableEnvironment environment, String encryptedValue) {
        return decryptValue(environment.getProperty("org.springframework.boot.env.secretKey"), encryptedValue);
    }

    public static String decryptValue(String secretKey, String encryptedValue) {
        try {
            if (StringUtils.isEmpty(encryptedValue)) {
                return encryptedValue;
            }
            if (!encryptedValue.startsWith("ENC(")) {
                return encryptedValue;
            }
            // Giả sử rằng encryptedValue bắt đầu bằng tiền tố "ENC(" và kết thúc bằng ")"
            String encryptedData = encryptedValue.substring(4, encryptedValue.length() - 1);

            // Chuyển đổi chuỗi được mã hóa Base64 thành một mảng byte
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);

            // Tạo khóa từ chuỗi khóa của bạn (cần được an toàn hơn trong ứng dụng thực tế)
            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");

            // Khởi tạo Cipher với chế độ giải mã
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);

            // Giải mã dữ liệu
            byte[] originalBytes = cipher.doFinal(encryptedBytes);

            // Chuyển đổi byte giải mã thành chuỗi
            return new String(originalBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting value", e);
        }
    }

    public static String encryptValue(ConfigurableEnvironment environment, String value) {
        return decryptValue(environment.getProperty("org.springframework.boot.env.secretKey"), value);
    }

    public static String encryptValue(String secretKey, String value) {
        try {
            // Tạo khóa từ chuỗi khóa của bạn
            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");

            // Khởi tạo Cipher với chế độ mã hóa
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);

            // Mã hóa dữ liệu
            byte[] encryptedBytes = cipher.doFinal(value.getBytes("UTF-8"));

            // Chuyển đổi byte mã hóa thành chuỗi Base64
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting value", e);
        }
    }
}