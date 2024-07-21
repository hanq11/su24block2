/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xuongnangcaosu24.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import xuongnangcaosu24.entity.HoaDon;
import xuongnangcaosu24.entity.HoaDonChiTiet;
import xuongnangcaosu24.responses.HoaDonChiTietResponse;
import xuongnangcaosu24.ulti.DbConnection;

/**
 *
 * @author syn
 */
public class HoaDonChiTietRepository {
    public ArrayList<HoaDonChiTietResponse> getAllByIdHoaDon(int idHoaDon) {
        String sql = """
                     SELECT hdct.Id, hdct.IdHoaDon, hdct.IdChiTietSP, sp.Ten, hdct.SoLuong, hdct.DonGia
                     FROM HoaDonChiTiet hdct
                     INNER JOIN ChiTietSP ctsp ON hdct.IdChiTietSP = ctsp.Id
                     INNER JOIN SanPham sp ON ctsp.IdDongSP = sp.Id
                     WHERE hdct.IdHoaDon = ?
                     """;
        try(Connection con = DbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<HoaDonChiTietResponse> danhSach = new ArrayList<>();
            ps.setInt(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                danhSach.add(
                        new HoaDonChiTietResponse(
                                rs.getInt(1),
                                rs.getInt(2),
                                rs.getInt(3),
                                rs.getString(4),
                                rs.getInt(5),
                                rs.getInt(6)
                        ));
            }
            return danhSach;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null; 
    }
}
