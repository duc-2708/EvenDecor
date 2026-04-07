package com.example.EvenDecor.repository;

import com.example.EvenDecor.model.CategoryModel;
import com.example.EvenDecor.model.PackagesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryJPA extends JpaRepository<CategoryModel, Integer> {
}
