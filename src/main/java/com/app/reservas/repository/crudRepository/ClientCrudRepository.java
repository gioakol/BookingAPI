package com.app.reservas.repository.crudRepository;

import com.app.reservas.entities.Client;
import com.app.reservas.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientCrudRepository extends CrudRepository<Client, Integer> {
    public List<Client> getByEmail (String email);
    public List<Client> getByEmailAndPassword (String email, String password);

}
