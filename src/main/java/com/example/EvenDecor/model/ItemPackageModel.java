package com.example.EvenDecor.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item_packages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemPackageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ip")
    private Integer idIp;

    @Column(name = "item_quantity")
    private Integer itemQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_p", nullable = false)
    private PackagesModel packages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_i", nullable = false)
    private ItemModel item;
}
