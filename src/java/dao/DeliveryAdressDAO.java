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
import java.util.ArrayList;
import dto.DeliveryAddressDTO;
import dto.UserDTO;

/**
 *
 * @author root
 */
public class DeliveryAdressDAO {

    public static DeliveryAddressDTO addDeliveryAdd(DeliveryAddressDTO obj) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();

        String q = "insert into deliveryadd (uid,deliverto,addline1,addline2,city,state,postalcode) values (" + obj.getUser().getUid() + ",'" + obj.getDeliverto() + "','" + obj.getAddline1() + "','" + obj.getAddline2() + "','" + obj.getCity() + "','" + obj.getState() + "','" + obj.getPostalcode() + "')";
        st.executeUpdate(q);

        ResultSet rs = st.getGeneratedKeys();
        obj.setDid(rs.getInt(1));

        return obj;
    }

    public static void removeDeliveryAdd(DeliveryAddressDTO obj) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();

        String q = "delete from deliveryadd where did=" + obj.getDid();
        st.executeUpdate(q);
    }

    public static ArrayList<DeliveryAddressDTO> getDeliveryAddressList(UserDTO obj) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();

        String q = "select * from deliveryadd where uid=" + obj.getUid();
        ResultSet rs = st.executeQuery(q);

        ArrayList<DeliveryAddressDTO> list = new ArrayList<>();

        while(rs.next()) {
            DeliveryAddressDTO address = new DeliveryAddressDTO(rs.getInt(1), obj, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            list.add(address);
        }
        return list;
    }

}
