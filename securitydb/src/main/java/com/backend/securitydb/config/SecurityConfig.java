package com.backend.securitydb.config;

import java.net.http.HttpClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
// Este archivo configura la seguridad de la aplicación utilizando Spring Security.

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())// Deshabilitar CSRF para simplificar la configuración
            .authorizeRequests( auth -> auth
                .requestMatchers("/auth/**").permitAll() // Rutas Publicas
                .anyRequest().authenticated() // Requerir autenticación para cualquier otra solicitud
            )
            .formLogin(withDefaults()); // Habilitar el formulario de inicio de sesión
        return http.build(); 
            
    }

    
}
