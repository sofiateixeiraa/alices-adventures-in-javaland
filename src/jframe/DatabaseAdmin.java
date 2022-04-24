package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAdmin {

    private Connection connection;

    public DatabaseAdmin() {
        this.connection = DBConnection.getConnection();
    }

    //checks if the admin exists
    public boolean registedAdmin(String email) {
    	
    	try {
	    	String sql = "SELECT email FROM admin WHERE email = '" + email + "'";
	    	PreparedStatement pst = getConnection().prepareStatement(sql);
	        ResultSet rs =pst.executeQuery(sql);
	        return (rs.next() && rs.getString(1).length() > 0);
	        
	    }catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return false;
    }

    //register a new admin
    public boolean newAdmin(Admin admin){
    	boolean result = false;
    	try {
    		String sql ="INSERT INTO admin VALUES ('" + admin.getEmail() + "', '" + admin.getName() + "', "
    				+ "'" + admin.getPhoneNumber() + "', '" + admin.getPassword() + "')";
    		PreparedStatement pst = getConnection().prepareStatement(sql);
    		int rowCount=pst.executeUpdate();
	        
	        if(rowCount > 0) {
	        	result  = true;
	        }
	        else {
	        	 result = false;
	        }
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}
 
        return result;

    }

    // check login
    public boolean checkLogin(String email, String password) throws SQLException {
    	boolean result = false;
    	try {
    		String sql = "SELECT email FROM admin WHERE email = '" + email + "' AND password = '" + password +"'";
    		PreparedStatement pst = getConnection().prepareStatement(sql);
    		ResultSet rs =pst.executeQuery(sql);
	        return (rs.next() && rs.getString(1).length() > 0);
    		
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}
 
        return result;

    }

    private Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
	
	


