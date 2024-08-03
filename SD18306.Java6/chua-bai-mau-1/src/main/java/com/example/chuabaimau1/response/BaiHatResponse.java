package com.example.chuabaimau1.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaiHatResponse {
    private Integer id;
    private String tenBaiHat;
    private String tenTacGia;
    private Integer thoiLuong;
    private String ngaySanXuat;
    private Float gia;
    private String ngayRaMat;
    private String tenCaSi;
    private String queQuan;
}
