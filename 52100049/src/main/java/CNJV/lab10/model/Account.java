package CNJV.lab10.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_taiKhoan")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Account {
    @Id
    private String username;
    private String password;
}