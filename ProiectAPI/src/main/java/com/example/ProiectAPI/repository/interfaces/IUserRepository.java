package com.example.ProiectAPI.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ProiectAPI.domain.model.User;

public interface IUserRepository extends JpaRepository<User,Long> {

    User getUserByUsername(String username);
}
