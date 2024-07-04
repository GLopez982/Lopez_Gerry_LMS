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
import java.nio.file.Paths;
import java.awt.Color;
import java.awt.FlowLayout;
import java.nio.file.Path;


public class LMSFrame extends JFrame implements ActionListener{
    private BookCollection bookCollection = new BookCollection();
    private final int WIDTH = 1100;
    private final int HEIGHT = 300;
    private String[] menuString ={"Add a book from text file", "Remove a book by ISBN", "Remove a book by title", "Check-out a book", "Check-in a book", "Display catalogue", "Quit"};
    private JComboBox<String> menuBox = new JComboBox<>(menuString);
    private JButton submit = new JButton("Submit");
    private FlowLayout layout = new FlowLayout();
    private JLabel menuLabel = new JLabel("LMS Menu:");
    private Font menuFont = new Font("Gadugi", Font.PLAIN, 15);
    private JTextArea displayText = new JTextArea(10,80);
    private JPanel textPanel = new JPanel();
    private JScrollPane pane = new JScrollPane(displayText);
       

    public LMSFrame(){
        setTitle("Library Management System");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(layout);
        getContentPane().setBackground(Color.ORANGE);
        menuLabel.setFont(menuFont);
        add(menuLabel);
        menuBox.setFont(menuFont);
        textPanel.add(menuBox);
        textPanel.add(pane);
        textPanel.setBackground(Color.black);
        add(textPanel);
        add(submit);

        menuBox.addActionListener(this);
        submit.addActionListener(this);


        
    }

    /*REQUIRED METHOD FOR ACTIONLISTENER. THIS METHOD IS USED TO PROVIDE FUNCTIONALITY TO THE JCOMBO BOX AND SUBMIT BUTTON 
     * ALLOWING THE USER TO MAKE CHOICES AND FROM THE MENU OPTIONS. 
     */
    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();
        String comboString = (String) menuBox.getSelectedItem();
        
        if(comboString.equals("Add a book from text file")){
            if(source == submit){
                String filePathString = JOptionPane.showInputDialog("Enter the file path for the text file (.txt) (format EXAMPLE: DRIVE:\\PATH\\SUBPATH\\FILE.TXT) >>> " );
                Path filePath = Paths.get(filePathString);
                bookCollection.addBookToCollection(filePath);
                displayText.setText("Uploading...");
                bookCollection.displayBooksInFrame(displayText, pane);
                pack();
                         
            }

           }

        if(comboString.equals("Remove a book by ISBN")){
            if(source == submit){
                String ISBN = JOptionPane.showInputDialog("Enter a valid ISBN number to for book removal");
                displayText.setText("Removing Book...");
                bookCollection.removeBooksFromCollection(ISBN);
                bookCollection.displayBooksInFrame(displayText, pane);
                pack();
            }
        }

        if(comboString.equals("Remove a book by title")){
            if(source == submit){
                String removeTitle = JOptionPane.showInputDialog("Enter the full book title for removal");
                displayText.setText("Removing Book...");
                bookCollection.removeBookByTitle(removeTitle);
                bookCollection.displayBooksInFrame(displayText, pane);
                pack();
               
            }
        }

        if(comboString.equals("Check-out a book")){
            if(source == submit){
                String checkoutBook = JOptionPane.showInputDialog("Enter the full book title for check-out");
                displayText.setText("Checking out Book...");
                bookCollection.checkOutBook(checkoutBook);
                bookCollection.displayBooksInFrame(displayText, pane);

                pack();
            }
        }

        if(comboString.equals("Check-in a book")){
            if(source == submit){
                String checkInBook = JOptionPane.showInputDialog("Enter the full book title for check-in");
                displayText.setText("Checking in Book...");
                bookCollection.checkInBook(checkInBook);
                bookCollection.displayBooksInFrame(displayText, pane);

                pack();
            }
        }

        if(comboString.equals("Display catalogue")){
            if(source == submit){
                bookCollection.displayBooksInFrame(displayText, pane);
                pack();
            }
        }

        if(comboString.equals("Quit")){
            if(source == submit){
                JOptionPane.showMessageDialog(null,"Exiting Program....Have a great day");
                dispose();
            }
        }




    }

    //MAIN METHOD FOR THE LMS GUI SYSTEM. 
    public static void main(String[] args) {
        LMSFrame LMS = new LMSFrame();
        LMS.setVisible(true);

        
    }

}
