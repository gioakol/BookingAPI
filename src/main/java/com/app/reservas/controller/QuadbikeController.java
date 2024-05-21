package com.app.reservas.controller;

import com.app.reservas.entities.Quadbike;
import com.app.reservas.service.QuadbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Quadbike")
@CrossOrigin(origins = "*")
public class QuadbikeController {
    @Autowired
    private QuadbikeService quadbikeService;

    @GetMapping("/all")
    public List<Quadbike> getAll() {
        return quadbikeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Quadbike> getById(@PathVariable("id") int id) {
        return quadbikeService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike save(@RequestBody Quadbike p) {
        return quadbikeService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike update(@RequestBody Quadbike p) {
        return quadbikeService.update(p);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id")int id){
        return quadbikeService.delete(id);
    }
}
