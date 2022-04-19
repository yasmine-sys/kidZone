package tn.pi.spring.control;



import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import tn.pi.spring.entity.Message;


@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message Message) {
        return Message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message Message,
                               SimpMessageHeaderAccessor headerAccessor) {
       //  Add username in web socket session
        headerAccessor.getSessionAttributes().put("username" , Message.getSender());
        return Message;
    }

}
