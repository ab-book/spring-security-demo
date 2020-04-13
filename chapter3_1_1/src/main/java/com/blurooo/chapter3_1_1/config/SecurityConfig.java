package com.blurooo.chapter3_1_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/backend/admin/api/**").hasRole("ADMIN")
                .antMatchers("/backend/user/api/**").hasRole("USER")
                .antMatchers("/backend/app/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();
                //.loginPage("/login")
                //.loginProcessingUrl("/login")
                //.permitAll();
    }

    //@Bean
    //public UserDetailsService userDetailsService() {
    //    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    //    manager.createUser(User.withUsername("user").password("123").roles("USER").build());
    //    manager.createUser(User.withUsername("admin").password("123").roles("USER", "ADMIN").build());
    //    return manager;
    //}

    //@Bean
    //public PasswordEncoder passwordEncoder() {
    //    return NoOpPasswordEncoder.getInstance();
    //}
}