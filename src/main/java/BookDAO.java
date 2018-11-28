import java.sql.*;

public class BookDAO {

    private final String URL = "jdbc:mysql://localhost:3306/library?serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASSWORD = "admin";
    private Connection connection;

    public BookDAO() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


    public ResultSet showAll() throws SQLException {
        final String insert = "Select * from books";
        PreparedStatement statement = connection.prepareStatement(insert);
        return statement.executeQuery();
    }


    public ResultSet findBook(String znacznik, String wyraz) throws SQLException {
        String find = null;

        if ("1".equals(znacznik)) {
            find = "select * from books where title like ?  " ;
        } else if ("2".equals(znacznik)){
            find = "select * from books where author like ?  " ;
        } else {
            System.out.println("Żle wpisane kryterium wyszukiwania");
        }
        final String find1 = find;
        PreparedStatement statement = connection.prepareStatement(find1);
        statement.setString(1, "%" + wyraz + "%");
        System.out.println(statement.toString());
        return statement.executeQuery();
    }


    public void save(Book book) throws SQLException {
        final String insert = "insert into books(title, author, year, isbn) values(?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insert);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setDouble(3, book.getYear());
        statement.setDouble(4, book.getIsbn());
        statement.executeUpdate();
    }


    public int del(int numer) throws SQLException {
        final String insert = "delete from books where id = ?";
        PreparedStatement statement = connection.prepareStatement(insert);
        statement.setInt(1, numer);
        return statement.executeUpdate();
    }


}
