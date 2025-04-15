package com.ashok.whiteboard.controller;

import com.ashok.whiteboard.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/chat.join")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message message) {
        // Set message type as JOIN
        message.setType(Message.MessageType.JOIN);
        message.setContent(message.getSender() + " joined the chat!");
        return message;
    }

    @MessageMapping("/chat.leave")
    @SendTo("/topic/public")
    public Message removeUser(@Payload Message message) {
        // Set message type as LEAVE
        message.setType(Message.MessageType.LEAVE);
        message.setContent(message.getSender() + " left the chat!");
        return message;
    }
}
