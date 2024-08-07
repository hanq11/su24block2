package com.fpoly.xuongjavaweb.buoi4.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BacSi")
public class BacSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "tuoi")
    private int tuoi;

    @ManyToOne
    @JoinColumn(name = "idPhongKham", referencedColumnName = "id")
    private PhongKham phongKham;
}
