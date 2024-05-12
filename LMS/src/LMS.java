import java.nio.file.*;
import static java.nio.file.StandardOpenOption.READ;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.*;

public class LMS{
    
    
    

    public static void main(String[] args) {
 
    
    

        try{
            int bookID;
            String bookTitle;
            String bookAuthor;
            Path file = Paths.get("G:\\FOR_JAVA\\filePlay\\Porky.txt");
            InputStream input = new BufferedInputStream(Files.newInputStream(file, READ));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String emptyString = "";
            String delimit = ",";
            String[] fileStrings = new String[3];
            emptyString = reader.readLine();

            while(emptyString != null){
                fileStrings = emptyString.split(delimit);
                bookID = Integer.parseInt(fileStrings[0]);
                bookTitle = fileStrings[1];
                bookAuthor = fileStrings[2];
                System.out.printf("BookID#%d Book Title: %s Book Author: %s", bookID, bookTitle,bookAuthor);


            }




            


         


        }catch(IOException exception){
            System.out.println("Error>>>" + exception.getMessage());

        }
    }
}