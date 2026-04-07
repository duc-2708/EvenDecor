package com.example.EvenDecor.model;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoice")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class InvoiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inv")
    private Integer idInv;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    // 0: chưa thanh toán, 1: đã thanh toán
    @Column(name = "status")
    private Integer status;

    // 0: thanh toán đủ, 1: trả trước (cọc)
    @Column(name = "method")
    private Integer method;

    @Column(name = "total_price", precision = 18, scale = 2)
    private BigDecimal totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private UserModel user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_b", nullable = false)
    private BookingModel booking;
}
