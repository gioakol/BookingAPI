package com.app.reservas.repository;

import com.app.reservas.entities.Message;
import com.app.reservas.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll() {
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getById(int id) {
        return messageCrudRepository.findById(id);
    }

    public Message save(Message p) {
        return messageCrudRepository.save(p);
    }

    public void delete(Message p) {
        messageCrudRepository.delete(p);
    }
}
