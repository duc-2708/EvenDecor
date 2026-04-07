package com.example.EvenDecor.controller.admin;

import com.example.EvenDecor.service.ImgPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("EvenDecor/admin/packagesImg")
public class AdImg {
    @Autowired
    ImgPackageService imgSer;

    @GetMapping("/{idP}")
    public Page<Map<String, Object>> getAllImg(Pageable pageable, Integer idP) {
        return imgSer.getAllImgPackages(pageable, idP);
    }
}
