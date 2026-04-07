package com.example.EvenDecor.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PaymentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pay")
    private Integer idPay;

    @Column(name = "price", precision = 18, scale = 2)
    private BigDecimal price;

    @Column(name = "method")
    private Integer method;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inv", nullable = false)
    private InvoiceModel invoice;
}
