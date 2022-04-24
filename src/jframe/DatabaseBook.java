package jframe;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class DatabaseBook {

    private Connection connection;

    public DatabaseBook() {
        this.connection = DBConnection.getConnection();
    }
    // Return a single book specified by reference
	public Book selectABook(int bookReference){
		Book book = null;
		
		try {
            PreparedStatement pst = getConnection().prepareStatement("select * from  book where reference = '"+bookReference+"'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
            	book = new Book();
            	book.setName(rs.getString("name"));
            	book.setReference(rs.getInt("reference"));
            	book.setAuthor(rs.getString("author"));
            	book.setQuantity(rs.getInt("quantity"));
            	book.setTag(rs.getString("tag"));
            	book.setType(rs.getInt("type"));
            	book.setPublication(rs.getInt("publication"));
            	book.setUrl(rs.getString("url"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return book;
	}


    //Return a List of all Books
    public List<Book> selectAllBook() {
    	List<Book> listB = new ArrayList<>();
		try {
			Statement stmt = getConnection().createStatement();
		    ResultSet rs = null;
	        rs = stmt.executeQuery("SELECT * FROM book");
	      
	        while (rs.next()) {
	        	Book book = new Book();
	            book.setReference(rs.getInt("reference"));
	            book.setName(rs.getString("name"));
	            book.setAdded(rs.getTimestamp("date"));
	            book.setAuthor(rs.getString("author"));
	            book.setQuantity(rs.getInt("quantity"));
	            book.setTag(rs.getString("tag"));
	            book.setType(rs.getInt("type"));
	            book.setPublication(rs.getInt("publication"));

	            listB.add(book);

	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       

        return listB;

    }
    
    //Button Add book details table
    public boolean addBook(int book_reference, String book_name, String author, int quantity, String tag, int pub , String url, String type ) {
    	boolean isAdded = false;
    	Book book = new Book();
    	try {
            String sql = "insert into book(reference, name, author, quantity, tag, publication, type, url, date) "
            		+ "values('"+book_reference+"', '"+book_name+"', '"+author+"', '"+quantity+"', '"+tag+"', '"+pub+"',"
            				+ " '"+book.stringToType(type)+"','"+url+"', '"+dateFormat()+"' )";
            PreparedStatement pst = getConnection().prepareStatement(sql);
            int rowCount=pst.executeUpdate();
 
            if(rowCount > 0) {
            	isAdded = true;
            }
            else {
            	isAdded = false;
            }
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	return isAdded;
    }
    
  //Update book details
    public boolean updateBook(int book_reference, String book_name, String author, int quantity, String tag, int pub , String url, String type ){
      boolean isUpdated = false;
      Book book = new Book();
        
        try {
            String sql = "update book set name = '"+book_name+"',author = '"+author+"',quantity = '"+quantity+"', tag = '"+tag+"', "
            		+ " type='"+book.stringToType(type)+"', url = '"+url+"', publication = '"+pub+"' where reference='"+book_reference+"'";
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
    //Delete One Book
    public boolean deleteBook(int book_reference){
        boolean isDeleted = false;
        
        try {
            String sql = "delete from book where reference = '"+book_reference+"' ";
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
    
  //updating book count
    public boolean updateBookCount(int bookId) {
    	boolean result = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book set quantity = quantity - 1 where reference = '"+bookId+"'";
            PreparedStatement pst = con.prepareStatement(sql);
            int rowCount = pst.executeUpdate();

            if (rowCount > 0) {
                result = true;
            }else {
            	result = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    //updating book count in return book page
    public boolean updateBookCountReturn(int bookId) {
    	boolean result = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book set quantity = quantity + 1 where reference = '"+bookId+"'";
            PreparedStatement pst = con.prepareStatement(sql);
            int rowCount = pst.executeUpdate();

            if (rowCount > 0) {
                result = true;
            }else {
            	result = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    //Check if the input was int or not
    boolean numberOrNot(String input)
    {
        try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
    }
    
    public static Timestamp dateFormat() {
		
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String timeS = sdf.format(cal.getTime());
        Timestamp finalDate = Timestamp.valueOf(timeS);
        
		return finalDate;
	}

    private Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
