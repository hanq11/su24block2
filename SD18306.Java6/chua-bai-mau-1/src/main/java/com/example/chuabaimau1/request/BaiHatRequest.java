package com.example.chuabaimau1.request;

import com.example.chuabaimau1.entity.CaSi;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaiHatRequest {
    private Integer id;
    @NotBlank
    private String tenBaiHat;
    @NotBlank
    private String tenTacGia;
    @NotNull
    private Integer thoiLuong;
    @NotBlank
    private String ngaySanXuat;
    @NotNull
    private Float gia;
    @NotBlank
    private String ngayRaMat;
    @NotNull
    private CaSi caSi;
}
