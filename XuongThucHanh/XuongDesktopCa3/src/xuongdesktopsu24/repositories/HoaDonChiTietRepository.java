/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xuongdesktopsu24.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import xuongdesktopsu24.entity.HoaDon;
import xuongdesktopsu24.responses.HoaDonChiTietResponse;
import xuongdesktopsu24.utils.DbConnect;

/**
 *
 * @author syn
 */
public class HoaDonChiTietRepository {
    public ArrayList<HoaDonChiTietResponse> getHoaDonChiTietByIdHoaDon(int idHoaDon) {
        String sql = """
                     SELECT hdct.id, hdct.IdHoaDon, hdct.IdChiTietSP, sp.Ten, hdct.SoLuong, ctsp.GiaBan
                     FROM HoaDonChiTiet hdct
                     INNER JOIN ChiTietSP ctsp ON hdct.IdChiTietSP = ctsp.Id
                     INNER JOIN SanPham sp ON ctsp.IdDongSP = sp.Id
                     WHERE hdct.IdHoaDon = ?
                     """;
        try(Connection con = DbConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<HoaDonChiTietResponse> list = new ArrayList<>();
            ps.setInt(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(HoaDonChiTietResponse.builder()
                        .id(rs.getInt(1))
                        .idHoaDon(rs.getInt(2))
                        .idChiTietSP(rs.getInt(3))
                        .tenSanPham(rs.getString(4))
                        .soLuong(rs.getInt(5))
                        .giaBan(rs.getInt(6))
                        .build());
            }
            return list;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
