package com.api.chatspring.dto;

import com.api.chatspring.model.User;

public class UserDTO {
    private Long id;
    private String username;

    public UserDTO() {  }

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
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
    
    @Override
    public String toString() {
    	return String.format("{id: %d, username: %s}", this.getId(), this.getUsername());
    }
}
