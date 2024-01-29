package com.example.esthetics.service.impl;

import com.example.esthetics.model.UserDTO;
import com.example.esthetics.repository.UserRepo;
import com.example.esthetics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public ResponseEntity<UserDTO> saveUser(UserDTO userDTO) {
        if((userDTO.getName() == "") || (userDTO.getName() == null)){
            return new ResponseEntity<UserDTO>(userDTO, HttpStatus.NOT_ACCEPTABLE);
        }
        UserDTO userDTO1 = userRepo.getByEmail(userDTO.getEmail());
        if(userDTO1 != null){
            return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CONFLICT);
        }
        //Same name and surname introduced
        Integer id = userRepo.getByNameNSurname(userDTO.getName(), userDTO.getSurName());
        if(id != null){
            return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CONFLICT);
        }
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);
        userRepo.save(userDTO);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }
}
