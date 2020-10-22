package org.springframework.samples.petclinic.config.secutiry.handler;

import org.springframework.samples.petclinic.config.secutiry.type.AuthConstants;
import org.springframework.samples.petclinic.config.secutiry.util.TokenUtils;
import org.springframework.samples.petclinic.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        User user = (User) authentication.getPrincipal();
        String token = TokenUtils.generateJwtToken(user);

        Cookie cookie = new Cookie(AuthConstants.AUTH_TOKEN.name(), token);
        response.addCookie(cookie);
        response.sendRedirect("/");
    }
}
