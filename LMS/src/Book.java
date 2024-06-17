/* GERRY LOPEZ
 * CEN-3024C
 * CLASS FUNCTION: THIS CLASS IS INTENDED TO STORE A BOOK OBJECT CONSISTING OF A THE BOOK ISBN, THE BOOK TITLE AND BOOK AUTHOR. 
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

    // OVERRIDDEN TOSTRING METHOD FOR DISPLAYING THE BOOK DATA
    @Override
    public String toString() {
        return "ISBN NUMBER: " + bookISBN + ", Book Title: " + bookTitle + ", Book Author: " + bookAuthor + ", \nBook Status: " + bookStatus + ", Check-Out Date: " + checkOutDate + ", Return Date: " + returnDate;
    }

}
