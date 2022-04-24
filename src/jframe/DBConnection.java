

package jframe;

import java.sql.*;

//Connection to Database
public class DBConnection {
	
    static Connection con = null;
    private static String jdbcURL = "jdbc:mysql://db.fe.up.pt:3306/up201806675";
    private static String username="up201806675";
    private static String password="V33s1DaKm";
    
    
    public static Connection getConnection() {
    	
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(jdbcURL,username,password);
            con.setSchema("up201806675");
        }
        catch(Exception e)
        {
            System.out.println("ERROR");
            e.printStackTrace();
        }
        return con;
    }
    

    public static  boolean disconnect() {
        try {
            con.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static Connection getC() {
        return con;
    }
    
    public static boolean executeQuery(String sql) {

    	getConnection();
        try {
            Statement stmt = getC().createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            disconnect();
            return false;
        }

        disconnect();
        return true;
    }
}