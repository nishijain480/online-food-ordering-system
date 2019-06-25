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
import dto.CategoryDTO;
import dto.ItemDTO;
import dto.UserDTO;

/**
 *
 * @author root
 */
public class ItemDAO {

    public static ItemDTO addItem(ItemDTO obj) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "insert into item (itemnm,catid,itemdesc,itemprice,itempic) values ('" + obj.getItemnm() + "'," + obj.getCat().getCatid() + ",'" + obj.getItemdesc() + "','" + obj.getItemprice() + "'," + obj.getItempic() + ")";
        st.executeUpdate(q,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = st.getGeneratedKeys();
        rs.next();
        obj.setItemid(rs.getInt(1));
        return obj;
    }
      public static ArrayList<ItemDTO> getAllItem() throws SQLException {
        ArrayList<ItemDTO> list = new ArrayList<>();

        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "SELECT * FROM item inner join category on item.catid = category.catid where item.status=0";
        ResultSet rs = st.executeQuery(q);

        while (rs.next()) {
            ItemDTO obj = new ItemDTO(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5), rs.getInt(6), new CategoryDTO(rs.getInt(8), rs.getString(9), null), rs.getInt(7));
            list.add(obj);
        }
        return list;
    }
     
   public static ArrayList<ItemDTO> getPopularItem() throws SQLException {
        ArrayList<ItemDTO> list = new ArrayList<>();

        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "select  item.*, category.*, count(*) as tot_order from item,category, orderdetail where item.catid = category.catid  and item.itemid=orderdetail.itemid group by itemid order by tot_order desc limit 3";
        ResultSet rs = st.executeQuery(q);

        while (rs.next()) {
            ItemDTO obj = new ItemDTO(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(7), rs.getInt(5), new CategoryDTO(rs.getInt(3), rs.getString(9), null), rs.getInt(6));
            list.add(obj);
        }
        return list;
    }   
    


    public static ArrayList<ItemDTO> getItemByCategory(CategoryDTO cat) throws SQLException {
        ArrayList<ItemDTO> list = new ArrayList<>();

        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "SELECT * FROM item inner join category on item.catid = category.catid where item.status=0 and category.catid=" + cat.getCatid();
        ResultSet rs = st.executeQuery(q);

        while (rs.next()) {
            ItemDTO obj = new ItemDTO(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(7), rs.getInt(5), new CategoryDTO(rs.getInt(8), rs.getString(9), null), rs.getInt(6));
            list.add(obj);
        }
        return list;
    }

    public static ItemDTO getItemById(int itemid) throws SQLException {
        ItemDTO obj;
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "SELECT * FROM item inner join category on item.catid = category.catid where item.status=0 and item.itemid=" + itemid;
        ResultSet rs = st.executeQuery(q);

        if (!rs.next()) {
            return null;
        }
        obj = new ItemDTO(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(7), rs.getInt(5), new CategoryDTO(rs.getInt(3), rs.getString(9), null), rs.getInt(6));

        return obj;
    }

    public static ItemDTO getItemByName(String itemnm) throws SQLException {
        ItemDTO obj;
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "SELECT * FROM item inner join category on item.catid = category.catid where item.status=0 and item.itemnm like '%" + itemnm+"%'";
        ResultSet rs = st.executeQuery(q);

        if (!rs.next()) {
            return null;
        }
        obj = new ItemDTO(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5), rs.getInt(6), new CategoryDTO(rs.getInt(8), rs.getString(9), null), rs.getInt(7));

       
        return obj;
    }

    public static void updateItem(ItemDTO obj) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "update item set itemnm='"+obj.getItemnm()+"',catid="+obj.getCat().getCatid()+",itemdesc='"+obj.getItemdesc()+"',itempic='"+obj.getItempic()+"',itemprice="+obj.getItemprice()+"  where itemid="+obj.getItemid();
        st.executeUpdate(q);
    }
    
    // Status 0=Avaiable, 1=Unavailable, 2=Deleted
    public static void changeStatus(ItemDTO obj,int status) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "update item set status="+status+" where itemid="+obj.getItemid();
        st.executeUpdate(q);
    }
     public static void blockItem(ItemDTO obj) throws SQLException {
       
         Connection con = MyCon.getConnection();
        Statement st = con.createStatement();  
       // String q="delete from user where mobileno='"+obj.getMobileno()+"'";
         String q = "update item set status="+ 1 +" where itemnm='"+ obj.getItemnm() +"'" ;
      
        st.executeUpdate(q);
        
     }
}
