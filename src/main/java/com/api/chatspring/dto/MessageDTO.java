package com.api.chatspring.dto;

import java.util.Date;

import com.api.chatspring.model.Message;

public class MessageDTO {
    private Long id_message;
    private Long user_id;
    private String content;
    private Date timestamp;

     public MessageDTO(Message message) {
        this.id_message = message.getId_message();
        this.content = message.getContent();
        this.user_id = message.getUser_id();
    }

    public Long getId_message() {
        return id_message;
    }

    public void setId_message(Long id_message) {
        this.id_message = id_message;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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
}
