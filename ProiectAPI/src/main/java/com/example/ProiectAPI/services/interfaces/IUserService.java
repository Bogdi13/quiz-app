package com.example.ProiectAPI.services.interfaces;

import com.example.ProiectAPI.domain.dtos.UserDTO;


public interface IUserService {
    UserDTO getUserByUsername(String username);

}
