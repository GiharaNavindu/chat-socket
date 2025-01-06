package com.example.demo.Controllers;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {


    //the web scket endpoint is /app/sendMessage
    @MessageMapping("/sendMessage") //like Get/P ostmapping in the webendpoints for web sockets to access by the stomp clients
    @SendTo("/topic/notification")/// the msg will only visble to this brooker
    public String sendMessage(String message) {
        return message;//just  returning the message  and message will be sent to tje broker
    }
}
