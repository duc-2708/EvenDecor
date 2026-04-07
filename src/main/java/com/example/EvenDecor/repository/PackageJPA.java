package com.example.EvenDecor.repository;

import com.example.EvenDecor.model.CategoryModel;
import com.example.EvenDecor.model.PackagesModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageJPA extends JpaRepository<PackagesModel, Integer> {
    Page<PackagesModel> findAllByCategory_Id(Integer categoryId, Pageable pageable);
}
