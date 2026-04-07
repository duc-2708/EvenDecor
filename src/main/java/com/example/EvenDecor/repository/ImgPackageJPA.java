package com.example.EvenDecor.repository;

import com.example.EvenDecor.model.ImgPackageModel;
import com.example.EvenDecor.model.PackagesModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgPackageJPA extends JpaRepository<ImgPackageModel, Integer> {
    Page<ImgPackageModel> findAllByPackagesModel_Id(Integer id, Pageable pageable);
}
