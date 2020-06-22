module ATM {
    requires javafx.fxml;
    requires java.sql;
    requires javafx.controls;
    requires java.desktop;
    requires mysql.connector.java;

    opens sample.Customer;

    exports sample to  javafx.graphics, javafx.fxml;
    opens sample to  javafx.fxml;

}