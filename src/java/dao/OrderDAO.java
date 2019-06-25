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
import dto.OrderDTO;
import dto.UserDTO;

/**
 *
 * @author root
 */
public class OrderDAO {

    public static OrderDTO addOrder(OrderDTO obj) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();

        String q = "INSERT INTO restaurant_db.order (orderdate, uid, orderqty, orderamt, deliverto, addline1, addline2, city, state, postalcode, status, statusupdatedt) VALUES (now()," + obj.getUser().getUid() + "," + obj.getOrderqty() + "," + obj.getOrderamt() + ",'" + obj.getDeliverto() + "','" + obj.getAddline1() + "','" + obj.getAddline2() + "','" + obj.getCity() + "','" + obj.getState() + "','" + obj.getPostalcode() + "',0, now());";
        st.executeUpdate(q);

        ResultSet rs = st.getGeneratedKeys();
        obj.setOrderid(rs.getInt(1));

        return obj;
    }

    public static ArrayList<OrderDTO> getOrder(UserDTO user) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();

        String q = "select * from order where uid="+user.getUid()+" order by orderdate desc";
        ResultSet rs = st.executeQuery(q);

        ArrayList<OrderDTO> list = new ArrayList<>();
        
        while(rs.next()) {
            OrderDTO order = new OrderDTO(rs.getInt(1), rs.getString(2), user, rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(13), rs.getInt(12), null);
            list.add(order);
        }

        return list;
    }

}
