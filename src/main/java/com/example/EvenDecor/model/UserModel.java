package com.example.EvenDecor.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Integer id;

	@NotNull(message = "Vui lòng điền đầy đủ họ tên")
	private String name;

	@NotNull(message = "Vui lòng nhập đầy đủ email của bạn")
	private String email;

	@NotNull(message = "Vui lòng nhập đầy đủ mật khẩu của bạn")
	private String pass;

	@Column(name = "number_phone")
	private String phone;

	@NotNull(message = "Vui lòng nhập đầy đủ địa chỉcủa bạn")
	private String place;

	private Integer role;

	@CreationTimestamp //tự cập nhập thời gian khi tạo bản ghi trong sql
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "status")
	private Integer status;
}