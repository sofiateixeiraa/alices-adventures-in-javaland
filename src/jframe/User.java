package jframe;

public class User {

    private int id;
    private String name;
    private String email;
    private int phoneNumber;
    private int noBorrowedBooks;
    protected String password;

    public User(int id, String name, String email, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    public Object[] userToVector(User user) {
    	
    	String readerId = String.valueOf(user.getId());
    	String readerName = user.getName();
    	String email = user.getEmail();
    	String phoneNumber = String.valueOf(user.getPhoneNumber());
    	String noBorrowings = String.valueOf(user.getNoBorrowedBooks());
    	
    	Object[] obj = {readerId,readerName,email, phoneNumber, noBorrowings};
    	
    	return obj;
    }

    public User() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNoBorrowedBooks() {
        return noBorrowedBooks;
    }

    public void setNoBorrowedBooks(int noBorrowedBooks) {
        this.noBorrowedBooks = noBorrowedBooks;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}