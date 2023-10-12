package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired(required = true)
    private MessageRepository MessageDAO;

    public Message createMessage(Message message) {
        return MessageDAO.save(message);
    }

    public List<Message> getAllMessages() {
        return MessageDAO.findAll();
    }

    public Message getMessageById(Integer id) {
        return MessageDAO.findById(id).orElse(null);
    }

    public Integer deleteMessageById(Integer id) {
        MessageDAO.deleteById(id);
        return 1;
    }

    public Integer updateMessage(Message message, Message messageDB) {
        messageDB.setMessage_text(message.getMessage_text());
        MessageDAO.save(messageDB);
        return 1;
    }

    public List<Message> getUserMessages(Integer account_id) {
        return MessageDAO.findByPostedBy(account_id);
    }
}
