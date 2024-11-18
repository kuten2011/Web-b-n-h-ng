package CNJV.lab10.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_chitietHoaDon")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double giaBan;
    private int soLuong;
    private double tongTien;
    @ManyToOne
    @JoinColumn(name = "fk_hoaDon")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name="fk_sanPham")
    private Product product;

    public BillDetail(double giaBan, int soLuong, double tongTien, Product product, Bill bill){
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.product = product;
        this.bill = bill;
    }
}
