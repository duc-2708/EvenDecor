package com.example.EvenDecor.controller.admin;

import com.example.EvenDecor.model.CategoryModel;
import com.example.EvenDecor.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("EvenDecor/admin/category")
public class AdCate {
    @Autowired
    CategoryService cateSer;

    @GetMapping
    public Page<Map<String, Object>> getAllCate(Pageable pageable) {
        return cateSer.getAllCategory(pageable);
    }

    @PostMapping
    public CategoryModel createCate(CategoryModel cate){
        return cateSer.addCategory(cate);
    }

    @GetMapping("/{id}")
    public Optional<Map<String, Object>> getCategoryById(@PathVariable int id){
        return cateSer.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public CategoryModel updateCate(CategoryModel cate, @PathVariable int id){
        return cateSer.updateCategory(cate, id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){
        // test git commit
        cateSer.deleteCategory(id);
    }
}
