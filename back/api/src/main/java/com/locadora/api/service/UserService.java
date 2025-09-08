package com.locadora.api.service;

import com.locadora.api.dto.UserDto;
import com.locadora.api.model.UserModel;
import com.locadora.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserModel create(UserDto userDto) {
        if(userRepository.findByEmail(userDto.getEmail()).isPresent()){
            throw new RuntimeException("Email já cadastrado");
        }
        UserModel userModel = new UserModel();
        userModel.setName(userDto.getName());
        userModel.setEmail(userDto.getEmail());
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userModel.setPassword(encodedPassword);

        return userRepository.save(userModel);
    }
}