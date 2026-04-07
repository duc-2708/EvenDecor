package com.example.EvenDecor.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EvenDecor.model.UserModel;

public interface AuthJPA extends JpaRepository<UserModel, Integer>{
	Optional<UserModel> findByEmail(String email); //tìm theo email
	Boolean existsByEmail(String email); //check email tồn tại
}
