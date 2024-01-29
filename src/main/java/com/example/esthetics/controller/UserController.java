package com.example.esthetics.controller;

import com.example.esthetics.model.UserDTO;
import com.example.esthetics.service.UserService;
import com.example.esthetics.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/save_user")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        ResponseEntity<UserDTO> responseEntity = userService.saveUser(userDTO);
        return responseEntity;
    }

    @GetMapping("/get_user")
    public ResponseEntity<UserDTO> getUser(){
        return null;
    }
}
