package Koneksi;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection koneksi;
    public static String user = "root", password = "";
    private static final String server = "localhost:3306";

    public static Connection getKoneksi() {
        //cek apakah koneksi null
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://" + server + "/perpustakaan";
                DriverManager.registerDriver(
                        new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {

            }
        }
        return koneksi;
    }

    public static String getServer() {
        return server;
    }

    public static int execute(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}