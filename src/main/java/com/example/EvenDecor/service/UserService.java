package com.example.EvenDecor.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.EvenDecor.model.UserModel;
import com.example.EvenDecor.repository.UserJPA;

@Service
public class UserService {
	@Autowired
	UserJPA repo;

	public Page<Map<String, Object>> getAllUser(Pageable pageable) {
		Page<UserModel> users = repo.findAll(pageable);
		return users.map(data -> {
			Map<String, Object> map = new HashMap<>();
			map.put("userId", data.getId());
			map.put("userName", data.getName());
			map.put("email", data.getEmail());
			map.put("pass", data.getPass());
			map.put("phone", data.getPhone());
			map.put("place", data.getPlace());
			map.put("createdAt", data.getCreatedAt());
			return map;
		});
	}

	public UserModel createUsers(UserModel user) {
		return repo.save(user);
	}

	public Optional<Map<String, Object>> getUserById(Integer id){
		Optional<UserModel> user = repo.findById(id);
		return user.map(data -> {
			Map<String, Object> map = new HashMap<>();
			map.put("userId", data.getId());
			map.put("userName", data.getName());
			map.put("email", data.getEmail());
			map.put("pass", data.getPass());
			map.put("phone", data.getPhone());
			map.put("place", data.getPlace());
			map.put("createdAt", data.getCreatedAt());
			return map;
		});
	}

	public UserModel updateUser(Integer id, UserModel user) {
		Optional<UserModel> userUpdate = repo.findById(id);
		if (userUpdate.isPresent()) {
			userUpdate.get().setName(user.getName());
			userUpdate.get().setEmail(user.getEmail());
			userUpdate.get().setPass(user.getPass());
			userUpdate.get().setPhone(user.getPhone());
			userUpdate.get().setPlace(user.getPlace());
			userUpdate.get().setCreatedAt(user.getCreatedAt());
			return repo.save(userUpdate.get());
		}else {
			return null;
		}
	}

	public void deleteUser(Integer id) {
		repo.deleteById(id);
	}
}
