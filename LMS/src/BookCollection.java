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
    
    //BOOKCOLLECTION ARRAY LIST USED TO COLLECT SUBMITTED BOOKS
    private ArrayList<Book> bookCollection;
    
    


    
    //CONSTRUCTOR FOR THE BOOKCOLLECTION THAT INITIALIZES THE ARRAYLIST 
    public BookCollection() {
        this.bookCollection = new ArrayList<>();
        
        
    }




    //METHOD FOR ADDING BOOK DATA FROM A TEXT FILE TO THE COLLECTION. THE METHOD USES A PATH TO GET THE TEXT FILE LOCATION DATA
    public void addBookToCollection(Path file){

       try{
            
            //INPUT STREAM USED FOR READING THE TEXT FILE AND A BUFFERED READER TO READ THE DATA THROUGH THE STREAM. 
            InputStream input = new BufferedInputStream(Files.newInputStream(file, READ));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            //AN EMPTY STRING ASSIGNED TO READ THE LINES OF THE TEXT FILE
            String emptyString = reader.readLine();

            //IF THE EMPTY STRING IS NOT NULL THE CODE WILL CONTINUE TO READ THE LINE AND GATHER BOOK DATA.            
            while(emptyString != null){
                
                //DELIMITER FOR SPLITTING THE STRING AND A STRING ARRAY FOR COLLECTING THE THREE REQUIRED BOOK DATA VARIABLES.
                String delimit = ",";
                String[] fileStrings = new String[3];
                fileStrings = emptyString.split(delimit);
                //IF LOOP FOR CHECKING IF THE FILESTRING DATA WAS SPLIT INTO 3 ARRAY INDEXES. 
                //IF THE SPLIT EQUALS 3 THE CODE WILL ASSIGN INTIALIZE AND NEW BOOK AND STORE IT IN THE BOOKCOLLECTION ARRAYLIST.
                if(fileStrings.length == 3){
                    Book book = new Book(fileStrings[0], fileStrings[1], fileStrings[2]);
                    bookCollection.add(book);
                    
                    //READS THE NEXT LINE TO SEE IF IT IS NULL OR IF THE LOOP SHOULD PROCEED. 
                    emptyString = reader.readLine();

                }


            }

        }catch(IOException exception){
            System.out.println("Error>>>" + exception.getMessage());

     
        }
       
    }//END OF ADD BOOKS TO COLLECTION METHOD. 


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

    public void displayBooks(){
        for(Book book : bookCollection){
            System.out.println(book);
        }
    }




}
