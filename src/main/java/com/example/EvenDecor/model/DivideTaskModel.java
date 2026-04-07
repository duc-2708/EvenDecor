package com.example.EvenDecor.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "divide_task")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DivideTaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dt")
    private Integer idDt;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    // 0: chưa, 1: đang làm, 2: hoàn thành
    @Column(name = "status")
    private Integer status;

    @Column(name = "description", columnDefinition = "NVARCHAR(MAX)")
    private String description;

    @Column(name = "place_task", length = 250)
    private String placeTask;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private UserModel user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_b", nullable = false)
    private BookingModel booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pos", nullable = false)
    private PositionModel position;
}
