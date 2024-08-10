package com.example.chuademau2.response;

import com.example.chuademau2.entity.ChucVu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienResponse {
    private Integer id;

    private String ma;

    private String hoVaTen;

    private String gioiTinh;

    private String diaChi;

    private String tenChucVu;
}
