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
import xuongdesktopsu24.entity.SanPham;
import xuongdesktopsu24.utils.DbConnect;

/**
 *
 * @author syn
 */
public class HoaDonRepository {
    public ArrayList<HoaDon> getAllHoaDonChuaThanhToan() {
        String sql = "SELECT Id, SDT, TongTien FROM HoaDon WHERE TinhTrang = 0";
        
        try(Connection con = DbConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<HoaDon> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(HoaDon.builder()
                        .id(rs.getInt(1))
                        .sdt(rs.getString(2))
                        .tongTien(rs.getInt(3))
                        .build());
            }
            return list;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void addHoaDon(String sdt) {
        String sql = "INSERT INTO HoaDon (SDT, TinhTrang) VALUES (?, 0)";
        
        try(Connection con = DbConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sdt);
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
