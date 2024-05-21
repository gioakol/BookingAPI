package com.app.reservas.repository.crudRepository;

import com.app.reservas.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> { }
