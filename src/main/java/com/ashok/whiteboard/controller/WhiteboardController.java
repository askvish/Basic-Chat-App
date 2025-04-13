package com.ashok.whiteboard.controller;

import com.ashok.whiteboard.model.DrawAction;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhiteboardController {

    @MessageMapping("/draw") // from client: /app/draw
    @SendTo("/topic/updates") // to client: /topic/updates
    public DrawAction broadcastDraw(DrawAction action) {
        return action;
    }
}
