package com.example.EvenDecor.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_progress")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventProgressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ep")
    private Integer idEp;

    // 0: sự cố, 1: khảo sát, 2: setup, 3: trang trí, 4: hoàn thiện
    @Column(name = "step")
    private Integer step;

    @Column(name = "updated_by", length = 250)
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "description", columnDefinition = "NVARCHAR(MAX)")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_b", nullable = false)
    private BookingModel booking;
}
