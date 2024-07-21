/**
 * CLASS FUNCTION: This class is intended to add books to a collection of Book objects in an ArrayList,
 * allow the user to remove books from the collection, and display the books in the collection.
 *
 * <p>Course: CEN-3024C</p>
 *
 * @author Gerry Lopez
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
 
     /**
      * Method for adding book data from a text file to the collection.
      * The method uses a Path parameter to get the text file location of the data.
      * The method will collect the data from the text, split the collected data into
      * three strings, and then store the string data in a Book object.
      * The Book object will then be stored in an ArrayList of Book objects to
      * create the book collection.
      *
      * @param file - the file path to the text file containing the book data
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
 
     /**
      * Method for removing a book from the collection of books.
      * The method takes a string argument and checks to see if the provided ISBN
      * string matches one in the book collection.
      * If the ISBN matches, the book is removed from the collection and the method
      * ends.
      *
      * @param ISBN - ISBN of the book to be removed from the collection
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
         } else {
             JOptionPane.showMessageDialog(null, "Invalid ISBN");
 
         }
 
     }
 
     /**
      * Method for removing a book from the collection of books.
      * The method takes a string argument and checks to see if the provided title
      * string matches one in the book collection.
      * If the title matches, the book is removed from the collection and the method
      * ends.
      *
      * @param title - The title of the book to be removed from the collection
      */
     public void removeBook(String title) {
         // Method implementation
     }
 
     public void removeBookByTitle(String title) {
         Book removedBook = null;
 
         for (Book book : bookCollection) {
             if (book.getBookTitle().toUpperCase().equals(title.toUpperCase())) {
                 removedBook = book;
                 break;
             }
 
         }
         if (removedBook != null) {
             bookCollection.remove(removedBook);
             JOptionPane.showMessageDialog(null, "Book Removed");
         } else {
             JOptionPane.showMessageDialog(null, "Invalid title");
         }
     }
 
     /**
      * Method for displaying the books contained within the collection.
      * Uses the overridden toString method in the Book object to provide
      * the data for the books in the collection.
      */
     public void displayBooks() {
         for (Book book : bookCollection) {
             System.out.println(book);
         }
     }
 
     /**
      * Method for displaying the books contained within the collection
      * within a JTextArea with a JScrollPane.
      */
 
     public void displayBooksInFrame(JTextArea area, JScrollPane scrollPane) {
         StringBuilder textString = new StringBuilder();
 
         for (Book book : bookCollection) {
             textString.append(book.toString()).append("\n\n");
         }
 
         area.setText(textString.toString());
         area.setSize(area.getPreferredSize());
         area.setCaretPosition(0);
         scrollPane.setPreferredSize(new Dimension(area.getWidth(), area.getHeight()));
         scrollPane.revalidate();
         scrollPane.repaint();
 
     }
 
     /**
      * Method for checking out a book that is contained within the collection.
      * Uses a string provided by the user to locate the book title within the
      * collection.
      * If the title is found, the book status is updated to checked out;
      * if not, an error message is provided for the user.
      *
      * @param bookTitle - The title String of the book to be checked out
      */
     public void checkOutBook(String bookTitle) {
         for (Book book : bookCollection) {
             if (book.getBookStatus().equals(null) || book.getBookStatus().equals("Checked In")) {
                 if (book.getBookTitle().toUpperCase().equals(bookTitle.toUpperCase())) {
                     LocalDateTime today = LocalDateTime.now();
                     System.out.println("Checking out book...");
                     book.setBookStatus("Checked Out");
                     book.setCheckOutDate(today);
                     book.setReturnDate(today.plusWeeks(4));
                     System.out.println("....Book checked out");
                     JOptionPane.showMessageDialog(null, "Book checked out");
                     break;
 
                 } else {
                     continue;
                 }
 
             } else if (!book.getBookTitle().equals(bookTitle)) {
                 JOptionPane.showMessageDialog(null, "Invalid title provided for checkout");
                 System.out.println("Invalid title provided for checkout");
 
             }
         }
 
     }
 
     /**
      * Method for checking in a book that is contained within the collection.
      * Uses a string provided by the user to locate the book title within the
      * collection.
      * If the title is found, the book status is updated to available;
      * if not, an error message is provided for the user.
      *
      * @param bookTitle - The title String of the book to be checked in
      */
     public void checkInBook(String bookTitle) {
         for (Book book : bookCollection) {
             if (book.getBookStatus().equals("Checked Out")) {
                 if (book.getBookTitle().toUpperCase().equals(bookTitle.toUpperCase())) {
                     LocalDateTime returned = null;
                     System.out.println("Checking in book....");
                     book.setBookStatus("Checked In");
                     book.setCheckOutDate(returned);
                     book.setReturnDate(returned);
                     System.out.println("..Book checked in, Now available");
                     JOptionPane.showMessageDialog(null, "Book checked in, now available");
                     break;
 
                 } else {
                     JOptionPane.showMessageDialog(null, "Invalid title provided for check-in");
                     System.out.println("Invalid Title provided");
 
                 }
 
             } else if (!book.getBookStatus().equals("Checked Out")) {
                 continue;
 
             }
 
         }
 
     }
 
 
 }