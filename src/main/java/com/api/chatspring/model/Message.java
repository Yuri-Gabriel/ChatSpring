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
    private Long user_id;

    private String content;

    private Date timestamp;

    public Message() {  }

    public Message(MessageDTO message) {
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

    public void setUser(Long user_id) {
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
