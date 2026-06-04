package com.crud.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityconfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.
                csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/api/students").permitAll()
                        .requestMatchers("/user/**").permitAll()
                        .requestMatchers("/api/student/").hasAnyRole("ADMIN", "TEACHER")
                        .requestMatchers("/api/students/create").hasRole("ADMIN")
                        .requestMatchers("/api/students/delete/**").hasRole("ADMIN")
                        .requestMatchers("/api/students/update/**").hasRole("ADMIN")
                        .requestMatchers("/api/students/search/**").hasAnyRole("ADMIN", "TEACHER")
                        .requestMatchers("/api/students/count").hasRole("ADMIN")
                        .requestMatchers("/api/students/class/**").hasRole("ADMIN")
                        .requestMatchers("/api/dashboard").hasRole("ADMIN")
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());


        return http.build();
    }
}
