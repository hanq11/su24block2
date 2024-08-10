package com.example.chuademau2.request;

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
public class NhanVienRequest {
    private Integer id;

    private String ma;

    private String ho;

    private String tenDem;

    private String ten;

    private String gioiTinh;

    private String diaChi;

    private ChucVu chucVu;
}
