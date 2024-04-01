package com.athang.javatraining.participant_engagement_system.repository;

import com.athang.javatraining.participant_engagement_system.model.Password;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordRepository extends JpaRepository<Password, Integer> {
    boolean existsByUsername(String username);
    Optional<Password> findByUsername(String username);
}