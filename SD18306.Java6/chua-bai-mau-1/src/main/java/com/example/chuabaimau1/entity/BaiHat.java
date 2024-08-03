package com.example.chuabaimau1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BaiHat")
public class BaiHat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TenBaiHat")
    private String tenBaiHat;

    @Column(name = "TenTacGia")
    private String tenTacGia;

    @Column(name = "ThoiLuong")
    private Integer thoiLuong;

    @Column(name = "NgaySanXuat")
    private String ngaySanXuat;

    @Column(name = "Gia")
    private Float gia;

    @Column(name = "NgayRaMat")
    private String ngayRaMat;

    @ManyToOne
    @JoinColumn(name = "CaSiId", referencedColumnName = "ID")
    private CaSi caSi;
}
