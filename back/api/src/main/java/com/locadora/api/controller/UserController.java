package com.locadora.api.controller;

import com.locadora.api.dto.UserDto;
import com.locadora.api.model.UserModel;
import com.locadora.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        userService.create(userDto);
        return new ResponseEntity<>("Usuario cadastrado com sucesso", HttpStatus.CREATED);
    }
}