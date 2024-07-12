package com.fpoly.helloworldsd19201.buoi5.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GiangVien {
    private String maGiangVien;
    private String diaChi;
    private float luong;
    private LocalDate ngaySinh;
    private boolean gioiTinh;
}
