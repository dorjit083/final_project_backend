package com.athang.javatraining.participant_engagement_system.service;

import com.athang.javatraining.participant_engagement_system.model.Message;
import com.athang.javatraining.participant_engagement_system.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServices {
    @Autowired
    private MessageRepository messageRepository;

    public Message addMessage(Message message){
        return messageRepository.save(message);
    }

    public List<Message> getAllMessage(){
        return messageRepository.findAll();
    }

    public String deleteMessage(int id){
        messageRepository.deleteById(id);
        return "Message Deleted";
    }
}
