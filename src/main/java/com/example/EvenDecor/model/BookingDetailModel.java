package com.example.EvenDecor.model;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "booking_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookingDetailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bd")
    private Integer idBd;

    @Column(name = "price", precision = 18, scale = 2)
    private BigDecimal price;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_p", nullable = false)
    private PackagesModel packages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_b", nullable = false)
    private BookingModel booking;
}
