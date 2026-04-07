package com.example.EvenDecor.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_i")
    private Integer idI;

    @Column(name = "name", length = 250)
    private String name;

    @Column(name = "type")
    private Integer type;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "status")
    private Integer status;

    // Đơn vị: cái, chiếc,...
    @Column(name = "unit", length = 250)
    private String unit;
}
