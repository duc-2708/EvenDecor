package com.example.EvenDecor.model;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPositionId implements Serializable {
//java ko cho phép có 2 @id
//class này gom 2 cái này lại và đưa sang UserPosition làm khóa chính
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_pos")
    private Integer idPos;
}
