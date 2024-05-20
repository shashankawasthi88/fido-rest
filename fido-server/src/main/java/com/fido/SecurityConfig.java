package com.fido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Disable CSRF
        http.csrf().disable()
            .authorizeRequests()
            .anyRequest().permitAll(); // Permit all requests for simplicity, adjust as needed
    }*/
	
	@Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http .authorizeRequests() .anyRequest().authenticated() // All requests
		 * require authentication .and() .httpBasic(); // Enable Basic Authentication
		 */   
    	
    	
    	 http.csrf().disable() // Disable CSRF protection
         .authorizeRequests()
             .anyRequest().authenticated() // All requests require authentication
             .and()
         .httpBasic(); // Enable Basic Authentication
    
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("fido")
            .password(passwordEncoder.encode("random")) // {noop} indicates plain text password, for simplicity
            .roles("USER");
    }
}