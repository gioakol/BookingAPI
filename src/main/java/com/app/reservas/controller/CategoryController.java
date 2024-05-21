package com.app.reservas.controller;

import com.app.reservas.entities.Category;
import com.app.reservas.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getById(@PathVariable("id") int id) {
        return categoryService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category p) {
        return categoryService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category p) {
        return categoryService.update(p);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id")int id){
        return categoryService.delete(id);
    }
}
