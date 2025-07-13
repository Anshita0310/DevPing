package com.devping.service;

import com.devping.dto.SignupRequest;
import com.devping.model.Role;
import com.devping.model.User;
import com.devping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(SignupRequest signUpRequest) {
        User user = new User(signUpRequest.getUsername(), 
                           signUpRequest.getEmail(), 
                           passwordEncoder.encode(signUpRequest.getPassword()));
        
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setBio(signUpRequest.getBio());
        user.setSkills(signUpRequest.getSkills());
        user.setGithubProfile(signUpRequest.getGithubProfile());
        user.setLinkedinProfile(signUpRequest.getLinkedinProfile());
        user.setRole(Role.USER);

        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User updateUser(Long userId, User userDetails) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setBio(userDetails.getBio());
        user.setSkills(userDetails.getSkills());
        user.setGithubProfile(userDetails.getGithubProfile());
        user.setLinkedinProfile(userDetails.getLinkedinProfile());

        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
