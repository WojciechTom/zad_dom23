import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scan = new Scanner(System.in);
        BookDAO bookDao = new BookDAO();
        Printer printer = new Printer();

        System.out.println("PROSZĘ WYBRAĆ JEDNA Z OPCJI:");
        System.out.println("OP1  <- POKAŻ WSZYSTKIE KSIĄŻKI:");
        System.out.println("OP2  <- DODAJ:");
        System.out.println("OP3  <- WYSZUKAJ");
        System.out.println("OP4  <- USUŃ");
        System.out.println("OP5  <- WYJDŹ");



        Opcje op = null;

        while(!( op = Opcje.valueOf(scan.nextLine().toUpperCase())).equals(Opcje.OP5)){

            switch (op){
                case OP1:
                    ArrayList<Book> lista = bookDao.showAll();
                    printer.print(lista);
                    break;

                case OP2:
                    System.out.println("Proszę Podać dane książki w formacie: tytuł/autor/rok/isbn ");
                    String line = scan.nextLine();
                    String[] wiersz = line.split("/");

                    Book ksiaka = new Book(wiersz[0], wiersz[1], Integer.parseInt(wiersz[2]), Integer.parseInt(wiersz[3]));
                    bookDao.save(ksiaka);
                    break;

                case OP3:
                    System.out.println("Proszę podać kryterium wyszkiwania:" + "\n1. Tytuł" + "\n2. Autor");
                    String znacznik = scan.nextLine();
                    System.out.println("Proszę podać wyszukiwany tekst");
                    String tekst = scan.nextLine();
                    ArrayList<Book> list = bookDao.findBook(znacznik, tekst);
                    printer.print(list);
                    break;

                case OP4:
                    System.out.println("Prosze podać id książki do usunięcia:");
                    int numer = scan.nextInt();
                    System.out.println("Liczba rekordów usuniętych z bazy: " + bookDao.del(numer));
                    scan.nextLine();
                    break;

                default:
                    System.out.println("-------------");
                    System.out.println("ZŁY WYBÓR");
                    System.out.println("-------------");

            }

            System.out.println("\nPROSZĘ WYBRAĆ JEDNA Z OPCJI:");
            System.out.println("OP1  <- POKAŻ WSZYSTKIE KSIĄŻKI:");
            System.out.println("OP2  <- DODAJ:");
            System.out.println("OP3  <- WYSZUKAJ");
            System.out.println("OP4  <- USUŃ");
            System.out.println("OP5  <- WYJDŹ");



        }

//        String opcja = null;
//        while(!(opcja = scan.nextLine()).equals("5")){
//            if (opcja.equals("1")){
//                ArrayList<Book> lista = bookDao.showAll();
//                printer.print(lista);
//
//            } else if(opcja.equals("2")){
//                System.out.println("Proszę Podać dane książki w formacie: tytuł/autor/rok/isbn ");
//                String line = scan.nextLine();
//                String[] wiersz = line.split("/");
//
//                Book ksiaka = new Book(wiersz[0], wiersz[1], Integer.parseInt(wiersz[2]), Integer.parseInt(wiersz[3]));
//                bookDao.save(ksiaka);
//
//            } else if (opcja.equals("3")){
//                System.out.println("Proszę podać kryterium wyszkiwania:" + "\n1. Tytuł" + "\n2. Autor");
//                String znacznik = scan.nextLine();
//                System.out.println("Proszę podać wyszukiwany tekst");
//                String tekst = scan.nextLine();
//                ArrayList<Book> lista = bookDao.findBook(znacznik, tekst);
//                printer.print(lista);
//
//            } else if (opcja.equals("4")){
//                System.out.println("Prosze podać id książki do usunięcia:");
//                int numer = scan.nextInt();
//                System.out.println("Liczba rekordów usuniętych z bazy: " + bookDao.del(numer));
//                scan.nextLine();
//            } else {
//
//            }
//
//            System.out.println("\nPROSZĘ WYBRAĆ JEDNA Z OPCJI:");
//            System.out.println("OP1  <- POKAŻ WSZYSTKIE KSIĄŻKI:");
//            System.out.println("OP2  <- DODAJ:");
//            System.out.println("OP3  <- WYSZUKAJ");
//            System.out.println("OP4  <- USUŃ");
//            System.out.println("OP5  <- WYJDŹ");
//
//
//        }
    }
}
