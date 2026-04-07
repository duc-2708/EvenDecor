package com.example.EvenDecor.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "packages")
public class PackagesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_p")
	private Integer id;

	@Column(name = "name", length = 250)
	private String name;

	@Column(name = "note", columnDefinition = "NVARCHAR(MAX)")
	private String note;

	@Column(name = "price", precision = 18, scale = 2)
	private BigDecimal price;

	@Column(name = "status")
	private Integer status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_c")
	private CategoryModel category;

	@JsonIgnore
	@OneToMany(mappedBy = "packages", fetch = FetchType.LAZY)
	private List<ImgPackageModel> img;
}