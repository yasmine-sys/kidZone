package tn.pi.spring.control;



import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.pi.spring.entity.ChatMessage;
@RestController
@RequestMapping("/chat")
@Api(tags = "Gestion chat")
public class ChatController {
	@GetMapping("test")
	public void test() {
		
	}
	@GetMapping("hello")
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessagePojo) {
		
		return chatMessagePojo;
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessagePojo, SimpMessageHeaderAccessor headerAccessor) {

		// Add username in web socket session
		headerAccessor.getSessionAttributes().put("username", chatMessagePojo.getSender());
		return chatMessagePojo;
	}

}
