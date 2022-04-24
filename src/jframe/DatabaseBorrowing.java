package jframe;

import java.sql.Connection;
import com.toedter.calendar.JDateChooser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;


public class DatabaseBorrowing {
	
	private Connection connection;

    public DatabaseBorrowing() {
        this.connection = DBConnection.getConnection();
    }
    
    private Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    //Insert a Borrowed book in the Borrowing Table in the DB
    public boolean insertBorrowing(int reference, String bookName, int idReader, String readerName, String date, String date1 ) {
        boolean isIssued = false;
        try {
            String sql = "insert into borrowing (book_reference,book_name,reader_id,reader_name,issue_date,due_date,status) "
            		+ "values('"+reference+"','"+bookName+"','"+idReader+"','"+readerName+"','"+date+"','"+date1+"','Borrowed')";
            PreparedStatement pst = getConnection().prepareStatement(sql);
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isIssued = true;
            } else {
                isIssued = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isIssued;

    }
  //Return a List of all Borrowings
    public List<Borrowing> selectAllBorrowing() {

    	List<Borrowing> listBor = new ArrayList<>();
    	try {
	        Statement stmt = getConnection().createStatement();
	        ResultSet rs = null;
	        rs = stmt.executeQuery("SELECT * FROM borrowing");
	     
	        while (rs.next()) {
	            Borrowing borrowing = new Borrowing();
	            Book book = new Book();
	            User user = new User();
	
	            book.setReference(rs.getInt("book_reference"));
	            book.setName(rs.getString("book_name"));
	            user.setName(rs.getString("reader_name"));
	            user.setId(rs.getInt("reader_id"));
	            borrowing.setId(rs.getInt("id"));
	            borrowing.setStatus(rs.getString("status"));
	            borrowing.setStartPeriod(rs.getString("issue_date"));
	            borrowing.setEndPeriod(rs.getString("due_date"));
	            borrowing.setStatus(rs.getString("status"));
	            borrowing.setDeliveryDate(rs.getString("delivery_date"));
	            borrowing.setBook(book);
	            borrowing.setUser(user);
	
	            listBor.add(borrowing);
	
	        }
    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return listBor;

    }
  //Return a List of all Borrowings that weren't returned yet
    public List<Borrowing> selectAllBorrowingActive() {

    	List<Borrowing> listBor = new ArrayList<>();
    	try {
	        Statement stmt = getConnection().createStatement();
	        ResultSet rs = null;
	        rs = stmt.executeQuery("SELECT * FROM borrowing WHERE status = 'Borrowed'");
	     
	        while (rs.next()) {
	            Borrowing borrowing = new Borrowing();
	            Book book = new Book();
	            User user = new User();
	            
	            book.setReference(rs.getInt("book_reference"));
	            book.setName(rs.getString("book_name"));
	            user.setName(rs.getString("reader_name"));
	            user.setId(rs.getInt("reader_id"));
	            borrowing.setId(rs.getInt("id"));
	            borrowing.setStatus(rs.getString("status"));
	            borrowing.setStartPeriod(rs.getString("issue_date"));
	            borrowing.setEndPeriod(rs.getString("due_date"));
	            borrowing.setStatus(rs.getString("status"));
	            borrowing.setDeliveryDate(rs.getString("delivery_date"));
	            borrowing.setBook(book);
	            borrowing.setUser(user);
	
	            listBor.add(borrowing);
	
	        }
    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return listBor;

    }
    
    
    public List<Borrowing> selectAllBorrowingType( int book_reference, int reader_id) {

    	List<Borrowing> listBor = new ArrayList<>();
    	try {
	        Statement stmt = getConnection().createStatement();
	        ResultSet rs = null;
	        rs = stmt.executeQuery("SELECT * FROM borrowing WHERE book_reference = '"+book_reference+"' and reader_id = '"+reader_id+"' and status = 'Borrowed'");
	     
	        while (rs.next()) {
	            Borrowing borrowing = new Borrowing();
	            Book book = new Book();
	            User user = new User();
	
	            book.setReference(rs.getInt("book_reference"));
	            book.setName(rs.getString("book_name"));
	            user.setName(rs.getString("reader_name"));
	            user.setId(rs.getInt("reader_id"));
	            borrowing.setId(rs.getInt("id"));
	            borrowing.setStatus(rs.getString("status"));
	            borrowing.setStartPeriod(rs.getString("issue_date"));
	            borrowing.setEndPeriod(rs.getString("due_date"));
	            borrowing.setStatus(rs.getString("status"));
	            borrowing.setDeliveryDate(rs.getString("delivery_date"));
	            borrowing.setBook(book);
	            borrowing.setUser(user);
	
	            listBor.add(borrowing);
	
	        }
    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return listBor;

    }
    //updating borrowing count
    public boolean updateBorrowingCount(int id) {
    	boolean result = false;
        try {
            String sql1 = "update readers set noBorrowings = noBorrowings + 1 where idreader = '"+id+"'";
            PreparedStatement pst1 = getConnection().prepareStatement(sql1);
            int rowCount = pst1.executeUpdate();

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
    //Updates the status of the borrowing when returned and the delivery date
    public boolean updateBorrowingStatus(int book_reference, int reader_id) {
    	boolean result = false;
    	try {
    	String sql = "Update borrowing set status = 'Returned', delivery_date = '"+currentDate()+"' WHERE book_reference = '"+book_reference+"' and reader_id = '"+reader_id+"'";
    	PreparedStatement pst = getConnection().prepareStatement(sql);
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
    //Return the string used in the delivery date field
    public String currentDate() {
    	
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String current = dateFormat.format(date);
        
        return current;
        
    }
    
    //checking whether book already allocated or not
    public boolean isAlreadyIssued(int bId, int rId) {
        boolean isAlreadyIssued = false;
        try {
            String sql = "select * from borrowing where book_reference = '"+bId+"' and reader_id = '"+rId+"' and status = 'Borrowed'";
            PreparedStatement pst = getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                isAlreadyIssued = true;
            } else {
                isAlreadyIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;

    }
        
    
	

}
