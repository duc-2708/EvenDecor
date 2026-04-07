package com.example.EvenDecor.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item_reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ItemReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ir")
    private Integer idIr;

    @Column(name = "reserver_quanlity")
    private Integer reserverQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_b", nullable = false)
    private BookingModel booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ip", nullable = false)
    private ItemPackageModel itemPackages;
}
