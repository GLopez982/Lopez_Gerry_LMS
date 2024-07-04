import org.junit.jupiter.api.DisplayName;
import java.nio.file.Path;


import static org.junit.jupiter.api.Assertions.*;

class BookCollectionTest {
    BookCollection bookCollection = new BookCollection();
    Path file = Path.of("D:\\JAVA\\LMS\\LMS\\src\\Porky.txt");

    @org.junit.jupiter.api.Test
    @DisplayName("Add Book Method")
    void addBookToCollection() {
       bookCollection.addBookToCollection(file);
       bookCollection.displayBooks();
       assertNotNull(bookCollection, "Book Collection is Null");



    }

    @org.junit.jupiter.api.Test
    @DisplayName("Removing Book By ISBN testing")
    void removeBooksFromCollection() {
        bookCollection.addBookToCollection(file);
        bookCollection.removeBooksFromCollection("4812782112081");//INCORRECT ISBN TO REMOVE BOOK BY ISBN
        bookCollection.displayBooks();
        System.out.println("\n");
        bookCollection.removeBooksFromCollection("481-2-782112-08-1");//CORRECT ISBN TO REMOVE BOOK BY ISBN
        bookCollection.displayBooks();
        assertNotNull(bookCollection, "Book Collection is NULL");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Removing Book by Title testing")
    void removeBookByTitle() {
        bookCollection.addBookToCollection(file);
        bookCollection.removeBookByTitle("teh rilest");//INCORRECT TITLE TO REMOVE FROM COLLECTION
        bookCollection.displayBooks();
        System.out.println("\n");
        bookCollection.removeBookByTitle("the realist");//CORRECT TITLE TO REMOVE FROM COLLECTION
        bookCollection.displayBooks();
        assertNotNull(bookCollection, "Book Collection is Null");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Check-Out Book Method Testing")
    void checkOutBook() {
         bookCollection.addBookToCollection(file);
         bookCollection.checkOutBook(" a");//INVALID TITLE TEST FOR CHECKOUT
         bookCollection.displayBooks();
         System.out.println("\n");
         bookCollection.checkOutBook("the realist");//VALID CHECKOUT TITLE FOR TESTING. CHECKOUT DATE CHANGED.
         bookCollection.displayBooks();



    }

    @org.junit.jupiter.api.Test
    @DisplayName("Check-In Book Method Testing")
    void checkInBook() {
        bookCollection.addBookToCollection(file);
        bookCollection.checkOutBook("the realist");
        bookCollection.checkInBook(" ");//BLANK SPACE INPUT AS TITLE TO CHECK IN
        bookCollection.displayBooks();
        System.out.println("\n");
        bookCollection.checkInBook("THE REALIST");//CORRECT TITLE INPUT FOR CHECK IN. BOOK STATUS CHANGED TO CHECKED IN AND DATES CHANGED TO NULL
        bookCollection.displayBooks();

    }
}