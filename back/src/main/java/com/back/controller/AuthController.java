package com.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.back.dto.RegisterDTO;
import com.back.model.Auth;
import com.back.model.User;
import com.back.model.UserRole;
import com.back.repository.UserRepository;
import com.back.service.AuthService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated Auth data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        return null;
    }
    // public ResponseEntity<User> getMethodName(@RequestBody Auth auth) {
    // try {
    // User authenticatedUser = authService.authenticate(auth);
    // return ResponseEntity.ok(authenticatedUser);
    // } catch (RuntimeException e) {
    // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    // }
    // }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO data) {
        if (this.userRepository.findByEmail(data.login()) != null)
            return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        User newUser = new User(data.login(), encryptedPassword, data.name(), /* data.role() */ UserRole.USER);

        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }

}
