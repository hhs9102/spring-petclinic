package org.springframework.samples.petclinic.config.secutiry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.secutiry.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.csrf().disable()
            .authorizeRequests()
            .anyRequest().authenticated()
            .antMatchers("/owners/new").hasAnyRole(Role.ADMIN.name(), Role.VETS.name())
            .antMatchers("/owners").hasAnyRole(Role.ADMIN.name(), Role.VETS.name(), Role.OWNER.name())
        .and()
            .formLogin().permitAll()

        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
