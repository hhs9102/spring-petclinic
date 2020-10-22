package org.springframework.samples.petclinic.config.secutiry;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.config.secutiry.filter.CustomAuthenticationFilter;
import org.springframework.samples.petclinic.config.secutiry.handler.CustomLoginSuccessHandler;
import org.springframework.samples.petclinic.config.secutiry.type.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .anyRequest().authenticated()
            .antMatchers("/owners/new").hasAnyRole(Role.ADMIN.name(), Role.VETS.name())
            .antMatchers("/owners").hasAnyRole(Role.ADMIN.name(), Role.VETS.name(), Role.OWNER.name())
        .and()
            .formLogin().permitAll()
        .and()
            .addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter(authenticationManager());
        filter.setAuthenticationSuccessHandler(customLoginSuccessHandler());
        filter.afterPropertiesSet();
        return filter;
    }

    @Bean
    public CustomLoginSuccessHandler customLoginSuccessHandler(){
        return new CustomLoginSuccessHandler();
    }
}
