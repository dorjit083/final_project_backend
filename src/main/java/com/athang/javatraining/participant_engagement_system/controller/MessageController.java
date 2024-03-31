package com.athang.javatraining.participant_engagement_system.controller;

import com.athang.javatraining.participant_engagement_system.model.Message;
import com.athang.javatraining.participant_engagement_system.service.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentMessage")
public class MessageController {

    private final MessageServices messageServices;

    @Autowired
    public MessageController(MessageServices messageServices) {
        this.messageServices = messageServices;
    }

    @PostMapping("/addMessage")
    public Message addMessage(@RequestBody Message message) {
        return messageServices.addMessage(message);
    }
    @GetMapping("/deleteMessage")
    public String deleteMessage(@PathVariable int id){
        return messageServices.deleteMessage(id);
    }
    @GetMapping("/getAllMessage")
    public List<Message> getAllMessage(){
        return messageServices.getAllMessage();
    }

}
