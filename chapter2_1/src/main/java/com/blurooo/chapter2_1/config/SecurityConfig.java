package com.blurooo.chapter2_1.config;


import com.blurooo.chapter2_1.authentication.SecurityAuthenticationFailureHandler;
import com.blurooo.chapter2_1.authentication.SecurityAuthenticationSuccessHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    * HttpSecurity 实际上对应了Spring Security命名空间配置方式中xml文件内的标签。
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                    .authenticated()
                .and()
            .formLogin()
                .loginPage("/myLogin.html")
                .loginProcessingUrl("/login")
                .successHandler(new SecurityAuthenticationSuccessHandler())
                .failureHandler(new SecurityAuthenticationFailureHandler())
                // 使登录页不设限访问
                .permitAll()
                .and()
            .csrf().disable();
    }

}
