package com.rental.securityjwtservice.security;

import com.rental.securityjwtservice.jwt.JwtConfig;
import com.rental.securityjwtservice.jwt.JwtTokenVerifier;
import com.rental.securityjwtservice.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.rental.securityjwtservice.service.RentalUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class RentalSecurityConfig {
    private final PasswordEncoder passwordEncoder;
    private final RentalUserService rentalUserService;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(
                        authenticationManager(http
                                .getSharedObject(AuthenticationConfiguration.class)), jwtConfig, secretKey))
                .addFilterAfter(
                        new JwtTokenVerifier(secretKey, jwtConfig),
                        JwtUsernameAndPasswordAuthenticationFilter.class)
                .authenticationProvider(daoAuthenticationProvider())
                .authorizeRequests()
                .anyRequest()
                .authenticated();
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
        return authConfiguration.getAuthenticationManager();
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(rentalUserService);

        return provider;
    }
}
