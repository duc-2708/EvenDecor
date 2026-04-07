package com.example.EvenDecor.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "category")
public class CategoryModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_c")
	private Integer id;
	private String url;
	private String category;
	@Column(name = "status")
	private Integer status;

	@OneToMany(mappedBy = "category")
	private List<PackagesModel> packages;
}
