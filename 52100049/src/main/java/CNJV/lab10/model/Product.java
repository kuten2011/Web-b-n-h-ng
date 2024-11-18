package CNJV.lab10.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_sanPham")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    private String brand;
    private String detail;
    private String image;
}
