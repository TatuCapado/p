import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.NfcA;

public class NFCSystem {

    private static final String TAG = "NFCSystem";
    private NfcAdapter nfcAdapter;

    public NFCSystem(Context context) {
        nfcAdapter = NfcAdapter.getDefaultAdapter(context);
    }

    public void enable() {
        if (nfcAdapter == null) {
            Log.e(TAG, "NFC adapter is not available.");
            return;
        }

        if (!nfcAdapter.isEnabled()) {
            Log.i(TAG, "NFC adapter is not enabled.");
            nfcAdapter.enable();
        }
    }

    public void disable() {
        if (nfcAdapter == null) {
            Log.e(TAG, "NFC adapter is not available.");
            return;
        }

        if (nfcAdapter.isEnabled()) {
            Log.i(TAG, "NFC adapter is enabled.");
            nfcAdapter.disable();
        }
    }

    public void readTag(Tag tag) {
        if (tag == null) {
            Log.e(TAG, "Tag is null.");
            return;
        }

        NfcA nfcA = NfcA.get(tag);

        if (nfcA == null) {
            Log.e(TAG, "Tag is not an NFC-A tag.");
            return;
        }

        byte[] uid = nfcA.getUid();

        Log.i(TAG, "UID: " + bytesToHex(uid));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    public void readCard(Tag tag) {
        // Read the ID of the card from the NFC tag
        byte[] uid = nfcA.getUid();

        // Connect to the database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "my_username", "my_password");

        // Create a statement
        Statement statement = connection.createStatement();

        // Query the database for the card ID
        ResultSet resultSet = statement.executeQuery("SELECT * FROM cards WHERE card_id = '" + bytesToHex(uid) + "'");

        // If the card ID is found in the database, the card is valid
        if (resultSet.next()) {
            System.out.println("The card ID is valid.");
        } else {
            System.out.println("The card ID is invalid.");
        }

        // Close the connection
        connection.close();
    }
}
