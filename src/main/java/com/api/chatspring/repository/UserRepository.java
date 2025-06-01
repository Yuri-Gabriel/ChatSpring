package com.api.chatspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.chatspring.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
