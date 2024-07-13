/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xuongnangcaosu24.repositories;
import java.sql.*;
import xuongnangcaosu24.ulti.DbConnection;
        
/**
 *
 * @author syn
 */
public class NhanVienRepository {
    public boolean checkCredential(String username, String password) {
        String sql = "SELECT Ma, MatKhau FROM NhanVien WHERE Ma = ? AND MatKhau = ?";
        try(Connection con = DbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
}
