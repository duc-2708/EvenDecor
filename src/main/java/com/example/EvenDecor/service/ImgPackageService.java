package com.example.EvenDecor.service;

import com.example.EvenDecor.model.ImgPackageModel;
import com.example.EvenDecor.repository.ImgPackageJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ImgPackageService {
    @Autowired
    ImgPackageJPA repo;

    public Page<Map<String, Object>> getAllImgPackages(Pageable pageable, Integer idP) {
        Page<ImgPackageModel> imgPackages = repo.findAllByPackagesModel_Id(idP, pageable);
        return imgPackages.map(data -> {
            Map<String, Object> map = new HashMap<>();
            map.put("imgId", data.getIdImg());
            map.put("url", data.getUrl());
            map.put("type", data.getType());
            return map;
        });
    }

    public ImgPackageModel createImgPackages(ImgPackageModel imgPackagesModel) {
        return repo.save(imgPackagesModel);
    }

    public Optional<Map<String, Object>> getImgPackageById(Integer id) {
        Optional<ImgPackageModel> imgPackages = repo.findById(id);
        return imgPackages.map(data -> {
            Map<String, Object> map = new HashMap<>();
            map.put("imgId", data.getIdImg());
            map.put("url", data.getUrl());
            map.put("type", data.getType());
            return map;
        });
    }

    public ImgPackageModel updateImgPackages(ImgPackageModel imgPackagesModel, Integer id) {
        imgPackagesModel.setIdImg(id);
        return repo.save(imgPackagesModel);
    }

    public void deleteImgPackage(Integer id) {
        repo.deleteById(id);
    }
}
