package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyCon {

    private static Connection con;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pagal", "root", "");
        } catch (ClassNotFoundException classNotFoundException) {
        } catch (SQLException sQLException) {
        }
    }

    public static Connection getConnection() throws SQLException {
        if (con==null || con.isClosed()) {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pagal", "root", "");
        }
        return con;
    }
}
