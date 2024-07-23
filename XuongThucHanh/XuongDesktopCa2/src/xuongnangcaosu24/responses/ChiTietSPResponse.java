/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xuongnangcaosu24.responses;

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
public class ChiTietSPResponse {
    private Integer Id;
    private String tenSanPham;
    private String nhaSanXuat;
    private String mauSac;
    private String dongSP;
    private Integer NamBH;
    private String MoTa;
    private Integer SoLuongTon;
    private Integer GiaNhap;
    private Integer GiaBan;
}
