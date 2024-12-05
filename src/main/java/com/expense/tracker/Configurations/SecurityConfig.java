package com.expense.tracker.Configurations; // Declares the package this file belongs to

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean; // Imports the Bean annotation from Spring
import org.springframework.context.annotation.Configuration; // Imports the Configuration annotation from Spring
import org.springframework.security.authentication.AuthenticationManager; // Imports the AuthenticationManager class from Spring Security
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration; // Imports the AuthenticationConfiguration class from Spring Security
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // Imports the HttpSecurity class from Spring Security
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Imports the BCryptPasswordEncoder class from Spring Security
import org.springframework.security.crypto.password.PasswordEncoder; // Imports the PasswordEncoder interface from Spring Security
import org.springframework.security.web.SecurityFilterChain; // Imports the SecurityFilterChain interface from Spring Security

@Configuration // Indicates that this class contains one or more bean methods and may be processed by the Spring container to generate bean definitions and service requests
public class SecurityConfig {


    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


    @Bean // Indicates that this method produces a bean to be managed by the Spring container
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Disables CSRF protection
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // Allows access to auth endpoints without authentication
                        .anyRequest().authenticated()); // Requires authentication for any other request
        return http.build(); // Builds the SecurityFilterChain
    }

    @Bean // Indicates that this method produces a bean to be managed by the Spring container
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager(); // Returns the AuthenticationManager bean
    }

    @Bean // Indicates that this method produces a bean to be managed by the Spring container
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Returns a BCryptPasswordEncoder bean
    }

    
}