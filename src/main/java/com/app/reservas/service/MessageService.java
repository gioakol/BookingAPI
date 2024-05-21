package com.app.reservas.service;

import com.app.reservas.entities.Message;
import com.app.reservas.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getById(int id) {
        return messageRepository.getById(id);
    }

    public Message save(Message p) {
        if (p.getIdMessage() != null) {
            Optional<Message> e = messageRepository.getById(p.getIdMessage());
            if (e.isPresent()){
                return e.get();
            }
            else{
                return messageRepository.save(p);
            }
        } else {
            return messageRepository.save(p);
        }
    }

    public Message update(Message p) {
        if(p.getIdMessage() != null) {
            Optional<Message> e = messageRepository.getById(p.getIdMessage());
            if (e.isPresent()){
                if(p.getMessageText()!=null){
                    e.get().setMessageText(p.getMessageText());
                }
                messageRepository.save(e.get());
                return e.get();
            }
            else{
                return p;
            }
        }
        else {
            return p;
        }
    }

    public boolean delete(int id) {
        boolean res = false;
        Optional<Message> e = messageRepository.getById(id);
        if (e.isPresent()) {
            messageRepository.delete(e.get());
            res = true;
        }
        return res;
    }
}
