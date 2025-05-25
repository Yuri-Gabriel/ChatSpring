package com.api.chatspring.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.chatspring.dto.MessageDTO;
import com.api.chatspring.model.Message;
import com.api.chatspring.service.MessageService;

@RestController
@RequestMapping("/api")
public class ChatController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/getMessages")
    public ResponseEntity<Object> getMessages() {
        Optional<List<Message>> messages = messageService.getAllMessages();
        if(messages.isPresent()) {
            List<MessageDTO> messageDTOs = messages.get().stream()
                                            .map(MessageDTO::new)
                                            .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(messageDTOs);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
