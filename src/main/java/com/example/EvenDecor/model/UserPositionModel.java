package com.example.EvenDecor.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_position")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserPositionModel {
    @EmbeddedId
    private UserPositionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUser")
    @JoinColumn(name = "id_user")
    private UserModel user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPos")
    @JoinColumn(name = "id_pos")
    private PositionModel position;
}
