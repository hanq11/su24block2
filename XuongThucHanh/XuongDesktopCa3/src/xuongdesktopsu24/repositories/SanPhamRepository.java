/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xuongdesktopsu24.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import xuongdesktopsu24.entity.SanPham;
import xuongdesktopsu24.utils.DbConnect;

/**
 *
 * @author syn
 */
public class SanPhamRepository {
    public ArrayList<SanPham> getAll() {
        String sql = "SELECT Id, Ma, Ten FROM SanPham";
        
        try(Connection con = DbConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<SanPham> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(SanPham.builder()
                        .Id(rs.getInt(1))
                        .Ma(rs.getString(2))
                        .Ten(rs.getString(3))
                        .build());
            }
            return list;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void add(SanPham sp) {
        String sql = "INSERT INTO SanPham VALUES (?, ?)";
        
        try(Connection con = DbConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(SanPham sp) {
        String sql = "UPDATE SanPham SET Ma = ?, Ten = ? WHERE Id = ?";
        
        try(Connection con = DbConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());
            ps.setInt(3, sp.getId());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void remove(int index) {
        String sql = "DELETE FROM SanPham WHERE Id = ?";
        
        try(Connection con = DbConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, index);
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
