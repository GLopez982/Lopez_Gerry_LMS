
/* GERRY LOPEZ
 * CEN-3024C
 * CLASS FUNCTION: THIS CLASS IS INTENDED TO ADD BOOKS TO A COLLECTION OF BOOK OBJECTS IN AN ARRAY LIST,
 * ALLOW THE USER TO REMOVE BOOKS FROM THE COLLECTION AND DISPLAY THE BOOKS IN THE COLLECTION.  
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static java.nio.file.StandardOpenOption.READ;

import java.awt.Dimension;

public class BookCollection {

    private ArrayList<Book> bookCollection;

    public BookCollection() {
        this.bookCollection = new ArrayList<>();

    }

    /*
     * METHOD FOR ADDING BOOK DATA FROM A TEXT FILE TO THE COLLECTION. THE METHOD
     * USES A PATH PARAMATER TO GET THE TEXT FILE LOCATION OF THE DATA
     * THE METHOD WILL COLLECT THE DATA FROM THE TEXT, SPLIT THE COLLECTED DATA INTO
     * THREE STRINGS AND THEN STORE THE STRING DATA IN A BOOK OBJECT.
     * THE BOOK OBJECT WILL THEN BE STORED TO AN ARRAY LIST OF BOOK OBJECTS TO
     * CREATE THE BOOK COLLECTION.
     */
    public void addBookToCollection(Path file) {

        try {

            InputStream input = new BufferedInputStream(Files.newInputStream(file, READ));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String emptyString = reader.readLine();

            while (emptyString != null) {

                String delimit = ",";
                String[] fileStrings = new String[3];
                fileStrings = emptyString.split(delimit);

                if (fileStrings.length == 3) {
                    Book book = new Book(fileStrings[0], fileStrings[1], fileStrings[2]);
                    bookCollection.add(book);

                    emptyString = reader.readLine();

                }

            }

        } catch (IOException exception) {
            System.out.println("Error>>>" + exception.getMessage());
            JOptionPane.showMessageDialog(null, "Error>>>" + exception.getMessage());

        }

    }

    /*
     * METHOD FOR REMOVING A BOOK FROM THE COLLECTION OF BOOKS.
     * THE METHOD TAKES A STRING ARGUMENT AND CHECKS TO SEE IF THE PROVIDED ISBN
     * STRING MATCHES ONE IN THE BOOK COLLECTION.
     * IF THE ISBN MATCHES, THE BOOK IS REMOVED FROM THE COLLECTION AND THE METHOD
     * ENDS.
     */

    public void removeBooksFromCollection(String ISBN) {
        Book removedBook = null;

        for (Book book : bookCollection) {
            if (book.getBookISBN().equals(ISBN)) {
                removedBook = book;
                break;

            }
        }

        if (removedBook != null) {
            bookCollection.remove(removedBook);
            JOptionPane.showMessageDialog(null, "Book Removed");
        }else{
            JOptionPane.showMessageDialog(null,"Invalid ISBN");

        }

    }

     /*
     * METHOD FOR REMOVING A BOOK FROM THE COLLECTION OF BOOKS.
     * THE METHOD TAKES A STRING ARGUMENT AND CHECKS TO SEE IF THE PROVIDED Title
     * STRING MATCHES ONE IN THE BOOK COLLECTION.
     * IF THE Title MATCHES, THE BOOK IS REMOVED FROM TEH COLLECTION AND THE METHOD
     * ENDS.
     */
    public void removeBookByTitle(String title){
        Book removedBook = null;

        for(Book book : bookCollection){
            if(book.getBookTitle().toUpperCase().equals(title.toUpperCase())){
                removedBook = book;
                break;
            }

        }
        if(removedBook != null){
            bookCollection.remove(removedBook);
            JOptionPane.showMessageDialog(null, "Book Removed");
        }
        else{
            JOptionPane.showMessageDialog(null,"Invalid title");
            }
    }

    /*
     * METHOD FOR DISPLAYING THE BOOKS CONTAINED WITHIN THE COLLECTION.
     * USES THE OVERRIDDEN TOSTRING CREATED IN THE BOOK OBJECT TO PROVIDE
     * THE DATA FOR THE BOOKS IN THE COLLECTION.
     */
    public void displayBooks() {
        for (Book book : bookCollection) {
            System.out.println(book);
        }
    }

    /* METHOD FOR DISPLAYING THE BOOKS CONTAINED WITHIN THE COLLECTION
     * WITHIN A JTEXTAREA WITH A SCROLLPANE. 
    */

    public void displayBooksInFrame(JTextArea area, JScrollPane scrollPane){
        StringBuilder textString = new StringBuilder();
     
       
        for(Book book : bookCollection){
            textString.append(book.toString()).append("\n\n");
        }
       
        area.setText(textString.toString());
        area.setSize(area.getPreferredSize());
        area.setCaretPosition(0);
        scrollPane.setPreferredSize(new Dimension(area.getWidth(), area.getHeight()));
        scrollPane.revalidate();
        scrollPane.repaint();
        
        
    }
    

    /*METHOD FOR CHECKING OUT A BOOK THAT IS CONTAINED WITHIN THE COLLECTION 
     *USES A STRING PROVIDED BY THE USER TO LOCATE THE BOOK TITLE WITHIN THE COLLECTION
     IF THE TITLE IS FOUND, THE BOOK STATUS IS UPDATED TO CHECKED OUT, 
     IF NOT AN ERROR MESSAGE IS PROVIDED FOR THE USER
    */
    public void checkOutBook(String bookTitle){
        for(Book book : bookCollection){
            if(book.getBookStatus().equals(null) || book.getBookStatus().equals("Checked In")){
                if(book.getBookTitle().toUpperCase().equals(bookTitle.toUpperCase())){
                    LocalDateTime today = LocalDateTime.now();
                    System.out.println("Checking out book...");
                    book.setBookStatus("Checked Out");
                    book.setCheckOutDate(today);
                    book.setReturnDate(today.plusWeeks(4));
                    System.out.println("....Book checked out");
                    JOptionPane.showMessageDialog(null,"Book checked out");
                    break;
                    
                
                
                }else {
                    continue;
                }   
            
            }else if(!book.getBookTitle().equals(bookTitle)){
                JOptionPane.showMessageDialog(null, "Invalid title provided for checkout" );
                System.out.println("Invalid title provided for checkout");
                

            }
        }    

    }

  
    /*METHOD FOR CHECKING IN A BOOK THAT IS CONTAINED WITHIN THE COLLECTION 
     *USES A STRING PROVIDED BY THE USER TO LOCATE THE BOOK TITLE WITHIN THE COLLECTION.
     IF THE TITLE IS FOUND, THE BOOK STATUS IS UPDATED TO AVAILABLE, 
     IF NOT AN ERROR MESSAGE IS PROVIDED FOR THE USER
    */
    public void checkInBook(String bookTitle){
        for(Book book : bookCollection){
            if(book.getBookStatus().equals("Checked Out")){
                if(book.getBookTitle().toUpperCase().equals(bookTitle.toUpperCase())){
                    LocalDateTime returned = null;
                    System.out.println("Checking in book....");
                    book.setBookStatus("Checked In");
                    book.setCheckOutDate(returned);
                    book.setReturnDate(returned);
                    System.out.println("..Book checked in, Now available");
                    JOptionPane.showMessageDialog(null,"Book checked in, now available");
                    break;
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid title provided for check-in" );
                    System.out.println("Invalid Title provided");
                    
                }

                
            }else if(!book.getBookStatus().equals("Checked Out")){
                continue;
                
                    
                }
            
        }

    }
}