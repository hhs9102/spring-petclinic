package org.springframework.samples.petclinic.config.secutiry.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.samples.petclinic.config.secutiry.exception.UsernameAndPasswordNotMatchedException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());

        if(passwordEncoder.matches(String.valueOf(authentication.getCredentials()), userDetails.getPassword())){
            authentication.setAuthenticated(true);
        }else{
            throw new UsernameAndPasswordNotMatchedException();
        }
        return authentication;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
