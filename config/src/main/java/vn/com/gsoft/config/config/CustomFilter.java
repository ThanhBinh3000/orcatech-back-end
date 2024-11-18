package vn.com.gsoft.config.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import vn.com.gsoft.config.utils.DecryptionEnvironmentPostProcessor;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CustomFilter extends GenericFilterBean {
    @Value("${org.springframework.boot.env.secretKey}")
    private String secretKey;
    private static final Pattern BASE64_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+/]+={0,2}$");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        CustomHttpServletRequestWrapper customRequest = new CustomHttpServletRequestWrapper((HttpServletRequest) request);
        // xử lý lấy hết value ở header xử lý và set lại
        Enumeration<String> headerNames = customRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = customRequest.getHeader(headerName);
            String[] headerValueSplit = headerValue.split(" ");
            int i = 0;
            for (String v : headerValueSplit) {
                boolean isBase64 = false;
                if (isBase64(v)) {
                    byte[] decodedBytes = Base64.decodeBase64(v);
                    v = new String(decodedBytes);
                    isBase64 = true;
                }

                if (v != null && v.contains("ENCL(")) {
                    v = v.replace("ENCL(", "ENC(");
                    Pattern pattern = Pattern.compile("ENC\\([^)]+\\)");
                    Matcher matcher = pattern.matcher(v);

                    int count = 0;
                    while (matcher.find()) {
                        count++;
                    }
                    for (int j = 0; j < count; j++) {
                        int start = v.indexOf("ENC(");
                        int end = start + 29;
                        String maHoa = v.substring(start, end);
                        String decryptedValue = DecryptionEnvironmentPostProcessor.decryptValue(secretKey, maHoa);
                        v = v.replace(maHoa, decryptedValue);
                    }
                }

                if (isBase64) {
                    byte[] bytes = v.getBytes();
                    headerValueSplit[i] = Base64.encodeBase64String(bytes);
                } else {
                    headerValueSplit[i] = v;
                }
                i++;
            }
            customRequest.addHeader(headerName, String.join(" ", Arrays.asList(headerValueSplit)));
        }
        filterChain.doFilter(customRequest, response);
    }

    private static boolean isBase64(String str) {
        if (str == null || str.length() % 4 != 0) {
            return false;
        }
        return BASE64_PATTERN.matcher(str).matches();
    }

}
