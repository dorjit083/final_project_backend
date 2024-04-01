package com.athang.javatraining.participant_engagement_system.service;

import com.athang.javatraining.participant_engagement_system.model.Password;
import com.athang.javatraining.participant_engagement_system.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasswordServices {
    @Autowired
    private PasswordRepository passwordRepository;

    public Password addPassword(Password password) {
        return passwordRepository.save(password);
    }

    public String deletePassword(int id){
        passwordRepository.deleteById(id);
        return "Users Deleted";
    }

    public boolean existsByUsername(String username) {
        return passwordRepository.existsByUsername(username);
    }
    public boolean authenticateUser(String username, String password) {
        Optional<Password> optionalPassword = passwordRepository.findByUsername(username);
        if (optionalPassword.isPresent()) {
            Password storedPassword = optionalPassword.get();
            return storedPassword.getPassword().equals(password);
        }
        return false;
    }

}
