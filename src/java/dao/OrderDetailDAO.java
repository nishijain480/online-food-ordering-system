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
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;

/**
 *
 * @author root
 */
public class OrderDetailDAO {

    public static OrderDetailDTO addOrderDetail(OrderDetailDTO obj) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();

        String q = "INSERT INTO restaurant_db.orderdetail (orderid, uid, itemid, qty, price, amount) VALUES ("+obj.getOrder().getOrderid()+","+obj.getUser().getUid()+","+obj.getItem().getItemid()+","+obj.getQty()+","+obj.getPrice()+","+obj.getAmount()+")";
        st.executeUpdate(q);

        ResultSet rs = st.getGeneratedKeys();
        obj.setOrderdetailid(rs.getInt(1));

        return obj;
    }

    public static ArrayList<OrderDetailDTO> getOrderDetail(OrderDTO order) throws SQLException {
        ArrayList<OrderDetailDTO> list = new ArrayList<>();

        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();

        String q = "select * from orderdetail inner join item on orderdetail.itemid = item.itemid  where orderid="+order.getOrderid();
        
        ResultSet rs = st.executeQuery(q);
        
        while(rs.next()) {
            ItemDTO item = new ItemDTO();
            item.setItemid(rs.getInt(8));
            item.setItemnm(rs.getString(9));
            
            OrderDetailDTO od = new OrderDetailDTO(rs.getInt(1), order, order.getUser(), item, rs.getInt(5), rs.getInt(6), rs.getInt(7));
            list.add(od);
        }
        
        return list;
    }
}
