import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {

    private static final String DATABASE_NAME = "my_database";
    private static final String USERNAME = "my_username";
    private static final String PASSWORD = "my_password";

    public static void createDatabase() throws Exception {
        // Connect to the MySQL server
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", USERNAME, PASSWORD);

        // Create a statement
        Statement statement = connection.createStatement();

        // Create the database
        statement.execute("CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME);

        // Close the connection
        connection.close();
    }

    public static void main(String[] args) throws Exception {
        // Create the database
        createDatabase();
    }
}
