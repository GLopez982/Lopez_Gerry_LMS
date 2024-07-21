/**
 * This is the main class of the LMS (Library Management System) and is intended to allow the user to select from a menu
 * whether they want to add, remove, or display books in the collection. The main method will continue to run until
 * the user selects the option to quit.
 *
 * <p> Course: CEN-3024C </p>
 * @author Gerry Lopez
 */

 import java.nio.file.Path;
 import java.nio.file.Paths;
 import java.util.*;
 
 public class LMS {
 
     public static void main(String[] args) {
 
         Scanner keyboard = new Scanner(System.in);
         char userChoice;
         Path file;
         boolean isrunning = true;
         BookCollection collection = new BookCollection();
 
         while (isrunning) {
 
             System.out.println(
                     "Please select a menu choice: 'A' to add books, 'R' to remove books, 'D' to display books, 'O' to Check out a book, 'I' to check in a book and 'Q' to quit");
             String userChoices = keyboard.nextLine();
             while(userChoices.isEmpty()){
                 System.out.println(
                         "Please select a menu choice: 'A' to add books, 'R' to remove books, 'D' to display books, 'O' to Check out a book, 'I' to check in a book and 'Q' to quit");
                 userChoices = keyboard.nextLine();
             }
             userChoice = userChoices.charAt(0);
             userChoice = Character.toUpperCase(userChoice);
 
 
             switch (userChoice) {
                 case 'A':
                     System.out.println(
                             "Please provide a file path for the text file. WARNING **File must be in .txt format and lines formatted correctly**");
                     String path = keyboard.nextLine();
                     file = Paths.get(path);
                     collection.addBookToCollection(file);
                     break;
 
                 case 'R':
                     char userRemoveChoice = ' ';
                     System.out.println("Enter 'I' to remove book by ISBN number,'T' to remove by title or 'E to exit");
                     userRemoveChoice = keyboard.nextLine().toUpperCase().charAt(0);
 
                     //NESTED SWITCH TO ALLOW USER TO SELECT WHICH METHOD TO USE FOR BOOK REMOVAL.
                     switch(userRemoveChoice){
                         case 'I':
                             System.out.println("Please provide a book ISBN number to remove the book from the collection. ");
                             String bookID = keyboard.nextLine();
                             collection.removeBooksFromCollection(bookID);
                             break;
 
                         case 'T':
                             System.out.println("Please provide a book title to remove the book from the collection. ");
                             String bookTitle = keyboard.nextLine();
                             collection.removeBookByTitle(bookTitle);
                             break;
 
                         case 'E':
                             break;
 
                         default:
                             System.out.println("invalid choice");
                             break;
 
                     }
                 case 'D':
                     collection.displayBooks();
                     break;
 
                 case 'O':
                     String bookTitle;
                     System.out.println("Please provide the book title for check out");
                     bookTitle = keyboard.nextLine();
                     collection.checkOutBook(bookTitle);
                     collection.displayBooks();
                     break;
 
                 case 'I':
                     String bookCheckInTitle;
                     System.out.println("Please provide the book title for check-in");
                     bookCheckInTitle = keyboard.nextLine();
                     collection.checkInBook(bookCheckInTitle);
                     collection.displayBooks();
                     break;
 
                 case 'Q':
                     System.out.println("Exiting the program. Have a great day.");
                     isrunning = false;
                     break;
 
                 default:
                     System.out.println("Please make a valid choice");
                     break;
 
             }
 
         }
 
         keyboard.close();
 
     }
 }
 