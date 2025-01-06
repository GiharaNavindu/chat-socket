package com.example.demo.Controllers;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {


    //the web scket endpoint is 
    @MessageMapping("/sendMessage") //like Get/P ostmapping in the webendpoints for web sockets to access by the stomp clients
    public String sendMessage(String message) {
        return message;//just  returning the message
    }
}
