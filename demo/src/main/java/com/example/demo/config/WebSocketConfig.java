package com.example.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");//prefix for whare the msgs wil be broadcasted(FOr broadcasting)
        //for multiple channels- /channels/cricket and /topic/hockey
        config.setApplicationDestinationPrefixes("/app");//prefix for endpoint url(for client to get the msg from the endpoint)
        //for multiple /app/<url>
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {//all the stomp endpoints configurations
        registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();//defines the web socket endpoints that client use to establish the connection
    }
}
