package com.backend.securitydb.config;

import java.net.http.HttpClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.method.P;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
                .authorizeRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll() // Rutas Publicas
                        .anyRequest().authenticated() // Requerir autenticación para cualquier otra solicitud
                )
                .formLogin(withDefaults()); // Habilitar el formulario de inicio de sesión
        return http.build();

    }

    @Bean
    // Este método proporciona un AuthenticationManager que se utiliza para autenticar usuarios.
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {

        return config.getAuthenticationManager();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // Utiliza BCrypt para codificar las contraseñasS
    }


}
