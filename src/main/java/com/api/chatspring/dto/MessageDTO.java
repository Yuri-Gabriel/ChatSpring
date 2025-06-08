package com.api.chatspring.dto;

import java.util.Date;

import com.api.chatspring.model.Message;

public class MessageDTO {
    private Long id_message;
    private UserDTO user;
    private String content;
    private Date timestamp;
    
    public MessageDTO() {}

    public MessageDTO(Message message) {
        this.id_message = message.getId_message();
        this.content = message.getContent();
        this.user = new UserDTO(message.getUser());
    }

    public Long getId_message() {
        return id_message;
    }

    public void setId_message(Long id_message) {
        this.id_message = id_message;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
    	return String.format("{user: %s, content: %s}", this.getUser().toString(), this.getContent());
    }
}
