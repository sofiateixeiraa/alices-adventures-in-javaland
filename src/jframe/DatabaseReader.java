package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class DatabaseReader {
	
	 private Connection connection;

	    public DatabaseReader() {
	        this.connection = DBConnection.getConnection();
	    }
	    // Return a single reader specified by ID
	    public User selectAReader(int readerID) {
	    	User reader = null;
	    	
	    	try {
	    	Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from  readers where idreader = '"+readerID+"'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
            	reader = new User();
            	reader.setId(rs.getInt("idreader"));
            	reader.setName(rs.getString("name"));
            	reader.setNoBorrowedBooks(rs.getInt("noBorrowings"));
            	reader.setEmail(rs.getString("email"));
            	reader.setPhoneNumber(rs.getInt("phoneNumber"));

            }
            
         
	    	}catch (Exception e) {
	            e.printStackTrace();
	        }
	    	return reader;
	    }
	    
	    // select all readers in the dtabase and return a list
	    public ArrayList<User> selectAllReaders() {
	    	ArrayList<User> userList = new ArrayList<>();
	    	try {
	            Statement st = getConnection().createStatement();
	            ResultSet rs = st.executeQuery("select * from readers");
	            
	            while(rs.next()){
	            	User user = new User();
	            	user.setEmail(rs.getString("email"));
	            	user.setName(rs.getString("name"));
	            	user.setNoBorrowedBooks(rs.getInt("noBorrowings"));
	            	user.setId(rs.getInt("idreader"));
	            	user.setPhoneNumber(rs.getInt("phoneNumber"));
	            	user.setPassword(rs.getString("password"));
	            	userList.add(user);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    	
	    	return userList;
	        
	    }

	  //to update reader details
	    
	    public boolean updateReader(String readerName , String email, int readerPhoneNumber, int readerId){
	    	boolean isUpdated = false;
	          
	          try {
	        	  String sql = "Update readers set name = '"+readerName+"', email = '"+email+"',"
	        	  		+ " phoneNumber = '"+readerPhoneNumber+"' where idreader = '"+readerId+"'";
	              PreparedStatement pst = getConnection().prepareStatement(sql);
	              int rowCount = pst.executeUpdate();
	              if (rowCount > 0) {
	                  isUpdated = true;
	              }else{
	                  isUpdated = false;
	              }
	          } catch (Exception e) {
	              e.printStackTrace();
	          }
	          
	          return isUpdated;
	      }
	    
	    //method to delete reader detail
	    public boolean deleteReader(int readerId){
	        boolean isDeleted = false;
	        
	        try {
	            String sql = "delete from readers where idreader = '"+readerId+"' ";
	            PreparedStatement pst = getConnection().prepareStatement(sql);
	            
	            int rowCount = pst.executeUpdate();
	            if (rowCount > 0) {
	                isDeleted = true;
	            }else{
	                isDeleted = false;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return isDeleted;
	    }

	    private Connection getConnection() {
	        return connection;
	    }

	    public void setConnection(Connection connection) {
	        this.connection = connection;
	    }

}
