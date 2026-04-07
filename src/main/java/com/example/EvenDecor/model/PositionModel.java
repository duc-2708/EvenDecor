package com.example.EvenDecor.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "position")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PositionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pos")
    private Integer idPos;

    // VD: Setup, Trang trí, Âm thanh, Hình ảnh
    @Column(name = "name", length = 100)
    private String name;
}
