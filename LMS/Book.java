public class Book {

    private String bookID;
    private String bookTitle;
    private String bookAuthor;


    
    


    public Book(String bookID, String bookTitle, String bookAuthor) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;


    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
    public String getBookID() {
        return bookID;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }

    //OVERRIDDEN TOSTRING METHOD FOR DISPLAYING THE BOOK DATA
    @Override
    public String toString(){
        return "ID#" + bookID + ", Book Title: " + bookTitle + ", Book Author: " + bookAuthor;
    }



    

}
