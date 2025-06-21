package com.backend.securitydb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.securitydb.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUserName(String username);
    // Este método permite buscar un usuario por su nombre de usuario.
    // Si el usuario existe, devuelve un Optional que contiene el usuario.
}
