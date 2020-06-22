package sample.Customer;

import Database.DatabaseConnector;
import com.mysql.jdbc.PreparedStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CustomerController implements Initializable {

    @FXML
    private TextField customerid;

    @FXML
    private TextField firstname;

    @FXML
    private TextField middlename;

    @FXML
    private TextField lastname;

    @FXML
    private TextField phonenumber;

    @FXML
    private TextField occupation;

    @FXML
    private TextField cardnumber;

    @FXML
    private TextField password;

    @FXML
    private TextArea address;

    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement pst = null;

    @FXML
    void clear(ActionEvent event) {
        customerid.clear();
        firstname.clear();
        middlename.clear();
        lastname.clear();
        phonenumber.clear();
        occupation.clear();
        cardnumber.clear();
        password.clear();
        address.clear();
    }

    @FXML
    void insert(ActionEvent event) throws SQLException {
//        Database.DatabaseConnector databaseConnector = new Database.DatabaseConnector();
//        Connection connection = databaseConnector.getConnection();
        connection = DatabaseConnector.getConnection();
        String sql = "INSERT INTO customer (custid,firstname,middlename,lastname,address,phonenumber,occupation,cardnumber,password) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            pst = (PreparedStatement) connection.prepareStatement(sql);
            pst.setString(1, customerid.getText());
            pst.setString(2, firstname.getText());
            pst.setString(3, middlename.getText());
            pst.setString(4, lastname.getText());
            pst.setString(5, address.getText());
            pst.setString(6, phonenumber.getText());
            pst.setString(7, occupation.getText());
            pst.setString(8, cardnumber.getText());
            pst.setString(9, password.getText());

            pst.execute();
            System.out.println("data insert done");
        } catch (Exception e) {
            System.out.println("error");
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
