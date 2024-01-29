package com.example.esthetics.service;

import com.example.esthetics.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface UserService {
    ResponseEntity<UserDTO> saveUser(UserDTO userDTO);
}
