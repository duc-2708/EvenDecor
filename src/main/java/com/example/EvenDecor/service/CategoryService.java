package com.example.EvenDecor.service;

import com.example.EvenDecor.model.CategoryModel;
import com.example.EvenDecor.repository.CategoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryJPA repo;
    public Page<Map<String, Object>> getAllCategory(Pageable pageable) {
        Page<CategoryModel> category = repo.findAll(pageable);
        return category.map(data -> {
            Map<String, Object> map = new HashMap<>();
            map.put("categoryId", data.getId());
            map.put("category", data.getCategory());
            map.put("url", data.getUrl());
            return map;
        });
    }

    public CategoryModel addCategory(CategoryModel category) {
        return repo.save(category);
    }

    public Optional<Map<String, Object>> getCategoryById(int id) {
        Optional<CategoryModel> category = repo.findById(id);
        return category.map(data -> {
            Map<String, Object> map = new HashMap<>();
            map.put("categoryId", data.getId());
            map.put("category", data.getCategory());
            map.put("url", data.getUrl());
            return map;
        });
    }

    public CategoryModel updateCategory(CategoryModel category, Integer id) {
        category.setId(id);
        return repo.save(category);
    }

    public void deleteCategory(int id) {
        repo.deleteById(id);
    }
}
