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
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.READ;

public class BookCollection {
    
    
    private ArrayList<Book> bookCollection;

    
    public BookCollection() {
        this.bookCollection = new ArrayList<>();
        
        
    }

    /*METHOD FOR ADDING BOOK DATA FROM A TEXT FILE TO THE COLLECTION. THE METHOD USES A PATH PARAMATER TO GET THE TEXT FILE LOCATION OF THE DATA
    * THE METHOD WILL COLLECT THE DATA FROM THE TEXT, SPLIT THE COLLECTED DATA INTO THREE STRINGS AND THEN STORE THE STRING DATA IN A BOOK OBJECT.
    * THE BOOK OBJECT WILL THEN BE STORED TO AN ARRAY LIST OF BOOK OBJECTS TO CREATE THE BOOK COLLECTION. 
    */
    public void addBookToCollection(Path file){

       try{
            
           
            InputStream input = new BufferedInputStream(Files.newInputStream(file, READ));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String emptyString = reader.readLine();

            
            while(emptyString != null){
                
               
                String delimit = ",";
                String[] fileStrings = new String[3];
                fileStrings = emptyString.split(delimit);
                
                if(fileStrings.length == 3){
                    Book book = new Book(fileStrings[0], fileStrings[1], fileStrings[2]);
                    bookCollection.add(book);
                    
                   
                    emptyString = reader.readLine();

                }


            }

        }catch(IOException exception){
            System.out.println("Error>>>" + exception.getMessage());

     
        }
   
    }

    
    /* METHOD FOR REMOVING A BOOK FROM THE COLLECTION OF BOOKS. 
     * THE METHOD TAKES A STRING ARGUMENT AND CHECKS TO SEE IF THE PROVIDED ID STRING MATCHES ONE IN THE BOOK COLLECTION.
     * IF THE ID MATCHES, THE BOOK IS REMOVED FROM TEH COLLECTION AND THE METHOD ENDS. */

    public void removeBooksFromCollection(String id){
        Book removedBook = null;

        for(Book book : bookCollection){
            if(book.getBookID().equals(id)){
                removedBook = book;
                break;

            }
        }

            if(removedBook != null){
                bookCollection.remove(removedBook);
            }

        
    }

    /* METHOD FOR DISPLAYING THE BOOKS CONTAINED WITHIN THE COLLECTION. 
     * USES THE OVERRIDDEN TOSTRING CREATED IN THE BOOK OBJECT TO PROVIDE 
     * THE DATA FOR THE BOOKS IN THE COLLECTION. */
    public void displayBooks(){
        for(Book book : bookCollection){
            System.out.println(book);
        }
    }




}
