/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xuongdesktopsu24.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author syn
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietSP {
    private Integer Id;
    private Integer IdSP;
    private Integer IdNsx;
    private Integer IdMauSac;
    private Integer IdDongSP;
    private Integer NamBH;
    private String MoTa;
    private Integer SoLuongTon;
    private Integer GiaNhap;
    private Integer GiaBan;
}

