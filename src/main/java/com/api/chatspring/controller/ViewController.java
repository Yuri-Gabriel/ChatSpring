package com.api.chatspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {
    @GetMapping
    public String indexView() {
        return "index";
    }
    @GetMapping("/chat")
    public String chatView() {
        return "chat";
    }
}
