package com.app.reservas.controller;

import com.app.reservas.entities.Message;
import com.app.reservas.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll() {
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> getById(@PathVariable("id") int id) {
        return messageService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message p) {
        return messageService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message p) {
        return messageService.update(p);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id")int id){
        return messageService.delete(id);
    }
}
