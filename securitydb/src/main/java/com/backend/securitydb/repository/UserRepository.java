package com.backend.securitydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.securitydb.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    

}
