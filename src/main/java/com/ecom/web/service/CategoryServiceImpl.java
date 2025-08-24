package com.ecom.web.service;

import com.ecom.web.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    List<Category> categoryList = new ArrayList<>();

    public Category getCategory(Integer id) {
        Category category1 =  categoryList.stream().filter(category -> category.getCategoryId().equals(id.longValue()))
                .findFirst().orElse(null);
        if (category1 == null) {
            return null;
        } else {
            return category1;
        }
    }

    public List<Category> getCategories() {
        return categoryList;
    }

    public String putCategory(Category category) {
        categoryList.add(category);
        return "Category added successfully";
    }

    @Override
    public String deleteCategory(Integer id) {
        String message;
        Category category = getCategory(id);
        if (category != null) {
            categoryList.remove(category);
            message = "Category deleted successfully";
        } else {
            message = "Category not found";
        }
        return message;
    }
}
