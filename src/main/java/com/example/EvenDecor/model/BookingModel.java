package com.example.EvenDecor.model;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_b")
    private Integer idB;

    @Column(name = "even_date")
    private LocalDate evenDate;

    // 0: sáng, 1: trưa, 2: chiều, 3: tối
    @Column(name = "event_time")
    private Integer eventTime;

    @Column(name = "place", length = 250)
    private String place;

    @Column(name = "note", columnDefinition = "NVARCHAR(MAX)")
    private String note;

    @Column(name = "total_price", precision = 18, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cus", nullable = false)
    private CustomerModel customer;
}
