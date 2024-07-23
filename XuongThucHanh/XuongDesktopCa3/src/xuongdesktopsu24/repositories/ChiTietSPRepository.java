/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xuongdesktopsu24.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import xuongdesktopsu24.entity.ChiTietSP;
import xuongdesktopsu24.entity.HoaDon;
import xuongdesktopsu24.entity.HoaDonChiTiet;
import xuongdesktopsu24.responses.ChiTietSPResponse;
import xuongdesktopsu24.responses.HoaDonChiTietResponse;
import xuongdesktopsu24.utils.DbConnect;

/**
 *
 * @author syn
 */
public class ChiTietSPRepository {
    public ArrayList<ChiTietSPResponse> getAllChiTietSP() {
        String sql = """
                     SELECT ctsp.id, sp.Ten, ms.Ten, ctsp.SoLuongTon, ctsp.GiaBan
                     FROM ChiTietSP ctsp
                     JOIN SanPham sp ON ctsp.IdSP = sp.Id
                     JOIN MauSac ms ON ctsp.IdMauSac = ms.Id
                     """;
        try(Connection con = DbConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<ChiTietSPResponse> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(ChiTietSPResponse.builder()
                        .id(rs.getInt(1))
                        .tenSanPham(rs.getString(2))
                        .tenMauSac(rs.getString(3))
                        .soLuongTOn(rs.getInt(4))
                        .giaBan(rs.getInt(5))
                        .build());
            }
            return list;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void updateSoLuongSP(ChiTietSP ctsp) {
        String sql = """
                     UPDATE ChiTietSP
                     SET SoLuongTon = ?
                     WHERE Id = ?
                     """;
        
        try(Connection con = DbConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ctsp.getSoLuongTon());
            ps.setInt(2, ctsp.getId());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
