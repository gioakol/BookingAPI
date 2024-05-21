package com.app.reservas.repository;

import com.app.reservas.repository.crudRepository.ClientCrudRepository;
import com.app.reservas.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getById(int id) {
        return clientCrudRepository.findById(id);
    }

    public boolean getByEmail(String email) {
        List<Client> data = clientCrudRepository.getByEmail(email);
        if (data.size() != 0){
            return true;
        }
        else {
            return false;
        }
    }

    public List<Client>  getByEmailAndPassword(String email, String password) {
        List<Client> data = clientCrudRepository.getByEmailAndPassword(email, password);
        return data;
    }

    public Client save(Client p) {
        return clientCrudRepository.save(p);
    }

    public void delete(Client p) {
        clientCrudRepository.delete(p);
    }
}
