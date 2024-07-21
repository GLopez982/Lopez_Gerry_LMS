/**
 * CLASS FUNCTION: This class is intended to store a Book object consisting of the book ISBN, the book title, and the book author.
 *
 * <p>Course: CEN-3024C</p>
 *
 * @author Gerry Lopez
 */

 import java.time.LocalDateTime;

 public class Book {
 
     private String bookISBN;
     private String bookTitle;
     private String bookAuthor;
     private String bookStatus = "Checked In";
     private LocalDateTime checkOutDate;
     private LocalDateTime returnDate;
 
     public Book(String bookISBN, String bookTitle, String bookAuthor) {
         this.bookISBN = bookISBN;
         this.bookTitle = bookTitle;
         this.bookAuthor = bookAuthor;
     }
 
 
     public void setBookISBN(String bookISBN) {
         this.bookISBN = bookISBN;
     }
 
     public void setBookTitle(String bookTitle) {
         this.bookTitle = bookTitle;
     }
 
     public void setBookAuthor(String bookAuthor) {
         this.bookAuthor = bookAuthor;
     }
 
     public void setBookStatus(String bookStatus){
         this.bookStatus = bookStatus;
     }
 
     public void setCheckOutDate(LocalDateTime checkOutDate) {
         this.checkOutDate = checkOutDate;
     }
 
     public void setReturnDate(LocalDateTime returnDate) {
         this.returnDate = returnDate;
     }
 
     public String getBookISBN() {
         return bookISBN;
     }
 
     public String getBookTitle() {
         return bookTitle;
     }
 
     public String getBookAuthor() {
         return bookAuthor;
     }
 
     public String getBookStatus(){
         return bookStatus;
     }
 
     public LocalDateTime getCheckOutDate() {
         return checkOutDate;
     }
 
     public LocalDateTime getReturnDate() {
         return returnDate;
     }
 
     /**
      * Overrides the toString method to display the book data.
      *
      * @return a string representation of the book's details
      */
     @Override
     public String toString() {
         return "ISBN NUMBER: " + bookISBN + ", Book Title: " + bookTitle + ", Book Author: " + bookAuthor + ", \nBook Status: " + bookStatus + ", Check-Out Date: " + checkOutDate + ", Return Date: " + returnDate;
     }
 
 }
 