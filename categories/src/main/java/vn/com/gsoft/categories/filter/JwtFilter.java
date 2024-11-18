package vn.com.gsoft.categories.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.service.UserService;

import java.io.IOException;
import java.util.Optional;

@Component
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private UserService userService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        String jwtToken = null;

        // Once we get the token validate it.
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            Optional<String> loggedUsernameOpt = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                    .map(Authentication::getName);

            if (!loggedUsernameOpt.isPresent()) {
                Optional<Profile> opt = userService.findUserByToken(jwtToken);

                if (opt.isPresent()) {
                    // if token is valid configure Spring Security to manually set authentication
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            opt.get(), null, opt.get().getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    // After setting the Authentication in the context, we specify
                    // that the current user is authenticated. So it passes the
                    // Spring Security Configurations successfully.
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }

            }
        }
        chain.doFilter(request, response);
    }
}
