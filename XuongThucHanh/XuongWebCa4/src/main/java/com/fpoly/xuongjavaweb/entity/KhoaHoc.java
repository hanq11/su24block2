package com.fpoly.xuongjavaweb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhoaHoc {
    private Integer id;
    private Float hocPhi;
    private String ten;
    private boolean kho;
    private String boMon;
    private LocalDate ngayNhapHoc;
}
