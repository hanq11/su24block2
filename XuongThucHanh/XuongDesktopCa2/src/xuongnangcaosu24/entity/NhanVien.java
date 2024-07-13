/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xuongnangcaosu24.entity;

import java.util.Date;
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
public class NhanVien {
    private Integer Id;
    private String Ma;
    private String Ten;
    private String TenDem;
    private String Ho;
    private String GioiTinh;
    private Date NgaySinh;
    private String DiaChi;
    private String Sdt;
    private String MatKhau;
    private Integer IdCV;
    private Integer TrangThai;
}
