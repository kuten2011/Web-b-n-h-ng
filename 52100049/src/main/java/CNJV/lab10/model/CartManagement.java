package CNJV.lab10.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tb_gioHang")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CartManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long sanPhamId;
    private int soLuong;
    private Double tongTien;
    @ManyToOne
    @JoinColumn(name="fk_username")
    private Account userAccount;

    public CartManagement(Long sanPhamId, int soLuong, Double tongTien, Account userAccount){
        this.sanPhamId = sanPhamId;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.userAccount = userAccount;
    }
}
