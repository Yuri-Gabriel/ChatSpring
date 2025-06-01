package com.api.chatspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.chatspring.model.User;
import com.api.chatspring.repository.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public Optional<List<User>> getAllUsers() {
        return Optional.of(
            repository.findAll()
        );
    }

    public Optional<User> createUser(User user) {
        return Optional.of(
            repository.save(user)
        );
    }
}
