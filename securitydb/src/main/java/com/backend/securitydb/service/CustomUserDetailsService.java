package com.backend.securitydb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.securitydb.model.User;
import com.backend.securitydb.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    // Esta clase se utiliza para cargar los detalles del usuario durante la autenticación.
    // Aquí puedes implementar la lógica para cargar un usuario desde la base de datos
    // y proporcionar sus detalles a Spring Security.
    
    // Por ejemplo, puedes usar UserDetailsService para cargar un usuario por su nombre de usuario.
    
    // Implementa los métodos necesarios para autenticar al usuario y proporcionar sus roles y permisos.
    @Autowired
    private UserRepository userRepository;
   
    // Aquí puedes implementar el método loadUserByUsername para cargar un usuario por su nombre de usuario.
     @Override
     public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
         // Lógica para cargar el usuario desde la base de datos
         Optional<User> user = userRepository.findByUserName(userName);
         if (user.isEmpty()) {
             throw new UsernameNotFoundException("Usuario no encontrado con el username: " + userName);
         }
         return user.get();

     }
}
