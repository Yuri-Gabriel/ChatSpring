package com.api.chatspring.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.chatspring.dto.MessageDTO;
import com.api.chatspring.dto.UserDTO;
import com.api.chatspring.model.Message;
import com.api.chatspring.model.User;
import com.api.chatspring.service.MessageService;
import com.api.chatspring.service.UserService;

@RestController
@RequestMapping("/api")
public class ChatController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;
    
    @MessageMapping("/saveMessage")
    @SendTo("/getMessages")
    public MessageDTO manageMessages(MessageDTO messageDTO) {
    	System.out.println("Mensagem recebida via WebSocket: " + messageDTO.toString());
    	Message message = messageService.saveMessage(new Message(messageDTO));
        return new MessageDTO(message);
    }

    
    public void saveMessage(MessageDTO messageDTO) {
    	System.out.println(messageDTO);
        messageService.saveMessage(new Message(messageDTO));
    }

    @PostMapping("/saveUser")
    public ResponseEntity<Object> saveUser(@RequestBody UserDTO userDTO) {
        try {
            Optional<User> user = userService.createUser(new User(userDTO));
            if(user.isPresent()) {
                UserDTO newUser = new UserDTO(user.get());
                return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
            }
            System.out.println("Erro 1");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception err) {
        	System.out.println("Erro 2");
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            		new ControllerError("Username already use")
            );
        }
        
    }
}
