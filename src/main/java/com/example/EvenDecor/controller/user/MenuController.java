package com.example.EvenDecor.controller.user;

import com.example.EvenDecor.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/EvenDecor/menu")
public class MenuController {
    @Autowired
    CategoryService cateSer;
}
