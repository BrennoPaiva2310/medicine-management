package com.guimaraes.medicine.controller;

import com.guimaraes.medicine.dto.LoginDTO;
import com.guimaraes.medicine.model.User;
import com.guimaraes.medicine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody LoginDTO user) {
        return ResponseEntity.ok(userService.userCreate(user)).getBody();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers()).getBody();
    }
}
