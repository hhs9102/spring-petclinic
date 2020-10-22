package org.springframework.samples.petclinic.config.secutiry.interceptor;

import org.springframework.samples.petclinic.config.secutiry.type.AuthConstants;
import org.springframework.samples.petclinic.config.secutiry.util.TokenUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class JwtTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try{
            String token = Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals(AuthConstants.AUTH_TOKEN.name()))
                .map(cookie -> cookie.getValue())
                .findFirst().orElseThrow(AuthenticationException::new);
            if(TokenUtils.isValidToken(token)){
                return true;
            }
        }catch (AuthenticationException e){
            response.sendRedirect("/error/unauthorized");
        }
        return false;
    }
}
