package com.example.EvenDecor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.EvenDecor.model.UserModel;

@Repository
public interface UserJPA extends JpaRepository<UserModel, Integer>{
}
