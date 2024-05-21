package com.app.reservas.service;

import com.app.reservas.entities.Category;
import com.app.reservas.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getById(int id){
        return categoryRepository.getById(id);
    }

    public Category save(Category p) {
        if (p.getId() != null) {
            Optional<Category> e = categoryRepository.getById(p.getId());
            if (e.isPresent()){
                return e.get();
            }
            else{
                return categoryRepository.save(p);
            }
        } else {
            return categoryRepository.save(p);
        }
    }

    public Category update(Category p) {
        if(p.getId() != null) {
            Optional<Category> e = categoryRepository.getById(p.getId());
            if (e.isPresent()){
                if(p.getName() != null) {
                    e.get().setName(p.getName());
                }
                if(p.getDescription() != null) {
                    e.get().setDescription(p.getDescription());
                }
                categoryRepository.save(e.get());
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
        Optional<Category> e = categoryRepository.getById(id);
        if (e.isPresent()) {
            categoryRepository.delete(e.get());
            res = true;
        }
        return res;
    }
}
