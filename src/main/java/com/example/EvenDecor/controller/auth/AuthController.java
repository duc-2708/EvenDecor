package com.example.EvenDecor.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.EvenDecor.model.UserModel;
import com.example.EvenDecor.service.AuthService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/EvenDecor")
public class AuthController {
	@Autowired
	AuthService Authser;

	@GetMapping("/login")
	public String viewLogin(Model model) {
		model.addAttribute("content", "view/user_view/login");
		return "layout/admin_base";
	}

	@PostMapping("/check")
	public String login(@RequestParam String email, @RequestParam String pass, RedirectAttributes red,
			HttpSession session) {
		UserModel user = Authser.login(email, pass);
		if (user == null) {
			red.addFlashAttribute("er", "Sai thông tin đăng nhập");
			return "redirect:/EvenDecor/login";
		}
		session.setAttribute("user", user); //
		if (user.getRole() == 0) {
			return "layout/admin_base";
		} else if (user.getRole() == 1) {
			return "layout/user_base";
		} else if (user.getRole() == 2) {
			return "layout/user_base";
		} else {
			red.addFlashAttribute("er", "Sai thông tin đăng nhập");
			return "redirect:/EvenDecor/login";
		}
	}

	@GetMapping("/signUp")
	public String viewSignUp(Model model) {
		model.addAttribute("userModel", new UserModel());
		model.addAttribute("content", "view/user_view/sign-up");
		return "layout/admin_base";
	}

	@PostMapping("/signUpForm")
	public String signUp(@Valid @ModelAttribute("userModel") UserModel user, BindingResult bin, Model model,
			RedirectAttributes red) {
		if (bin.hasErrors()) {
			model.addAttribute("content", "view/sign-up");
			return "layout/admin_base";
		}
		boolean ketQua = Authser.signUp(user);
		if (ketQua) {
			red.addFlashAttribute("success", "tạo tài khoản thành công");
			return "redirect:/EvenDecor/signUp";
		}
		red.addFlashAttribute("er", "tạo tài khoản thất bại");
		return "redirect:/EvenDecor/signUp";
	}

	@GetMapping("/logOut")
	public String logOut(@RequestParam String param) {
		return new String();
	}

}
