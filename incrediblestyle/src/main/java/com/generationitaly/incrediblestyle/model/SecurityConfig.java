package com.generationitaly.incrediblestyle.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index.html", true)
                .permitAll();
    }

    // @Override
    // @Bean
    // public UserDetailsService userDetailsService() {
    // List<UserDetails> users= new ArrayList<UserDetails>();
    // users.add(User.withDefaultPasswordEncoder().username("admin").password("nimda").roles("USER","ADMIN").build());
    // users.add(User.withDefaultPasswordEncoder().username("Spring").password("Security").roles("USER").build());
    // return new InMemoryUserDetailsManager(users);
    // }

}
