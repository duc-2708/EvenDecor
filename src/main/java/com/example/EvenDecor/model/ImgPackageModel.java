package com.example.EvenDecor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor	
@NoArgsConstructor
@Table (name = "img_packages")
public class ImgPackageModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_img")
	private Integer idImg;

	@Column(name = "url", length = 500)
	private String url;

	// 0: ảnh phụ, 1: ảnh chính
	@Column(name = "type")
	private Integer type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_p", nullable = false)
	private PackagesModel packages;

}
