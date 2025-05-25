package com.api.chatspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.chatspring.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    
}
