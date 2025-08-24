package com.ecom.web.service;

import com.ecom.web.model.Category;

import java.util.List;

public interface CategoryService {

    Category getCategory(Integer id);
    List<Category> getCategories();
    String putCategory(com.ecom.web.model.Category category);
    String deleteCategory(Integer id);
}
