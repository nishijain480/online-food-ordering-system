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

/**
 *
 * @author root
 */
public class CategoryDAO {

    public static ArrayList<CategoryDTO> getCategoryList() throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "select * from category where deleted=0";
        ResultSet rs = st.executeQuery(q);
        ArrayList<CategoryDTO> list = new ArrayList<>();
        while (rs.next()) {
            CategoryDTO category = new CategoryDTO(rs.getInt(1), rs.getString(2), null);
            list.add(category);
        }
        return list;
    }

    public static CategoryDTO getCategory(int catid) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "select * from category where catid=" + catid;
        ResultSet rs = st.executeQuery(q);
        if (!rs.next()) {
            return null;
        }
        CategoryDTO category = new CategoryDTO(rs.getInt(1), rs.getString(2), null);
        return category;
    }

    public static CategoryDTO addCategory(CategoryDTO obj) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "insert into category (catnm) values ('" + obj.getCatnm() + "')";
        st.executeUpdate(q,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = st.getGeneratedKeys();
        rs.next();
        obj.setCatid(rs.getInt(1));
        return obj;
    }

    public static CategoryDTO updateCategory(CategoryDTO obj) throws SQLException {
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();
        String q = "update category set catnm='" + obj.getCatnm() + "' where catid='" + obj.getCatid() + "'";
        st.executeUpdate(q);
        return obj;
    }

    
   
     public static CategoryDTO deleteCategoryByName(CategoryDTO obj) throws SQLException {
         
        Connection con = MyCon.getConnection();
        Statement st = con.createStatement();    
        String q = "delete from category where catnm='"+obj.getCatnm()+"'";     
        st.executeUpdate(q);
        return obj;
     }
     
     
     }
