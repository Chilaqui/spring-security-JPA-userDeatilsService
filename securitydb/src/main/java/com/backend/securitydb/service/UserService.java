package com.backend.securitydb.service;



import org.springframework.http.ResponseEntity;

import com.backend.securitydb.model.User;

public interface UserService {

    
    ResponseEntity<String> registerUser(User user);// Aquí deberías implementar la lógica de registro de usuario, incluyendo la codificación de la contraseña y el guardado en la base de datos.

    
    String login(User user);// Aquí deberías implementar la lógica de autenticación y devolver un token JWT o similar.
}
