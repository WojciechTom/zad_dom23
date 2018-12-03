import java.util.ArrayList;

public class Printer {

    public void print (ArrayList<Book> lista){
        System.out.println("id | title | author | year | isbn");
        for(Book ksiazka:lista){
            System.out.println(ksiazka.getId() + " | " + ksiazka.getTitle() + " | " + ksiazka.getAuthor() + " | " + ksiazka.getYear() + " | " + ksiazka.getIsbn());
        }
    }
}
