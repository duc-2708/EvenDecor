package com.example.EvenDecor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cus")
    private Integer idCus;

    @Column(name = "name", length = 250)
    private String name;

    @Column(name = "email", length = 250)
    private String email;

    private String pass;

    @Column(name = "number_phone", length = 10)
    private String numberPhone;

    @Column(name = "place", length = 250)
    private String place;

    // 0: thường, 1: quay lại, 2: VIP
    @Column(name = "type")
    private Integer type;

    @Column(name = "note", length = 250)
    private String note;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "status")
    private Integer status;
}
