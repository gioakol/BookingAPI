package com.app.reservas.controller;

import com.app.reservas.entities.Client;
import com.app.reservas.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getById(@PathVariable("id") int id) {
        return clientService.getById(id);
    }

    @GetMapping("/email/{email}")
    public boolean getByEmail(@PathVariable("email") String email) {
        return clientService.getByEmail(email);
    }

    @GetMapping("/user/{email}/{password}")
    public List<Client> getByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
        return clientService.getByEmailAndPassword(email, password);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client p) {
        return clientService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client p) {
        return clientService.update(p);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id")int id){
        return clientService.delete(id);
    }
}
