package com.app.reservas.repository;

import com.app.reservas.entities.Category;
import com.app.reservas.repository.crudRepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categorycrudRepository;

    public List<Category> getAll() {
        return (List<Category>) categorycrudRepository.findAll();
    }

    public Optional<Category> getById(int id) {
        return categorycrudRepository.findById(id);
    }

    public Category save(Category p) {
        return categorycrudRepository.save(p);
    }

    public void delete(Category p) {
        categorycrudRepository.delete(p);
    }
}
