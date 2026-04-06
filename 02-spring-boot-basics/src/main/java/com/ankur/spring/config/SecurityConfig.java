package com.ankur.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for Postman
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated() // Secure all endpoints
            )
            .httpBasic(withDefaults()); // Enable Basic Auth

    return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User
                .withUsername("ankur") //Username
                .password("{noop}1234") //No password encoding (for testing only)
                .roles("USER") // Assign role USER
                .build();

        // In-memory user store with the defined user
        return new InMemoryUserDetailsManager(user);
    }
}
