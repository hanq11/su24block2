/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xuongdesktopsu24.repositories;
import java.sql.*;
import xuongdesktopsu24.utils.DbConnect;
/**
 *
 * @author syn
 */
public class NhanVienRepository {
    public boolean checkCredential(String ma, String matKhau) {
        String sql = "SELECT Ma, MatKhau FROM NhanVien WHERE Ma = ? AND MatKhau = ?";
        
        try(Connection con = DbConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ma);
            ps.setString(2, matKhau);
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
