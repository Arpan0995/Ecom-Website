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
@RequestMapping("/api/")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("public/category/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Integer id) {
        try {
            Category category = categoryService.getCategory(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }

    }

    @GetMapping("public/categories")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories =  categoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("admin/category")
    public ResponseEntity<String> addCategory(@RequestBody Category category) {
        try {
            String message = categoryService.addCategory(category);
            return new ResponseEntity<>(message,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("admin/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
        try {
            String status =  categoryService.deleteCategory(id);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    @PutMapping("admin/category/update")
    public ResponseEntity<String> updateCategory(@RequestBody Category category) {
        try {
            String message = categoryService.updateCategory(category);
            return new ResponseEntity<>(message,HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

}
