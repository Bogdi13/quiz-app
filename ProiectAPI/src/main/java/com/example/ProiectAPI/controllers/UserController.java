package com.example.ProiectAPI.controllers;

import com.example.ProiectAPI.domain.dtos.AuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ProiectAPI.services.interfaces.IUserService;
import com.example.ProiectAPI.domain.dtos.UserDTO;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> GetUserByUsername(@RequestBody AuthDTO authDTO){
        UserDTO existingUser = userService.getUserByUsername(authDTO.getUsername());
        if(existingUser != null) {
            if(!existingUser.getPassword().equals(authDTO.getPassword())){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(existingUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
