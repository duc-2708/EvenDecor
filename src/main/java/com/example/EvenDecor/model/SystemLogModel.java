package com.example.EvenDecor.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "system_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemLogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sl")
    private Integer idSl;

    // 0: thêm, 1: sửa, 2: xóa
    @Column(name = "action")
    private Integer action;

    @Column(name = "context", columnDefinition = "NVARCHAR(MAX)")
    private String context;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private UserModel user;
}
