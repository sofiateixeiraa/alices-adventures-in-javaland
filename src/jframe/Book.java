package jframe;

import java.sql.Timestamp;

public class Book {

    private int reference;
    private String name;
    private String author;
    private int publication;
    private Timestamp added;
    private int status;
    private int type;
    private String tag;
    private int quantity;
    private String url;

    public Book() { }
    
    public String typeBook(int type) {
    	if(type == 0) {
    		return "Book";
    	}else {
    		return "E-Book";
    	}
    }
    
    public int stringToType(String type) {
    	if(type.equalsIgnoreCase("book")) {
    		return 0;
    	}else {
    		return 1;
    	}
    }
    //Returns an object with the desired order to display on the table
    public Object[] bookToVector(Book book) {
    	String type;
    	
		String reference = String.valueOf(book.getReference()); 
		String bookName = book.getName();
		String author = book.getAuthor();
		String quantity = String.valueOf(book.getQuantity()); 
		String genre = book.getTag(); 
    	String publication = String.valueOf(book.getPublication());
    	type = typeBook(book.getType());
    	
		Object [] obj = {reference, bookName, author, publication, quantity, genre, type};
    	
    	return obj;
    }
  //Returns an object with the desired order to display on the table
    public Object[] bookToVector2(Book book) {
    	String type;
    	
		String reference = String.valueOf(book.getReference()); 
		String bookName = book.getName();
		String author = book.getAuthor();
		String quantity = String.valueOf(book.getQuantity()); 
		String genre = book.getTag(); 

    	
		Object [] obj = {reference, bookName, author, quantity, genre};
    	
    	return obj;
    }

    
    public Book(int reference, String name, String author, int publication,Timestamp added, int status, int type, String tag) {
        this.reference = reference;
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.added = added;
        this.status = status;
        this.type = type;
        this.tag = tag;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public Timestamp getAdded() {
        return added;
    }

    public void setAdded(Timestamp timestamp) {
        this.added = timestamp;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
