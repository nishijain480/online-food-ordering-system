/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CategoryDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import dto.ItemDTO;
import dto.UserDTO;
import java.util.ArrayList;


//user status :0 means singnedup but not verified
//user status :1 means signed up and verified
public class UserDAO {

    public static UserDTO addUser(UserDTO obj) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();

        String otp = genOTP();
        String q = "insert into user (mobileno,email,upass,otp,fullname,regdate) value ('" + obj.getMobileno() + "','" + obj.getEmail() + "','" + obj.getUpass() + "','" + otp + "','" + obj.getFullname() + "',now())";
        st.executeUpdate(q,Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = st.getGeneratedKeys();
        rs.next();
        obj.setUid(rs.getInt(1));
        obj.setOtp(otp);

        return obj;
    }

   public static UserDTO chkLogin(String mobileno, String upass) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();

        String q = "select * from user where mobileno='" + mobileno + "' and upass='" + upass + "'";
        ResultSet rs = st.executeQuery(q);

        if (!rs.next()) {
            return null;
        }

        UserDTO obj = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), "", "", rs.getString(6), rs.getString(7), rs.getInt(8), null);
        obj.setAddlist(DeliveryAdressDAO.getDeliveryAddressList(obj));
        
        return obj;
    }

/*    public static UserDTO verifyOTP(String mobileno, String otp) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();

        String q = "select * from user where mobileno='" + mobileno + "' and otp='" + otp + "'";
        ResultSet rs = st.executeQuery(q);

        if (!rs.next()) {
            return null;
        }

        UserDTO obj = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), "", "", rs.getString(6), rs.getString(7), rs.getInt(8), null);
        return obj;
    }

    public static String getOTP(String mobileno) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();

        String q = "select otp from user where mobileno='" + mobileno + "'";
        ResultSet rs = st.executeQuery(q);

        if (!rs.next()) {
            return null;
        }

        return rs.getString(1);
    }
*/
    private static String genOTP() {
        String numbers = "0123456789";

        Random rndm_method = new Random();

        char[] password = new char[4];

        for (int i = 0; i < password.length; i++) {
            password[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
        }

        return new String(password);
    }

    public static void updateUser(UserDTO obj) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();

        String q = "update user set email='" + obj.getEmail() + "',fullname='" + obj.getFullname() + "' where uid=" + obj.getUid();
        st.executeUpdate(q);
    }

    public static boolean changePassword(String mobileno, String oldpass, String newpass) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();

        String q = "update user set upass='" + newpass + "' where mobileno='" + mobileno + "' and upass='" + oldpass + "'";
        int count = st.executeUpdate(q);
        if (count > 0) {
            return true;
        }
        return false;
    }
       public static ArrayList<UserDTO> getUserList() throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "select * from user where status=0";
        ResultSet rs = st.executeQuery(q);
        ArrayList<UserDTO> list = new ArrayList<UserDTO>();
        while (rs.next()) {
            UserDTO user = new UserDTO(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),null);
            list.add(user);
        }
        return list;
    }
 public static void blockUser(UserDTO obj) throws SQLException {
       
         Connection con = MyCon.getConnection();
        Statement st = con.createStatement();  
       // String q="delete from user where mobileno='"+obj.getMobileno()+"'";
         String q = "update user set status="+ 1 +" where mobileno='"+ obj.getMobileno() +"'" ;
      
        st.executeUpdate(q);
        
     }
 public static void unBlockUser(UserDTO obj) throws SQLException {
       
         Connection con = MyCon.getConnection();
        Statement st = con.createStatement();  
       // String q="delete from user where mobileno='"+obj.getMobileno()+"'";
         String q = "update user set status="+ 0 +" where mobileno='"+ obj.getMobileno() +"'" ;
      
        st.executeUpdate(q);
        
     }
        public static ArrayList<UserDTO> getBlockedUserList() throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "select * from user where status=1";
        ResultSet rs = st.executeQuery(q);
        ArrayList<UserDTO> list = new ArrayList<UserDTO>();
        while (rs.next()) {
            UserDTO user = new UserDTO(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(2),rs.getInt(7),null);
            list.add(user);
        }
        return list;
    }
    }

