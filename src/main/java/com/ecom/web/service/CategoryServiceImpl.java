package com.ecom.web.service;

import com.ecom.web.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    List<Category> categoryList = new ArrayList<>();

    public Category getCategory(Integer id) {
        Category category1 =  categoryList.stream().filter(category -> category.getCategoryId().equals(id.longValue()))
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
       return category1;
    }

    public List<Category> getCategories() {
        return categoryList;
    }

    public String addCategory(Category category) {
        categoryList.add(category);
        return "Category added successfully";
    }

    @Override
    public String deleteCategory(Integer id) {
        String message;
        Category category = getCategory(id);
        categoryList.remove(category);
        message = "Category with id " + id + " deleted successfully";
        return message;
    }
}
