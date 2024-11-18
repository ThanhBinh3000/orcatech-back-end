package vn.com.gsoft.security.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                title = "SECURITY",
                description = "api doc",
                termsOfService = "TTB",
                contact = @Contact(
                        name = "Bình",
                        email = "binhk4a@gmail.com"),
                license = @License(
                        name = "TTB"),
                version = "1.0"),
        security = @SecurityRequirement(
                name = "auth"))
@SecurityScheme(
        name = "auth",
        in = SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        description = "security desc")
public class OpenApiConfig {
}