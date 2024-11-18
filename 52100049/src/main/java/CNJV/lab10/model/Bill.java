package CNJV.lab10.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_hoaDon")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate ngayLap;

    private double tongCong;

    @ManyToOne
    @JoinColumn(name="fk_username")
    private Account userAccount;

    public Bill(LocalDate ngayLap, double tongCong, Account userAccount){
        this.ngayLap = ngayLap;
        this.tongCong = tongCong;
        this.userAccount = userAccount;
    }
}
