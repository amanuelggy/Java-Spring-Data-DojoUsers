package com.amanuel.dojoNinja.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.
	            authorizeRequests()
	                .antMatchers("/css/**", "/js/**", "/registration","/new/**","/ninjas/**").permitAll()
	                .anyRequest().authenticated()
	                .and()
	            .formLogin()
	                .loginPage("/")
	                .permitAll()
	                .and()
	            .logout()
	                .permitAll();
	    }
}
