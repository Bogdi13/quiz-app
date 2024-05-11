package com.example.ProiectAPI.services;

import com.example.ProiectAPI.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProiectAPI.services.interfaces.IUserService;
import com.example.ProiectAPI.repository.interfaces.IUserRepository;
import com.example.ProiectAPI.domain.dtos.UserDTO;

import javax.annotation.Resource;

@Service
public class UserService implements IUserService {

    @Resource
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = this.userRepository.getUserByUsername(username);
        UserDTO userDTO = new UserDTO();
        if (user != null) {
            userDTO.setId(user.getId());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setPassword(user.getPassword());
            userDTO.setRole(user.getRole());
            userDTO.setUsername(user.getUsername());
        }
        return userDTO;
    }
}
