package com.reynaldineo.auth_service.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reynaldineo.auth_service.model.User;
import com.reynaldineo.auth_service.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
