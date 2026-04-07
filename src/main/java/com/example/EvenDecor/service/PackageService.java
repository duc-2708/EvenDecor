package com.example.EvenDecor.service;

import com.example.EvenDecor.model.CategoryModel;
import com.example.EvenDecor.model.ImgPackageModel;
import com.example.EvenDecor.model.PackagesModel;
import com.example.EvenDecor.repository.PackageJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PackageService {
    @Autowired
    PackageJPA repo;

    public Page<Map<String, Object>> getAllPackages(Pageable pageable, Integer idC) {
        Page<PackagesModel> pakages = repo.findAllByCategory_Id(idC, pageable);
        return pakages.map(data -> {
            Map<String, Object> map = new HashMap<>();
            map.put("pakagesId", data.getId());
            map.put("pakageName", data.getName());
            map.put("note", data.getNote());
            map.put("price", data.getPrice());

            String mainImg = data.getImg().stream()
                    .filter(img -> img.getType() ==1)
                    .map(ImgPackageModel::getUrl)
                    .findFirst().orElse("");
            map.put("mainImg", mainImg);

            return map;
        });
    }

    public PackagesModel createPackages(PackagesModel packagesModel) {
        return repo.save(packagesModel);
    }

    public Optional<Map<String, Object>> getPackageById(Integer id) {
        Optional<PackagesModel> packagesModel = repo.findById(id);
        return packagesModel.map(data ->{
            Map<String, Object> map = new HashMap<>();
            map.put("pakagesId", data.getId());
            map.put("pakageName", data.getName());
            map.put("note", data.getNote());
            map.put("price", data.getPrice());

            List<String> imgUrl = data.getImg().stream()
                    .map(ImgPackageModel::getUrl)
                    .collect(Collectors.toList());
            map.put("imgUrl", imgUrl);
            return map;
        });
    }

    public PackagesModel updatePackages(PackagesModel packagesModel, Integer id) {
        packagesModel.setId(id);
        return repo.save(packagesModel);
    }

    public void deletePackage(Integer id) {
        repo.deleteById(id);
    }
}
