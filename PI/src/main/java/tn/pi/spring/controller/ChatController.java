package tn.pi.spring.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.pi.spring.entity.ChatMessage;
import tn.pi.spring.entity.Message;
import tn.pi.spring.entity.User;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/chat")
public class ChatController {
	@MessageMapping("/hello")
	@SendTo("/topic/hi")
	public Message greeting(User user) throws Exception {
	    return new Message("Hi, " + user.getFirstName() + "!", null);
	}
}
	