import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scan = new Scanner(System.in);
        BookDAO bookDao = new BookDAO();

        System.out.println("PROSZĘ WYBRAĆ JEDNA Z OPCJI:");
        System.out.println("1. POKAŻ WSZYSTKIE KSIĄŻKI:");
        System.out.println("2. DODAJ:");
        System.out.println("3. WYSZUKAJ");
        System.out.println("4. USUŃ");
        System.out.println("5. WYJDŹ");

        String opcja = null;
        while(!(opcja = scan.nextLine()).equals("5")){
            if (opcja.equals("1")){
                ResultSet set = bookDao.showAll();

                System.out.println("id | title | author | year | isbn");
                while(set.next()){
                    System.out.println(set.getInt("id") + " | " + set.getString("title") + " | " + set.getString("author") + " | " + set.getInt("year") + " | " + set.getInt("isbn") );
                }

            } else if(opcja.equals("2")){
                System.out.println("Proszę Podać dane książki w formacie: tytuł/autor/rok/isbn ");
                String line = scan.nextLine();
                String[] wiersz = line.split("/");

                Book ksiaka = new Book(wiersz[0], wiersz[1], Integer.parseInt(wiersz[2]), Integer.parseInt(wiersz[3]));
                bookDao.save(ksiaka);

            } else if (opcja.equals("3")){
                System.out.println("Proszę podać kryterium wyszkiwania:" + "\n1. Tytuł" + "\n2. Autor");
                String znacznik = scan.nextLine();
                System.out.println("Proszę podać wyszukiwany tekst");
                String tekst = scan.nextLine();
                ResultSet set = bookDao.findBook(znacznik, tekst);

                System.out.println("id | title | author | year | isbn");
                while(set.next()){
                    System.out.println(set.getInt("id") + " | " + set.getString("title") + " | " + set.getString("author") + " | " + set.getInt("year") + " | " + set.getInt("isbn") );
                }

            } else if (opcja.equals("4")){
                System.out.println("Prosze podać id książki do usunięcia:");
                int numer = scan.nextInt();
                System.out.println("Liczba rekordów usuniętych z bazy: " + bookDao.del(numer));
                scan.nextLine();
            } else {

            }

            System.out.println("\nPROSZĘ WYBRAĆ JEDNA Z OPCJI:");
            System.out.println("1. POKAŻ WSZYSTKIE KSIĄŻKI:");
            System.out.println("2. DODAJ:");
            System.out.println("3. WYSZUKAJ");
            System.out.println("4. USUŃ");
            System.out.println("5. WYJDŹ");


        }
    }
}
