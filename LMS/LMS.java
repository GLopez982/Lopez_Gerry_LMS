import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class LMS{
    
    
    

    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        char userChoice;
        Path file;
        boolean isrunning = true; 
        BookCollection collection = new BookCollection();

        while(isrunning){  

            System.out.println("Please select a menu choice: A to add books, R to remove books, D to display books and Q to quit");
            userChoice = keyboard.nextLine().charAt(0);
            userChoice = Character.toUpperCase(userChoice);

            switch(userChoice){
            case 'A':
            System.out.println("Please provide a file path for the text file. WARNING **File must be in .txt format and lines formatted correctly**");
            String path = keyboard.nextLine();
            file = Paths.get(path);
            collection.addBookToCollection(file);
            break;
            
            case 'R':
            System.out.println("Please provide a book id to remove from the collection. ");
            String bookID = keyboard.nextLine();

            collection.removeBooksFromCollection(bookID);
            break;


            case 'D':
            collection.displayBooks();
            break;
            
            case 'Q':
                System.out.println("Exiting the program. Have a great day.");
                isrunning = false;
            
            default:
                System.out.println("Please make a valid choice");
                break;
                

            
        }




        //END OF IS RUNNING LOOP
        }  


        keyboard.close();































    

      
    }
}


// ArrayList<String> collection = new ArrayList<>();
 
    
    

// // try{
// //     int bookID;
// //     String bookTitle;
// //     String bookAuthor;
//     Path file = Paths.get("G:\\FOR_JAVA\\LMS\\LMS\\src\\Porky.txt");
// //     InputStream input = new BufferedInputStream(Files.newInputStream(file, READ));
// //     BufferedReader reader = new BufferedReader(new InputStreamReader(input));
// //     String emptyString = "";
// //     String delimit = ",";
// //     String[] fileStrings = new String[3];
// //     ArrayList<String> bookCollection = new ArrayList<>();
// //     String constructedBook = "";
// //     emptyString = reader.readLine();

//    BookCollection book = new BookCollection(file);
// //    book.addBookToCollection(file);
//     collection.add(book.toString());
//     System.out.println(book.toString());
   
   
   
//     Path file2 = Paths.get("G:\\FOR_JAVA\\LMS\\LMS\\src\\Porky2.txt");
   



//     book.addBookToCollection(file2);
//     System.out.println(book.toString());
//     collection.add(book.toString());
//     for(String string : collection){
//         for(int i = 0; i < string.length(); ++i){
//         string = collection.get(i).toString();
//         }
//     }

    
// //     while(emptyString != null){
// //         fileStrings = emptyString.split(delimit);
// //         bookID = Integer.parseInt(fileStrings[0]);
// //         bookTitle = fileStrings[1];
// //         bookAuthor = fileStrings[2];
// //         System.out.printf("BookID#%d Book Title: %s Book Author: %s \n", bookID, bookTitle,bookAuthor);
// //         constructedBook = bookID + ","+ bookTitle + "," + bookAuthor;
// //         bookCollection.add(constructedBook);
// //         System.out.println(bookCollection.toString());
// //         emptyString = reader.readLine();

        


// //     }




    


 


// // }catch(IOException exception){
// //     System.out.println("Error>>>" + exception.getMessage());


// // }
// // //END OF CODE TO ADD BOOKS TO BOOK ARRAYLIST