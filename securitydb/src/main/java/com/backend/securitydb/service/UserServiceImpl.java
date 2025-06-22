package com.backend.securitydb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.securitydb.model.User;
import com.backend.securitydb.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    // Implementa aquí los métodos necesarios para gestionar usuarios.
    // Por ejemplo, puedes implementar métodos para crear, actualizar, eliminar y buscar usuarios.   
    // Puedes utilizar UserRepository para interactuar con la base de datos y realizar operaciones CRUD.  
    // Asegúrate de manejar las excepciones adecuadamente y proporcionar una lógica de negocio sólida.   
    // También puedes implementar métodos adicionales según sea necesario para tu aplicación.

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public ResponseEntity<String> registerUser (User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }


    @Override
    public String login(User user){
        Optional<User> existingUser = userRepository.findByUserName(user.getUserName());
        if (existingUser.isEmpty() || !passwordEncoder.matches(user.getPassword(), existingUser.get().getPassword())) {
            return "Invalid username or password"; // Aquí deberías manejar el error de manera adecuada, tal vez lanzando una excepción personalizada.
        
        }
        return "Login successful"; // Aquí deberías implementar la lógica de autenticación y devolver un token JWT o similar.
    }

}
