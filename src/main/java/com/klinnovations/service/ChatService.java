package com.klinnovations.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klinnovations.entity.Message;
import com.klinnovations.repository.MessageRepository;

@Service
public class ChatService {
    @Autowired
    private MessageRepository messageRepository;

    // Save a new message
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    // Retrieve all messages
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    // Update an existing message
    public Message updateMessage(Long id, Message message) {
        Optional<Message> existingMessage = messageRepository.findById(id);
        if (existingMessage.isPresent()) {
            message.setId(id); // Ensure the ID is set for the update
            return messageRepository.save(message);
        }
        throw new RuntimeException("Message not found with ID: " + id);
    }

    // Delete a message
    public void deleteMessage(Long id) {
        if (messageRepository.existsById(id)) {
            messageRepository.deleteById(id);
        } else {
            throw new RuntimeException("Message not found with ID: " + id);
        }
    }
}
