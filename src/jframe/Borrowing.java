package jframe;

import java.security.Timestamp;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter

public class Borrowing {

    private int id;
    private String startPeriod;
    private String endPeriod;
    private String deliveryDate;
    private String status;
    private User user;
    private Book book;

    public Borrowing() {
    }

    public Borrowing(int id, String startPeriod, User user, Book book) {
        this.id = id;
        this.startPeriod = startPeriod;
        this.user = user;
        this.book = book;
    }
  //Returns an object with the desired order to display on the table
    public Object[] borrowingToVector(Borrowing borrow) {
    	
    	String readerName = borrow.getUser().getName();
    	String bookName = borrow.getBook().getName();
    	String issueDate = borrow.getStartPeriod();
    	String dueDate = borrow.getEndPeriod();
    	String status = borrow.getStatus();
    			
    	
    	Object[] obj = {readerName, bookName, issueDate, dueDate, status};
    	
    	return obj;
    }
  //Returns an object with the desired order to display on the table
    public Object[] borrowingToVector2(Borrowing borrow) {
    	
    	String id  = String.valueOf(borrow.getId());
    	String readerName = borrow.getUser().getName();
    	String bookName = borrow.getBook().getName();
    	String issueDate = borrow.getStartPeriod();
    	String dueDate = borrow.getEndPeriod();
    	String status = borrow.getStatus();
    			
    	
    	Object[] obj = {id, bookName, readerName, issueDate, dueDate, status};
    	
    	return obj;
    }
  //Returns an object with the desired order to display on the table
    public Object[] borrowingToVector3(Borrowing borrow) {
    	
    	String readerName = borrow.getUser().getName();
    	String bookName = borrow.getBook().getName();
    	String issueDate = borrow.getStartPeriod();
    	String dueDate = borrow.getEndPeriod();
    	String deliveryDate = borrow.getDeliveryDate();
    	String status = borrow.getStatus();
    			
    	
    	Object[] obj = {readerName, bookName, issueDate, deliveryDate, dueDate, status};
    	
    	return obj;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(String startPeriod) {
        this.startPeriod = startPeriod;
    }

    public String getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(String endPeriod) {
        this.endPeriod = endPeriod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String setCurrentPeriod() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        return formattedDate;
    }

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
}
