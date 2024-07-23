/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xuongnangcaosu24.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import xuongnangcaosu24.entity.ChiTietSP;
import xuongnangcaosu24.entity.HoaDonChiTiet;
import xuongnangcaosu24.responses.ChiTietSPResponse;
import xuongnangcaosu24.responses.HoaDonChiTietResponse;
import xuongnangcaosu24.ulti.DbConnection;

/**
 *
 * @author syn
 */
public class ChiTietSPRepository {
    public ArrayList<ChiTietSPResponse> getAllSPCT() {
        String sql = """
                     SELECT ctsp.Id, sp.Ten, nsx.Ten, ms.Ten, dsp.Ten
                     , ctsp.NamBH, ctsp.MoTa, ctsp.SoLuongTon, ctsp.GiaNhap, ctsp.GiaBan
                     FROM ChiTietSP ctsp
                     JOIN SanPham sp ON ctsp.IdSP = sp.Id
                     JOIN NSX nsx ON ctsp.IdNsx = nsx.Id
                     JOIN MauSac ms ON ctsp.IdMauSac = ms.Id
                     JOIN DongSP dsp ON ctsp.IdDongSP = dsp.Id
                     """;
        try(Connection con = DbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<ChiTietSPResponse> danhSach = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                danhSach.add(
                        new ChiTietSPResponse(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getInt(6),
                                rs.getString(7),
                                rs.getInt(8),
                                rs.getInt(9),
                                rs.getInt(10)
                        ));
            }
            return danhSach;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null; 
    }
    
    public void updateSoLuongByIDCTSP(ChiTietSP ctsp) {
        String sql = """
                        UPDATE ChiTietSP
                        SET SoLuongTon = ?
                        WHERE ID = ?
                     """;
        try(Connection con = DbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ctsp.getSoLuongTon());
            ps.setInt(2, ctsp.getId());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
