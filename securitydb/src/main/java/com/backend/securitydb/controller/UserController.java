package com.backend.securitydb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    /* @PreAuthorize("hasAuthority('PERM_CREATE') and hasAuthority('PERM_UPDATE')") */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return ResponseEntity.ok(userService.login(user));
    }

    @PreAuthorize("hasRole('DEVELOPER')")
    @GetMapping("/dev-only")
    public ResponseEntity<String> devOnlyEndpoint() {
        return ResponseEntity.ok("¡Hola Developer!");
    }

    // Permisos de crear
    @PreAuthorize("hasAuthority('PERM_CREATE')")
    @GetMapping("/dev-only-create")
    public ResponseEntity<String> devOnlyEndpoint() {
        return ResponseEntity.ok("¡Hola Developer puedes crear!");
    }
    @GetMapping("/dev-only")
    public ResponseEntity<String> devOnlyEndpoint() {
        return ResponseEntity.ok("¡Hola Developer!");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/users")
    public ResponseEntity<String> soloUser(){
        return ResponseEntity.ok("Hola Users");
    }

    // Permisos de escribir 
    
    @PreAuthorize("hasAuthority('PERM_WRITE')")
    @GetMapping("/task-write")
    public ResponseEntity<String> devOnlyEndpoint() {
        return ResponseEntity.ok("¡Hola puedes escribir en esta pagina!");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> soloAdmin(){
        return ResponseEntity.ok("Hola admin");
    }

    //Permisos de leer
    @PreAuthorize("hasAuthority('PERM_READ')")
    @GetMapping("/read")
    public ResponseEntity<String> readEndpoint() {
        return ResponseEntity.ok("¡Hola puedes leer en esta pagina!");
    }

    @PreAuthorize("hasRole('SECURITY')")
    @GetMapping("/security")
    public ResponseEntity<String> soloSecurity(){
        return ResponseEntity.ok("Hola Security");
    }

    //Permisos de eliminar
    @PreAuthorize("hasAuthority('PERM_DELETE')")
    @GetMapping("/delete")
    public ResponseEntity<String> deleteEndpoint() {
        return ResponseEntity.ok("¡Hola puedes eliminar!");
    }

    @PreAuthorize("hasRole('TESTER')")
    @GetMapping("/tester")
    public ResponseEntity<String> soloTester(){
        return ResponseEntity.ok("Hola Testers");
    }

    //Permisos para actualizar
    @PreAuthorize("hasAuthority('PERM_UPDATE')")
    @GetMapping("/update")
    public ResponseEntity<String> updateEndpoint() {
        return ResponseEntity.ok("¡Hola puedes actualizar!");
    }

    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping("/manager")
    public ResponseEntity<String> soloMamager(){
        return ResponseEntity.ok("Hola Manager");
    }

}