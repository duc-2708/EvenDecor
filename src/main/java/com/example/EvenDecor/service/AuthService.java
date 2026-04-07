package com.example.EvenDecor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.EvenDecor.model.UserModel;
import com.example.EvenDecor.repository.AuthJPA;

@Service
public class AuthService {
	@Autowired
	AuthJPA auth;

	@Autowired
	private PasswordEncoder Bry;

	private String hashPass(String pass) {
		String hassPass = Bry.encode(pass); // mã hóa pass vd: 123 => qdwohqu123aokdj
		return hassPass;
	}

	private boolean checkHassPass(String pass, String hashPass) {
		boolean check = Bry.matches(pass, hashPass); // đọc mã hóa pass khi được gưir đến
		return check;
	}

	public UserModel login(String email, String pass) {
		Optional<UserModel> user = auth.findByEmail(email);
		if(user.isPresent()) {
			UserModel u = user.get();
			if(checkHassPass(pass, u.getPass())) {
				return u;
			}
		}
		return null;
	}

	public boolean signUp(UserModel u) {
		if (auth.existsByEmail(u.getEmail())) {
			return false; // nếu email đã tồn tại return false
		}
		try {
			String hashPass = hashPass(u.getPass());
			u.setPass(hashPass);
			u.setRole(2);
			auth.save(u);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
