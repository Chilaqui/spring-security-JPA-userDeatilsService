package com.backend.securitydb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.securitydb.model.User;
import com.backend.securitydb.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    /* @Secured("DEVELOPER") */
    /* @PreAuthorize("hasAuthority('PERM_CREATE')") */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return ResponseEntity.ok(userService.login(user));
    }

    /* @PreAuthorize("hasRole('DEVELOPER')") */
    @GetMapping("/dev-only")
    public ResponseEntity<String> devOnlyEndpoint() {
        return ResponseEntity.ok("¡Hola Developer!");
    }

    @PreAuthorize("hasRole'USER")
    @GetMapping("/users")
    public ResponseEntity<String> soloUser(){
        return ResponseEntity.ok("Hola Users");
    }

    @PreAuthorize("hasRole'ADMIN")
    @GetMapping("/admin")
    public ResponseEntity<String> soloAdmin(){
        return ResponseEntity.ok("Hola admin");
    }

    @PreAuthorize("hasRole'SECURITY")
    @GetMapping("/security")
    public ResponseEntity<String> soloSecurity(){
        return ResponseEntity.ok("Hola Users");
    }

}