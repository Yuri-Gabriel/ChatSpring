package com.api.chatspring.model;

import java.util.List;
import java.util.stream.Collectors;

import com.api.chatspring.dto.MessageDTO;
import com.api.chatspring.dto.UserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @OneToMany(mappedBy = "user")
    private List<Message> messages;

    public User() {  }

    public User(UserDTO user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.messages = user.getMessages() != null ?
            user.getMessages().stream()
                .map(Message::new)
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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}
