package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {

    private static Connection connection = null;
//    private static String USERNAME = "root";
//    private static String PASSWORD = "";
//    private static String DRIVER = "com.mysql.jdbc.Driver";
//    private static String URL = "jdbc:mysql://localhost/atm";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/atm", "root", "");
//            JOptionPane.showMessageDialog(null,"Connection Established");
            return connection;
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Connection not Established");

            return null;
        }

    }

}