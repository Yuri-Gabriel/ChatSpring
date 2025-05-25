package com.api.chatspring.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.api.chatspring.model.User;

public class UserDTO {
    private Long id;
    private String username;
    private List<MessageDTO> messages;

    public UserDTO() {  }

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        // Converte List<Message> em List<MessageDTO>
        this.messages = user.getMessages() != null ?
            user.getMessages().stream()
                .map(MessageDTO::new)
                .collect(Collectors.toList())
            : null;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public List<MessageDTO> getMessages() {
        return messages;
    }
    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }
}
