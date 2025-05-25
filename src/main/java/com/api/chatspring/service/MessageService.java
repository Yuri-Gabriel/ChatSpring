package com.api.chatspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.chatspring.model.Message;
import com.api.chatspring.repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;

    public Optional<List<Message>> getAllMessages() {
        return Optional.of(
            repository.findAll()
        );
    }

    public void saveMessage(Message message) {
        repository.save(message);
    }
}
