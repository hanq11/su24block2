package com.fpoly.helloworldsd19201.buoi8.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.UtilityClass;

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

    @Column(name = "tenBacSi")
    private String ten;

    @Column(name = "tuoi")
    private Integer tuoi;

    @ManyToOne
    @JoinColumn(name = "idPhongKham", referencedColumnName = "id")
    private PhongKham phongKham;
}
