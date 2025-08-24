package com.ecom.web.controller;

import com.ecom.web.model.Category;
import com.ecom.web.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/api/public/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Integer id) {
        try {
            Category category = categoryService.getCategory(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }

    }

    @GetMapping("/api/public/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("api/admin/category")
    public String putCategory(@RequestBody Category category) {
        return categoryService.putCategory(category);
    }

    @DeleteMapping("api/admin/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
        try {
            String status =  categoryService.deleteCategory(id);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
}
