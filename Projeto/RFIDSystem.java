import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class RFIDSystem {

    private static final String DATABASE_NAME = "my_database";
    private static final String USERNAME = "my_username";
    private static final String PASSWORD = "my_password";

    public static void main(String[] args) throws Exception {
        // Connect to the MySQL server
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", USERNAME, PASSWORD);

        // Create a statement
        Statement statement = connection.createStatement();

        // Read the card code from the RFID reader
        Scanner scanner = new Scanner(System.in);
        String cardCode = scanner.nextLine();

        // Check the card code in the database
        ResultSet resultSet = statement.executeQuery("SELECT * FROM cards WHERE card_code = '" + cardCode + "'");

        // If the card code is valid, open the turnstile
        if (resultSet.next()) {
            System.out.println("The card code is valid.");
            System.out.println("Opening the turnstile.");
        } else {
            System.out.println("The card code is invalid.");
        }

        // Close the connection
        connection.close();
    }
}
