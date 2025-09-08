package com.locadora.api.service;

import com.locadora.api.dto.UserDto;
import com.locadora.api.model.UserModel;
import com.locadora.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel create(UserDto userDto) {
        UserModel userModel = new UserModel();
        userModel.setName(userDto.getName());
        userModel.setEmail(userDto.getEmail());
        userModel.setPassword(userDto.getPassword());

        return userRepository.save(userModel);
    }
}