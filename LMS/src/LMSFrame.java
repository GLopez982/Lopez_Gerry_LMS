/* GERRY LOPEZ
 * CEN-3024C
 * CLASS FUNCTION: THIS IS THE GUI OF THE LMS SYSTEM AND THE MAIN CLASS. THIS CLASS IS INTENDED TO ALLOW THE USER TO SELECT FROM A MENU 
 * WHETHER THEY WANT TO ADD, REMOVE, CHECK OUT, CHECK IN,  OR DISPLAY BOOKS IN THE COLLECTION. THE MAIN METHOD WILL CONTINUE TO RUN UNTIL 
 * THE USER SELECTS THE OPTION TO QUIT.
 *   
 */

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.Color;
import java.awt.FlowLayout;
// import java.nio.file.Path;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class LMSFrame extends JFrame implements ActionListener {
    // private BookCollection bookCollection = new BookCollection();
    private final int WIDTH = 1100;
    private final int HEIGHT = 300;
    private String[] menuString = { "Add a book", "Remove a book by ISBN", "Remove a book by title",
            "Check-out a book", "Check-in a book", "Display catalogue", "Quit"};
    private JComboBox<String> menuBox = new JComboBox<>(menuString);
    private JButton submit = new JButton("Submit");
    private FlowLayout layout = new FlowLayout();
    private JLabel menuLabel = new JLabel("LMS Menu:");
    private Font menuFont = new Font("Gadugi", Font.PLAIN, 15);
    private JTextArea displayText = new JTextArea(10, 80);
    private JPanel textPanel = new JPanel();
    private JScrollPane pane = new JScrollPane(displayText);


    public LMSFrame() {
        setTitle("Library Management System");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(layout);
        getContentPane().setBackground(new Color(25,65,75));
        displayText.setBackground(Color.lightGray);
        menuLabel.setFont(menuFont);
        add(menuLabel);
        menuBox.setFont(menuFont);
        textPanel.add(menuBox);
        textPanel.add(pane);
        textPanel.setBackground(new Color(22,156,175));
        add(textPanel);
        add(submit);

        menuBox.addActionListener(this);
        submit.addActionListener(this);

    }

    /*
     * REQUIRED METHOD FOR ACTIONLISTENER. THIS METHOD IS USED TO PROVIDE
     * FUNCTIONALITY TO THE JCOMBO BOX AND SUBMIT BUTTON
     * ALLOWING THE USER TO MAKE CHOICES FROM THE MENU OPTIONS.
     */
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        String comboString = (String) menuBox.getSelectedItem();

        if (comboString.equals("Add a book")) {
            if (source == submit) {
                try {
                    String bookQuery = "INSERT INTO BOOKCATALOGUE (GENRE, TITLE, AUTHOR) " + "VALUES(?, ?, ?)";
                    String bookGenre;
                    String bookTitle;
                    String bookAuthor;

                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root",
                            "Whitehot2005!");
                    PreparedStatement statement = connection.prepareStatement(bookQuery);
                    bookGenre = JOptionPane.showInputDialog(rootPane, "Enter the Genre of the book").toUpperCase();
                    bookTitle = JOptionPane.showInputDialog(rootPane, "Enter the title of the book").toUpperCase();
                    bookAuthor = JOptionPane.showInputDialog(rootPane, "Enter the author of the book").toUpperCase();
                    statement.setString(1, bookGenre);
                    statement.setString(2, bookTitle);
                    statement.setString(3, bookAuthor);
                    statement.executeUpdate();

                    statement.close();
                    connection.close();

                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(rootPane, exception.getMessage());
                }

            }
            pack();

        }

        if (comboString.equals("Remove a book by ISBN")) {
            if (source == submit) {
                try {
                    String titleQuery = "DELETE FROM BOOKCATALOGUE WHERE ISBN = ?";
                    String bookISBNString = JOptionPane.showInputDialog(rootPane, "Enter the book ISBN for removal:");
                    int bookISBN = Integer.parseInt(bookISBNString);
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root",
                            "Whitehot2005!");

                    PreparedStatement statement = connection.prepareStatement(titleQuery);
                    if(bookISBNString != null && !bookISBNString.isEmpty()){
                        String checkISNBQuery = "SELECT * FROM BOOKCATALOGUE WHERE ISBN = ?";
                        PreparedStatement checkStatement = connection.prepareStatement(checkISNBQuery);
                        checkStatement.setInt(1, bookISBN);
                        if(checkStatement.executeQuery().next()){
                           statement.setInt(1, bookISBN);
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(rootPane, "Book Deleted..."); 
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Invalid ISBN PROVIDED");
                        }
                    }else{
                            JOptionPane.showMessageDialog(rootPane, "ISBN WAS NOT FOUND IN THE DATABASE");
                    }                    
                    getDatabase();

                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(rootPane, "Error>>" + exception.getMessage());
                }

            }
            pack();
        }

        if (comboString.equals("Remove a book by title")) {
            if (source == submit) {
                try {
                    String titleQuery = "DELETE FROM BOOKCATALOGUE WHERE TITLE = ?";
                    String bookTitle = JOptionPane.showInputDialog(rootPane, "Enter the book title for removal:");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root",
                            "Whitehot2005!");

                    PreparedStatement statement = connection.prepareStatement(titleQuery);
                    if(bookTitle != null && !bookTitle.isEmpty()){
                        String checkQuery = "SELECT * FROM BOOKCATALOGUE WHERE TITLE = ?";
                        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
                        checkStatement.setString(1, bookTitle);
                        if(checkStatement.executeQuery().next()){
                            statement.setString(1, bookTitle);
                            statement.executeUpdate();
                            JOptionPane.showMessageDialog(rootPane, "Book Deleted...");
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "INVALID BOOK TITLE PROVIDED>>>");
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "BOOK TITLE NOT LOCATED IN DATABASE>>>");
                    }                   
                    
                    getDatabase();

                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(rootPane, "Error>>" + exception.getMessage());
                }

            }
            pack();
        }

        if (comboString.equals("Check-out a book")) {
            if (source == submit) {
                try {
                    String titleQuery = "UPDATE BOOKCATALOGUE SET DUE_DATE = ?, BOOK_STATUS = ? WHERE TITLE = ?";
                    String bookTitle = JOptionPane.showInputDialog(rootPane, "Enter the book title for check-out:");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root",
                            "Whitehot2005!");
                    LocalDate date = LocalDate.now().plusWeeks(4);
                    Date sqlDate = Date.valueOf(date);
    
                    PreparedStatement statement = connection.prepareStatement(titleQuery);
                    if(bookTitle != null && !bookTitle.isEmpty()){
                        String validCheckout = "SELECT * FROM BOOKCATALOGUE WHERE TITLE = ? AND BOOK_STATUS IS NOT NULL AND BOOK_STATUS != 'CHECKED-OUT'";
                        PreparedStatement checkedoutStatement = connection.prepareStatement(validCheckout);
                        checkedoutStatement.setString(1, bookTitle);
                        ResultSet checkedoutResults = checkedoutStatement.executeQuery();
                        if(checkedoutResults.next()){
                           statement.setDate(1,sqlDate);
                    statement.setString(2, "CHECKED-OUT");
                    statement.setString(3, bookTitle);
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(rootPane, "Book checked out...");
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Book already checked out");
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Book not found in database for checkout");
                    }
                    getDatabase();

                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(rootPane, "Error>>" + exception.getMessage());
                }

            }
            pack();

        }

        if (comboString.equals("Check-in a book")) {
            if(source == submit){
                try {
                    String titleQuery = "UPDATE BOOKCATALOGUE SET DUE_DATE = ?, BOOK_STATUS = ? WHERE TITLE = ?";
                    String bookTitle = JOptionPane.showInputDialog(rootPane, "Enter the book title for check-in");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root",
                            "Whitehot2005!");
                    Date sqlDate = null;
    
                    PreparedStatement statement = connection.prepareStatement(titleQuery);
                    if(bookTitle != null && !bookTitle.isEmpty()){
                        String validCheckin = "SELECT * FROM BOOKCATALOGUE WHERE TITLE = ? AND BOOK_STATUS = 'CHECKED-OUT'";
                        PreparedStatement checkedoutStatement = connection.prepareStatement(validCheckin);
                        checkedoutStatement.setString(1, bookTitle);
                        ResultSet checkedoutResults = checkedoutStatement.executeQuery();
                        if(checkedoutResults.next()){
                           statement.setDate(1, sqlDate );
                    statement.setString(2, "CHECKED-IN");
                    statement.setString(3, bookTitle);
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(rootPane, "Book checked in...");
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Book already checked in");
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Book not found in database for checkin");
                    }
                    getDatabase();

                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(rootPane, "Error>>" + exception.getMessage());
                }

                
            }
            pack();
        }

        if (comboString.equals("Display catalogue")) {
            if (source == submit) {
                getDatabase();
                pack();

            }
        }

        if (comboString.equals("Quit")) {
            if (source == submit) {
                JOptionPane.showMessageDialog(null, "Exiting Program....Have a great day");
                dispose();
            }
        }


    }
    
    //METHOD FOR GETTING BOOK DATA FROM THE DATABASE. 
    public void getDatabase() {
        try {
            String getQuery = "SELECT * FROM BOOKCATALOGUE";
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root",
                    "Whitehot2005!");
            Statement resulStatement = connection.createStatement();

            ResultSet resultSet = resulStatement.executeQuery(getQuery);
            ResultSetMetaData resultMeta = resultSet.getMetaData();
            int colCount = resultMeta.getColumnCount();

            StringBuilder resultString = new StringBuilder();

            for (int i = 1; i <= colCount; i++) {
                String colName = resultMeta.getColumnName(i);

                resultString.append(colName).append("\t\t");
                String.format("%s--", resultString);

            }
            resultString.append("\n");

            while (resultSet.next()) {

                for (int i = 1; i <= colCount; ++i) {

                    resultString.append(resultSet.getString(i)).append("\t\t");

                }
                resultString.append("\n");

            }
            String.format("%s--", resultString);
            displayText.setText(resultString.toString());
            displayText.setSize(displayText.getPreferredSize());
            displayText.setCaretPosition(0);
            pane.revalidate();
            pane.repaint();
            connection.close();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(rootPane, "Error>>." + exception.getMessage());

        }

    }

    public static void main(String[] args) {
        LMSFrame LMS = new LMSFrame();
        LMS.setVisible(true);

    }

}
