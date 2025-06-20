package com.reynaldineo.auth_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reynaldineo.auth_service.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

}
