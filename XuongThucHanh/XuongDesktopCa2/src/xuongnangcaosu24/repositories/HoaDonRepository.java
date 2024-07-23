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
import xuongnangcaosu24.entity.MauSac;
import xuongnangcaosu24.ulti.DbConnection;

/**
 *
 * @author syn
 */
public class HoaDonRepository {
    public ArrayList<HoaDon> getAllHDChuaThanhToan() {
        String sql = "SELECT Id, Sdt, TongTien FROM HoaDon WHERE TinhTrang = 0";
        try(Connection con = DbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<HoaDon> danhSach = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                danhSach.add(
                        new HoaDon(
                                rs.getInt(1), 
                                rs.getString(2), 
                                rs.getInt(3),
                                null
                        ));
            }
            return danhSach;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null; 
    }
    
    public void taoHoaDon(String Sdt) {
        String sql = "INSERT INTO HoaDon (Sdt, TongTien, TinhTrang) VALUES (?, ?, ?)";
        try(Connection con = DbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, Sdt);
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void thanhToan(HoaDon hd) {
        String sql = """
                     UPDATE HoaDon
                     SET TinhTrang = 1, 
                     TongTien = ?
                     WHERE Id = ?
                     """;
        try(Connection con = DbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, hd.getTongTien());
            ps.setInt(2, hd.getId());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
