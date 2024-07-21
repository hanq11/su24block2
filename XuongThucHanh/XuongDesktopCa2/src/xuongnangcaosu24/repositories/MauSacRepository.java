/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xuongnangcaosu24.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import xuongnangcaosu24.entity.MauSac;
import xuongnangcaosu24.ulti.DbConnection;

/**
 *
 * @author syn
 */
public class MauSacRepository {
    public ArrayList<MauSac> getAll() {
        String sql = "SELECT Id, Ma, Ten FROM MauSac";
        try(Connection con = DbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<MauSac> danhSach = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                danhSach.add(
                        new MauSac(
                                rs.getInt(1), 
                                rs.getString(2), 
                                rs.getString(3)
                        ));
            }
            return danhSach;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null; 
    }
}
