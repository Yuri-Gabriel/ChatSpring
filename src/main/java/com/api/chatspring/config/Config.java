package com.api.chatspring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.chatspring.model.Message;
import com.api.chatspring.model.User;
import com.api.chatspring.repository.MessageRepository;
import com.api.chatspring.repository.UserRepository;

@Configuration
public class Config {

	@Autowired
    private UserRepository userRepository;
	@Autowired
    private MessageRepository messageRepository;
    
    @Bean
    public boolean popular() {
    	User user1 = new User();
    	user1.setUsername("yuri");
    	User user2 = new User();
    	user2.setUsername("pablo");
    	User user3 = new User();
    	user3.setUsername("mario");
    	
    	userRepository.saveAll(Arrays.asList(user1, user2, user3));
    	
    	Message m1 = new Message();
    	m1.setUser(userRepository.findByUsername("yuri"));
    	m1.setContent("Olá pessoal");
    	Message m2 = new Message();
    	m2.setUser(userRepository.findByUsername("pablo"));
    	m2.setContent("Tudo bão com vcs?");
    	Message m3 = new Message();
    	m3.setUser(userRepository.findByUsername("mario"));
    	m3.setContent("Isso funciona mesmo?");
    	
    	messageRepository.saveAll(Arrays.asList(m1, m2, m3));
    	return true;
    }
	
}
