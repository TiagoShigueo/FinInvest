package com.back.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.back.model.User;
import com.back.repository.UserRepository;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    public static List<User> users = new ArrayList<>();

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok(userList);
    }

}
