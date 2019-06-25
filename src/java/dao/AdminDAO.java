/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dto.AdminDTO;
import dto.UserDTO;
import java.util.Random;


public class AdminDAO {
    public static AdminDTO chkLogin(AdminDTO obj) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        
        String q = "select * from admin where unm='"+obj.getUnm()+"' and upass='"+obj.getUpass()+"'";
        ResultSet rs = st.executeQuery(q);
        if(!rs.next()) 
            return null;
        obj.setUmob(rs.getString("umob"));
        return obj;
    }
      private static String genOTP() {
        String numbers = "0123456789";

        Random rndm_method = new Random();

        char[] password = new char[4];

        for (int i = 0; i < password.length; i++) {
            password[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
        }

        return new String(password);
    }
    
    public static AdminDTO chkMobile(String umob) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "select * from admin where umob='"+umob+"'";
        ResultSet rs = st.executeQuery(q);
        if(!rs.next()) 
            return null;
        AdminDTO obj = new AdminDTO(rs.getString(1), rs.getString(2), umob , rs.getString(4));
        return obj;
    }
    
    public static void updateAdmin(AdminDTO obj) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "update admin set upass='"+obj.getUpass()+"', umob='"+obj.getUmob()+"' where unm="+obj.getUnm();
        st.executeUpdate(q);
    }
    public static AdminDTO addAdmin(AdminDTO obj) throws SQLException {
       Connection con=MyCon.getConnection();
       Statement st=con.createStatement();
       
       
         String otp = genOTP();
       String q="insert into admin (unm , umob , upass ,uotp) value ('"+ obj.getUnm() +"','"+ obj.getUmob() +"','"+ obj.getUpass() +"','"+ otp +"')";
       st.executeUpdate(q,Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = st.getGeneratedKeys();
        rs.next();
       
        obj.setUotp(otp);
    
    return obj;
    }
  public static AdminDTO chkLogin(String mobileno, String upass) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();

        String q = "select * from admin where umob='" + mobileno + "' and upass='" + upass + "'";
        ResultSet rs = st.executeQuery(q);

        if (!rs.next()) {
            return null;
        }

        AdminDTO obj = new AdminDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
     
        
        return obj;
    }

}
