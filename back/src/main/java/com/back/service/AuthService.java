package com.back.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.back.model.Auth;
import com.back.model.User;
import com.back.repository.UserRepository;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }

    // public User authenticate(Auth auth) {
    // User user = userRepository.findByEmail(auth.getLogin());
    // System.out.println("Teste retorno");
    // if (user != null) {
    // if (passwordEncoder.matches(auth.getPassword(), user.getPassword())) {
    // return user;
    // } else {
    // throw new RuntimeException("Invalid password");
    // }
    // } else {
    // throw new RuntimeException("Invalid email");
    // }
    // }

}
