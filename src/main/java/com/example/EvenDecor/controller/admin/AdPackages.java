package com.example.EvenDecor.controller.admin;

import com.example.EvenDecor.model.PackagesModel;
import com.example.EvenDecor.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("EvenDecor/admin/packages")
public class AdPackages {
    @Autowired
    PackageService packageSer;

    @GetMapping("/{idC}")
    public Page<Map<String, Object>> getAllPackages(Pageable pageable, @PathVariable Integer idC) {
        return packageSer.getAllPackages(pageable, idC);
    }

    @PostMapping()
    public PackagesModel addPackages(@RequestBody PackagesModel packagesModel) {
        return packageSer.createPackages(packagesModel);
    }//chưa xong đâu (tìm cách thêm ảnh ở đây thì mới put thnafh công)

    @GetMapping("/{id}")
    public Optional<Map<String, Object>> getPackages(@PathVariable Integer id) {
        return packageSer.getPackageById(id);
    }

    @PutMapping("/{id}")
    public PackagesModel updatePackages(PackagesModel packages, @PathVariable int id){
        return packageSer.updatePackages(packages, id);
    }

    @DeleteMapping("/{id}")
    public void deletePackages(@PathVariable int id){
        packageSer.deletePackage(id);
    }
}
