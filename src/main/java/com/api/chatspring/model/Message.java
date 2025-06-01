package com.api.chatspring.model;

import java.util.Date;

import com.api.chatspring.dto.MessageDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_message;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_message_user"))
    private User user;

    private String content;

    private Date timestamp;

    public Message() {  }

    public Message(MessageDTO message) {
        this.id_message = message.getId_message();
        this.content = message.getContent();
        this.user = new User(message.getUser());
    }

    public Long getId_message() {
        return this.id_message;
    }

    public void setId_message(Long id_message) {
        this.id_message = id_message;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
