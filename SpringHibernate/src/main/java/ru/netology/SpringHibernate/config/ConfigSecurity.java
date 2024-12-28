package ru.netology.SpringHibernate.config;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration

public class ConfigSecurity extends WebSecurityConfigurerAdapter{
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("allog")
                .password("{noop}123456")
                .roles("user");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin().and()
                .authorizeRequests().antMatchers("/person/by-city").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
