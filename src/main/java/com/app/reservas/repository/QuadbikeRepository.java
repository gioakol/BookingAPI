package com.app.reservas.repository;

import com.app.reservas.repository.crudRepository.QuadbikeCrudRepository;
import com.app.reservas.entities.Quadbike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class QuadbikeRepository {
    @Autowired
    private QuadbikeCrudRepository quadbikeCrudRepository;

    public List<Quadbike> getAll() {
        return (List<Quadbike>) quadbikeCrudRepository.findAll();
    }

    public Optional<Quadbike> getById(int id) {
        return quadbikeCrudRepository.findById(id);
    }

    public Quadbike save(Quadbike p) {
        return quadbikeCrudRepository.save(p);
    }

    public void delete(Quadbike p) {
        quadbikeCrudRepository.delete(p);
    }
}
