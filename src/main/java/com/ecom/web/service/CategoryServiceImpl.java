package com.ecom.web.service;

import com.ecom.web.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    public Category getCategory(Integer id) {
        Category category = new Category();
        category.setCategoryName("Cat"+id);
        category.setCategoryId(Long.valueOf(id));
        return category;
    }

    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(getCategory(1));
        categories.add(getCategory(2));
        return categories;
    }

    public String putCategory(Category category) {
        return "Category added successfully";
    }
}
