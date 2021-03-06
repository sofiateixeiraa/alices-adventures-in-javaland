package jframe;
import rojeru_san.componentes.RSDateChooser;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
* @author tina
 * @author stsof
 */
public class BookBorrowing extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public BookBorrowing() {
        initComponents();
    }
  //Fetch the book details from the DB and display it in book details 
    public void getBookDetails() {
    	DatabaseBook dbB = new DatabaseBook();
    	Book book = dbB.selectABook(Integer.parseInt(txt_bookReference.getText()));
    	lbl_bookError.setText("");
    	if (book != null) {
            lbl_bookReference.setText((String.valueOf(book.getReference())));
            lbl_bookName.setText( book.getName());
            lbl_bookAuthor.setText( book.getAuthor());
            lbl_quantity.setText(String.valueOf(book.getQuantity()));
        }
        else {
        	lbl_bookError.setText("Invalid Book ID");
        }

    }
    //Fetch the reader details from the DB and display it in reader details 
    public void getReaderDetails() {
    	DatabaseReader dbR = new DatabaseReader();
    	User reader = dbR.selectAReader(Integer.parseInt(txt_readerID.getText()));
    	lbl_readerError.setText("");
        if (reader != null) {
            lbl_readerID.setText( String.valueOf(reader.getId()));
            lbl_readerName.setText(reader.getName());
            lbl_email.setText(reader.getEmail());
            lbl_contact.setText(String.valueOf(reader.getPhoneNumber()));
            lbl_noBorrowings.setText(String.valueOf(reader.getNoBorrowedBooks()));
        }
        else {
        	lbl_readerError.setText("Invalid Reader ID");
        }
   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_bookReference = new javax.swing.JTextField();
        txt_bookReference.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		if(!txt_bookReference.getText().equals("")) {
        			getBookDetails();
        		}
        	}
        });
        jLabel14 = new javax.swing.JLabel();
        txt_readerID = new javax.swing.JTextField();
        txt_readerID.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		if(!txt_readerID.getText().equals("")) {
        			getReaderDetails();
        		}
        	}
        });
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_bookAuthor = new javax.swing.JLabel();
        lbl_bookReference = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        lbl_readerID = new javax.swing.JLabel();
        lbl_contact = new javax.swing.JLabel();
        lbl_readerName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel_main.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(22, 54, 150));
        jLabel12.setText("Borrowing");

        jLabel13.setBackground(new java.awt.Color(204, 204, 255));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Reader");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 19)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(22, 54, 150));
        jLabel7.setText("Enter Book ID:");

        txt_bookReference.setBackground(new java.awt.Color(203, 187, 139));
        txt_bookReference.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        txt_bookReference.setForeground(new java.awt.Color(22, 54, 150));
        txt_bookReference.setToolTipText("");
        txt_bookReference.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(22, 54, 150)));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 19)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(22, 54, 150));
        jLabel14.setText("Enter Reader ID:");

        txt_readerID.setBackground(new java.awt.Color(203, 187, 139));
        txt_readerID.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        txt_readerID.setForeground(new java.awt.Color(22, 54, 150));
        txt_readerID.setToolTipText("");
        txt_readerID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(22, 54, 150)));
        
        JLabel lblBorrowingDate = new JLabel();
        lblBorrowingDate.setText("Borrowing Date:");
        lblBorrowingDate.setForeground(new Color(22, 54, 150));
        lblBorrowingDate.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 19));
        
        JLabel lblEndDate = new JLabel();
        lblEndDate.setText("End Date:");
        lblEndDate.setForeground(new Color(22, 54, 150));
        lblEndDate.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 19));
        
        btnNewButton = new JButton("Borrowing");
        btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	btnNewButtonMouseClicked(evt);
            }
        });

        btnNewButton.setBackground(new java.awt.Color(203, 187, 139));
        btnNewButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnNewButton.setForeground(new java.awt.Color(51, 51, 51));
        btnNewButton.setText("Borrow");
        btnNewButton.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(203, 187, 139)));
        btnNewButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        JLabel jLabel2_1 = new JLabel();
        jLabel2_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.exit(0);
        	}
        });
        jLabel2_1.setText("X");
        jLabel2_1.setForeground(new java.awt.Color(22, 54, 150));
        jLabel2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
        jLabel2_1.setBackground(Color.WHITE);
        
        date_chooser = new com.toedter.calendar.JDateChooser();
        
        date_chooser1 = new com.toedter.calendar.JDateChooser();

        javax.swing.GroupLayout panel_mainLayout = new javax.swing.GroupLayout(panel_main);
        panel_mainLayout.setHorizontalGroup(
        	panel_mainLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panel_mainLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(panel_mainLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(date_chooser, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
        				.addGroup(panel_mainLayout.createParallelGroup(Alignment.TRAILING)
        					.addGroup(panel_mainLayout.createSequentialGroup()
        						.addGroup(panel_mainLayout.createParallelGroup(Alignment.LEADING)
        							.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
        							.addComponent(lblEndDate, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
        							.addGroup(panel_mainLayout.createSequentialGroup()
        								.addComponent(lblBorrowingDate, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
        								.addGap(39)
        								.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
        							.addGroup(panel_mainLayout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(txt_readerID, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        								.addComponent(txt_bookReference, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        								.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
        						.addGap(462))
        					.addGroup(panel_mainLayout.createSequentialGroup()
        						.addComponent(jLabel2_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        						.addGap(197)))
        				.addComponent(date_chooser1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_mainLayout.setVerticalGroup(
        	panel_mainLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panel_mainLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel2_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addGap(30)
        			.addComponent(jLabel12)
        			.addGap(43)
        			.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(txt_bookReference, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(36)
        			.addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(txt_readerID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(29)
        			.addGroup(panel_mainLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblBorrowingDate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel13))
        			.addGap(27)
        			.addComponent(date_chooser, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addGap(33)
        			.addComponent(lblEndDate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addGap(28)
        			.addComponent(date_chooser1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
        			.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        			.addGap(73))
        );
        panel_main.setLayout(panel_mainLayout);

        jPanel1.setBackground(new java.awt.Color(22, 54, 150));
        jPanel1.setPreferredSize(new java.awt.Dimension(420, 608));

        jPanel2.setBackground(new java.awt.Color(203, 187, 139));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Book ");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(342, 5));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Book Name:");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book ID:");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quantity:");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Author:");

        lbl_bookAuthor.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_bookAuthor.setForeground(new java.awt.Color(255, 255, 255));

        lbl_bookReference.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_bookReference.setForeground(new java.awt.Color(255, 255, 255));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        
        lbl_bookError = new JLabel();
        lbl_bookError.setForeground(new Color(255, 0, 0));
        lbl_bookError.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_bookReference, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(183)
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_bookName, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_bookAuthor, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_quantity, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(120)
        					.addComponent(lbl_bookError, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(42)
        					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel1)
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_bookReference, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
        			.addGap(52)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_bookName, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
        			.addGap(55)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_bookAuthor, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
        			.addGap(63)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_quantity, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
        			.addGap(86)
        			.addComponent(lbl_bookError, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        jPanel5.setBackground(new java.awt.Color(203, 187, 139));
        jPanel5.setPreferredSize(new java.awt.Dimension(420, 608));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Reader");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(342, 5));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Reader Name:");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Reader ID:");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Contact:");

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Email:");

        lbl_email.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(255, 255, 255));

        lbl_readerID.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_readerID.setForeground(new java.awt.Color(255, 255, 255));

        lbl_contact.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_contact.setForeground(new java.awt.Color(255, 255, 255));

        lbl_readerName.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 20)); // NOI18N
        lbl_readerName.setForeground(new java.awt.Color(255, 255, 255));
        
        lbl_readerError = new JLabel();
        lbl_readerError.setForeground(Color.RED);
        lbl_readerError.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        
        lblNoBorrowing = new JLabel();
        lblNoBorrowing.setText("No. Borrowings:");
        lblNoBorrowing.setForeground(Color.WHITE);
        lblNoBorrowing.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        
        lbl_noBorrowings = new JLabel();
        lbl_noBorrowings.setForeground(Color.WHITE);
        lbl_noBorrowings.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5Layout.setHorizontalGroup(
        	jPanel5Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel5Layout.createSequentialGroup()
        			.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_readerID, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addGap(183)
        					.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addGap(42)
        					.addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_readerName, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel21, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_email, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_contact, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addGap(128)
        					.addComponent(lbl_readerError, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblNoBorrowing, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_noBorrowings, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
        	jPanel5Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel5Layout.createSequentialGroup()
        			.addGap(74)
        			.addComponent(jLabel8)
        			.addGap(18)
        			.addGroup(jPanel5Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_readerID, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
        			.addGap(52)
        			.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_readerName, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
        			.addGap(55)
        			.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel21, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_email, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
        			.addGap(63)
        			.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_contact, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
        			.addGap(52)
        			.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNoBorrowing, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_noBorrowings, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lbl_readerError, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(164, Short.MAX_VALUE))
        );
        jPanel5.setLayout(jPanel5Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
        			.addGap(2)
        			.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel_main, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
        		.addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
        		.addComponent(panel_main, GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        setSize(new java.awt.Dimension(1414, 751));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked
    
    private void btnNewButtonMouseClicked(java.awt.event.MouseEvent evt) { 
    	DatabaseBorrowing dbB = new DatabaseBorrowing();
    	DatabaseBook dbBook = new DatabaseBook();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // TODO add your handling code here:
        if (lbl_quantity.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Book is not available");
        } else {

            if (dbB.isAlreadyIssued(Integer.parseInt(txt_bookReference.getText()), Integer.parseInt(txt_readerID.getText())) == false) {

                if (dbB.insertBorrowing(Integer.parseInt(txt_bookReference.getText()), lbl_bookName.getText(), Integer.parseInt(txt_readerID.getText()), lbl_readerName.getText(), sdf.format(date_chooser.getDate()),sdf.format(date_chooser1.getDate())) 
                		&& dbBook.updateBookCount(Integer.parseInt(txt_bookReference.getText())) 
                		&& dbB.updateBorrowingCount(Integer.parseInt(txt_readerID.getText()))) {
                    JOptionPane.showMessageDialog(this, "Book issued successfully");
                    getReaderDetails();
                    getBookDetails();
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Can't issue the book");
                }

            } else {
                JOptionPane.showMessageDialog(this, "This student already has this book");
            }

        }
    }   

        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookBorrowing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookBorrowing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookBorrowing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookBorrowing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookBorrowing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_bookAuthor;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_bookReference;
    private javax.swing.JLabel lbl_contact;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_readerID;
    private javax.swing.JLabel lbl_readerName;
    private javax.swing.JPanel panel_main;
    private javax.swing.JTextField txt_bookReference;
    private javax.swing.JTextField txt_readerID;
    private JButton btnNewButton;
    private JLabel lbl_bookError;
    private JLabel lbl_readerError;
    private com.toedter.calendar.JDateChooser date_chooser1;
	private com.toedter.calendar.JDateChooser date_chooser;
	private JLabel lblNoBorrowing;
	private JLabel lbl_noBorrowings;
}

