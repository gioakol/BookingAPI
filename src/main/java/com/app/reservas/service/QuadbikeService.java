package com.app.reservas.service;

import com.app.reservas.entities.Quadbike;
import com.app.reservas.repository.QuadbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuadbikeService {
    @Autowired
    private QuadbikeRepository quadbikeRepository;

    public List<Quadbike> getAll(){
        return quadbikeRepository.getAll();
    }

    public Optional<Quadbike> getById(int id) {
        return quadbikeRepository.getById(id);
    }

    public Quadbike save(Quadbike p) {
        if (p.getId() != null) {
            Optional<Quadbike> e = quadbikeRepository.getById(p.getId());
            if (e.isPresent()){
                return e.get();
            }
            else{
                return quadbikeRepository.save(p);
            }
        } else {
            return quadbikeRepository.save(p);
        }
    }

    public Quadbike update(Quadbike p) {
        if(p.getId() != null) {
            Optional<Quadbike> e = quadbikeRepository.getById(p.getId());
            if (e.isPresent()){
                if(p.getName() != null) {
                    e.get().setName(p.getName());
                }
                if(p.getBrand() != null) {
                    e.get().setBrand(p.getBrand());
                }
                if(p.getYear() != null) {
                    e.get().setYear(p.getYear());
                }
                if(p.getDescription() != null) {
                    e.get().setDescription(p.getDescription());
                }
                if(p.getCategory() != null) {
                    e.get().setCategory(p.getCategory());
                }
                quadbikeRepository.save(e.get());
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
        Optional<Quadbike> e = quadbikeRepository.getById(id);
        if (e.isPresent()) {
            quadbikeRepository.delete(e.get());
            res = true;
        }
        return res;
    }
}
