package sample;

import Database.DatabaseConnector;
import com.mysql.jdbc.PreparedStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Button one;

    @FXML
    private Button two;

    @FXML
    private Button four;

    @FXML
    private Button seven;

    @FXML
    private Button zero;

    @FXML
    private Button five;

    @FXML
    private Button eight;

    @FXML
    private Button three;

    @FXML
    private Button six;

    @FXML
    private Button nine;

    @FXML
    private Button done;

    @FXML
    private TextArea textareaUI;
    static TextArea staticTextArea;

    @FXML
    private TextField cardnumber;

    @FXML
    private TextField password;

    @FXML
    private Button checkBalance;

    @FXML
    private Button depositMoney;

    @FXML
    private Button balanceTransfer;

    @FXML
    private Button withdrawBalance;

    @FXML
    private Button changepassword;

    @FXML
    private Button information;

    @FXML
    private Label label1;

    @FXML
    private Label checkbalanceshow;

    @FXML
    private Button backbutton;

    @FXML
    private Label label2;

    @FXML
    private TextField Withdrawamount;

    @FXML
    private TextField depositamount;

    @FXML
    private Label oldpasswordlabel3;

    @FXML
    private Label newpasswordlabel4;

    @FXML
    private Label retypepasswordlabel5;

    @FXML
    private TextField oldpasswordfield;

    @FXML
    private TextField newpasswordfield;

    @FXML
    private TextField retypepasswordfield;

    @FXML
    private TextField accountnumberfield;

    @FXML
    private TextField transfermoneyfield;

    @FXML
    private TextField tranferpasswordfield;

    @FXML
    private Label accountnumberlabel6;

    @FXML
    private Label transferamountlabel7;

    @FXML
    private Label transferpasswordlabel8;

    @FXML
    private Button changepasssubmitbutton1;

    @FXML
    private Button depositsubmitnutton2;

    @FXML
    private Label lastamountlabel9;

    @FXML
    private TextField lastamountshowfield;

    @FXML
    private Button withdrawsubmit;

    @FXML
    private Button transferbutton;

    @FXML
    private Label informationlabel1;

    @FXML
    private Label informationlabel2;

    @FXML
    private Label informationlabel3;

    @FXML
    public Button PrintButton;


    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement pst = null;
    Statement statement = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checkBalance.setVisible(false);
        depositMoney.setVisible(false);
        balanceTransfer.setVisible(false);
        withdrawBalance.setVisible(false);
        changepassword.setVisible(false);
        information.setVisible(false);
        password.setVisible(false);
        label1.setVisible(false);
        backbutton.setVisible(false);
        checkbalanceshow.setVisible(false);
        label2.setVisible(false);
        Withdrawamount.setVisible(false);
        depositamount.setVisible(false);
        oldpasswordlabel3.setVisible(false);
        newpasswordlabel4.setVisible(false);
        retypepasswordlabel5.setVisible(false);
        oldpasswordfield.setVisible(false);
        newpasswordfield.setVisible(false);
        retypepasswordfield.setVisible(false);
        accountnumberfield.setVisible(false);
        transfermoneyfield.setVisible(false);
        tranferpasswordfield.setVisible(false);
        accountnumberlabel6.setVisible(false);
        transferamountlabel7.setVisible(false);
        transferpasswordlabel8.setVisible(false);
        changepasssubmitbutton1.setVisible(false);
        lastamountlabel9.setVisible(false);
        depositsubmitnutton2.setVisible(false);
        lastamountshowfield.setVisible(false);
        withdrawsubmit.setVisible(false);
        transferbutton.setVisible(false);
        informationlabel1.setVisible(false);
        informationlabel2.setVisible(false);
        informationlabel3.setVisible(false);
        done.setVisible(true);
        PrintButton.setVisible(false);

        textareaUI.setVisible(false);
        textareaUI.setMouseTransparent(true);
        textareaUI.setFocusTraversable(false);
        staticTextArea = textareaUI;



    }

    @FXML
    void enterbutton(ActionEvent event) throws SQLException {
        connection = DatabaseConnector.getConnection();
        String sql = "SELECT * FROM `customer` WHERE cardnumber = ? and password = ?";
        try {
            pst = (PreparedStatement) connection.prepareStatement(sql);
            pst.setString(1, cardnumber.getText());
            pst.setString(2, password.getText());

            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                textareaUI.clear();
                System.out.println("                       AHT Bank Ltd.");
                System.out.println("********************************");
                System.out.println("Welcome to the AHT Bank Ltd.");
                System.out.println("********************************\n");
                System.out.println("Cardnumber : " + cardnumber.getText() +".\n");
                System.out.println("Thank You For Using Our Atm.");
                System.out.println("********************************\n");
                System.out.println("If You Need Any Kind Of Information");
                System.out.println("Please Call : +8615977208627.");
                System.out.println("********************************\n");


                password.setVisible(false);
                checkBalance.setVisible(true);
                depositMoney.setVisible(true);
                balanceTransfer.setVisible(true);
                withdrawBalance.setVisible(true);
                changepassword.setVisible(true);
                information.setVisible(true);
                password.setVisible(false);
                label2.setVisible(false);
                Withdrawamount.setVisible(false);
                depositamount.setVisible(false);
                backbutton.setVisible(false);
                oldpasswordlabel3.setVisible(false);
                newpasswordlabel4.setVisible(false);
                retypepasswordlabel5.setVisible(false);
                oldpasswordfield.setVisible(false);
                newpasswordfield.setVisible(false);
                retypepasswordfield.setVisible(false);
                accountnumberfield.setVisible(false);
                transfermoneyfield.setVisible(false);
                tranferpasswordfield.setVisible(false);
                accountnumberlabel6.setVisible(false);
                transferamountlabel7.setVisible(false);
                transferpasswordlabel8.setVisible(false);
                changepasssubmitbutton1.setVisible(false);
                lastamountlabel9.setVisible(false);
                depositsubmitnutton2.setVisible(false);
                lastamountshowfield.setVisible(false);
                withdrawsubmit.setVisible(false);
                transferbutton.setVisible(false);
                informationlabel1.setVisible(false);
                informationlabel2.setVisible(false);
                informationlabel3.setVisible(false);
                done.setVisible(false);
                PrintButton.setVisible(false);
                textareaUI.setVisible(true);

            } else {

                textareaUI.clear();
                System.out.println("                       AHT Bank Ltd.");
                System.out.println("********************************");
                System.out.println("Welcome to the AHT Bank Ltd.");
                System.out.println("********************************\n");
                System.out.println("cardnumber or password is not correct");
                System.out.println("Please Try Again\n");
                System.out.println("Thank You For Using Our Atm.");
                System.out.println("********************************\n");
                System.out.println("If You Need Any Kind Of Information");
                System.out.println("Please Call : +8615977208627.");
                System.out.println("********************************\n");
                password.setVisible(true);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);


        }


    }

    @FXML
    void backbutton(ActionEvent event) {
        textareaUI.clear();
        System.out.println("                       AHT Bank Ltd.");
        System.out.println("********************************");
        System.out.println("Welcome to the AHT Bank Ltd.");
        System.out.println("********************************\n");
        System.out.println("Thank You For Using Our Atm.");
        System.out.println("********************************\n");
        System.out.println("If You Need Any Kind Of Information");
        System.out.println("Please Call : +8615977208627.");
        System.out.println("********************************\n");

        label1.setVisible(false);
        checkbalanceshow.setVisible(false);
        backbutton.setVisible(false);
        checkBalance.setVisible(true);
        depositMoney.setVisible(true);
        balanceTransfer.setVisible(true);
        withdrawBalance.setVisible(true);
        changepassword.setVisible(true);
        information.setVisible(true);
        password.setVisible(true);
        password.setVisible(false);
        label2.setVisible(false);
        Withdrawamount.setVisible(false);
        depositamount.setVisible(false);
        oldpasswordlabel3.setVisible(false);
        newpasswordlabel4.setVisible(false);
        retypepasswordlabel5.setVisible(false);
        oldpasswordfield.setVisible(false);
        newpasswordfield.setVisible(false);
        retypepasswordfield.setVisible(false);
        accountnumberfield.setVisible(false);
        transfermoneyfield.setVisible(false);
        tranferpasswordfield.setVisible(false);
        accountnumberlabel6.setVisible(false);
        transferamountlabel7.setVisible(false);
        transferpasswordlabel8.setVisible(false);
        changepasssubmitbutton1.setVisible(false);
        lastamountlabel9.setVisible(false);
        depositsubmitnutton2.setVisible(false);
        lastamountshowfield.setVisible(false);
        withdrawsubmit.setVisible(false);
        transferbutton.setVisible(false);
        informationlabel1.setVisible(false);
        informationlabel2.setVisible(false);
        informationlabel3.setVisible(false);
        done.setVisible(false);
        PrintButton.setVisible(false);

    }


    @FXML
    void handleButtonAction(ActionEvent event) {

        if (event.getSource() == one) {
            password.setText(password.getText() + "1");
        } else if (event.getSource() == two) {
            password.setText(password.getText() + "2");
        } else if (event.getSource() == three) {
            password.setText(password.getText() + "3");
        } else if (event.getSource() == four) {
            password.setText(password.getText() + "4");
        } else if (event.getSource() == five) {
            password.setText(password.getText() + "5");
        } else if (event.getSource() == six) {
            password.setText(password.getText() + "6");
        } else if (event.getSource() == seven) {
            password.setText(password.getText() + "7");
        } else if (event.getSource() == eight) {
            password.setText(password.getText() + "8");
        } else if (event.getSource() == nine) {
            password.setText(password.getText() + "9");
        } else if (event.getSource() == zero) {
            password.setText(password.getText() + "0");
        }

    }
    @FXML
    void handleButtonAction1(KeyEvent keyEvent) {

        switch (keyEvent.getCode()) {
            case DIGIT1:
                System.out.println("1");
//                controller.handleDigit("1");
                break;
            case DIGIT2:
//                controller.handleDigit("2");
                break;
            case DIGIT3:
//                controller.handleDigit("3");
                break;
            case DIGIT4:
//                controller.handleDigit("4");
                break;
            case DIGIT5:
//                controller.handleDigit("5");
                break;
            case DIGIT6:
//                controller.handleDigit("6");
                break;
            case DIGIT7:
//                controller.handleDigit("7");
                break;
            case DIGIT8:
//                controller.handleDigit("8");
                break;
            case DIGIT9:
//                controller.handleDigit("9");
                break;

        }
    }


    @FXML
    void cardnumberdone(ActionEvent event) {
        password.setVisible(true);

    }

    @FXML
    int cancelbutton(ActionEvent event) throws IOException {
        Stage stage = (Stage) AnchorPane.getScene().getWindow();
        Alert.AlertType type = Alert.AlertType.CONFIRMATION;
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);

        alert.getDialogPane().setContentText("Do you want to cancel?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {

            Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene tableViewScene = new Scene((tableViewParent));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();

        } else if (result.get() == ButtonType.CANCEL) {
            System.out.println("");

        }
        return 0;
    }

    @FXML
    void clearbutton(ActionEvent event) {
        password.clear();
        PrintButton.setVisible(false);
        textareaUI.clear();
        System.out.println("                       AHT Bank Ltd.");
        System.out.println("********************************");
        System.out.println("Welcome to the AHT Bank Ltd.");
        System.out.println("********************************\n");
        System.out.println("Thank You For Using Our Atm.");
        System.out.println("********************************\n");
        System.out.println("If You Need Any Kind Of Information");
        System.out.println("Please Call : +8615977208627.");
        System.out.println("********************************\n");


    }

    @FXML
    void checkBalance(ActionEvent actionEvent) throws SQLException {
        connection = DatabaseConnector.getConnection();
        resultSet = connection.createStatement().executeQuery("SELECT * FROM account WHERE cardnumber ='" + cardnumber.getText() + "'");
        while (resultSet.next())
            try {
                checkbalanceshow.setText(resultSet.getString("lastamount"));
                textareaUI.clear();
                System.out.println("                       AHT Bank Ltd.");
                System.out.println("********************************");
                System.out.println("Welcome to the AHT Bank Ltd.");
                System.out.println("********************************\n");
                System.out.println("Your Card Number is : " + cardnumber.getText() + ".");
                System.out.println("Current Account balance : " + checkbalanceshow.getText() + ".\n");
                System.out.println("Thank You For Using Our Atm.");
                System.out.println("********************************\n");
                System.out.println("If You Need Any Kind Of Information");
                System.out.println("Please Call : +8615977208627.");
                System.out.println("********************************\n");

                checkBalance.setVisible(false);
                depositMoney.setVisible(false);
                balanceTransfer.setVisible(false);
                withdrawBalance.setVisible(false);
                changepassword.setVisible(false);
                information.setVisible(false);
                label1.setVisible(true);
                checkbalanceshow.setVisible(true);
                backbutton.setVisible(true);
                label2.setVisible(false);
                Withdrawamount.setVisible(false);
                depositamount.setVisible(false);
                oldpasswordlabel3.setVisible(false);
                newpasswordlabel4.setVisible(false);
                retypepasswordlabel5.setVisible(false);
                oldpasswordfield.setVisible(false);
                newpasswordfield.setVisible(false);
                retypepasswordfield.setVisible(false);
                accountnumberfield.setVisible(false);
                transfermoneyfield.setVisible(false);
                tranferpasswordfield.setVisible(false);
                accountnumberlabel6.setVisible(false);
                transferamountlabel7.setVisible(false);
                transferpasswordlabel8.setVisible(false);
                changepasssubmitbutton1.setVisible(false);
                lastamountlabel9.setVisible(false);
                depositsubmitnutton2.setVisible(false);
                lastamountshowfield.setVisible(false);
                withdrawsubmit.setVisible(false);
                transferbutton.setVisible(false);
                informationlabel1.setVisible(false);
                informationlabel2.setVisible(false);
                informationlabel3.setVisible(false);
                done.setVisible(false);
                PrintButton.setVisible(true);
            } catch (SQLException e) {

                textareaUI.clear();
                System.out.println("                       AHT Bank Ltd.");
                System.out.println("********************************");
                System.out.println("Welcome to the AHT Bank Ltd.");
                System.out.println("********************************\n");
                System.out.println("Invalid Database Or Number Format\n");
                System.out.println("Thank You For Using Our Atm.");
                System.out.println("********************************\n");
                System.out.println("If You Need Any Kind Of Information");
                System.out.println("Please Call : +8615977208627.");
                System.out.println("********************************\n");

            }


    }

    @FXML
    void depositMoney(ActionEvent actionEvent) throws SQLException {

        connection = DatabaseConnector.getConnection();
        resultSet = connection.createStatement().executeQuery("SELECT * FROM account WHERE cardnumber ='" + cardnumber.getText() + "'");
        while (resultSet.next())
            try {
                lastamountshowfield.setText(resultSet.getString("lastamount"));
                textareaUI.clear();
                System.out.println("                       AHT Bank Ltd.");
                System.out.println("********************************");
                System.out.println("Welcome to the AHT Bank Ltd.");
                System.out.println("********************************\n");
                System.out.println("Thank You For Using Our Atm.");
                System.out.println("********************************\n");
                System.out.println("If You Need Any Kind Of Information");
                System.out.println("Please Call : +8615977208627.");
                System.out.println("********************************\n");


                checkBalance.setVisible(false);
                depositMoney.setVisible(false);
                balanceTransfer.setVisible(false);
                withdrawBalance.setVisible(false);
                changepassword.setVisible(false);
                information.setVisible(false);
                label1.setVisible(false);
                checkbalanceshow.setVisible(false);
                backbutton.setVisible(true);
                label2.setVisible(true);
                Withdrawamount.setVisible(false);
                depositamount.setVisible(true);
                oldpasswordlabel3.setVisible(false);
                newpasswordlabel4.setVisible(false);
                retypepasswordlabel5.setVisible(false);
                oldpasswordfield.setVisible(false);
                newpasswordfield.setVisible(false);
                retypepasswordfield.setVisible(false);
                accountnumberfield.setVisible(false);
                transfermoneyfield.setVisible(false);
                tranferpasswordfield.setVisible(false);
                accountnumberlabel6.setVisible(false);
                transferamountlabel7.setVisible(false);
                transferpasswordlabel8.setVisible(false);
                changepasssubmitbutton1.setVisible(false);
                lastamountlabel9.setVisible(true);
                depositsubmitnutton2.setVisible(true);
                lastamountshowfield.setVisible(true);
                withdrawsubmit.setVisible(false);
                transferbutton.setVisible(false);
                informationlabel1.setVisible(false);
                informationlabel2.setVisible(false);
                informationlabel3.setVisible(false);
                done.setVisible(false);
                PrintButton.setVisible(false);
            } catch (SQLException e) {
                textareaUI.clear();
                System.out.println("                       AHT Bank Ltd.");
                System.out.println("********************************");
                System.out.println("Welcome to the AHT Bank Ltd.");
                System.out.println("********************************\n");
                System.out.println("have some problem\n");
                System.out.println("Thank You For Using Our Atm.");
                System.out.println("********************************\n");
                System.out.println("If You Need Any Kind Of Information");
                System.out.println("Please Call : +8615977208627.");
                System.out.println("********************************\n");

            }
    }

    @FXML
    void depositbuttonsubmit(ActionEvent actionEvent) throws SQLException {

        try {
            if (depositamount.getText().isEmpty() || Integer.parseInt(depositamount.getText()) < 0) {

                textareaUI.clear();
                System.out.println("                       AHT Bank Ltd.");
                System.out.println("********************************");
                System.out.println("Welcome to the AHT Bank Ltd.");
                System.out.println("********************************\n");
                System.out.println("Please Enter A Valid Amount");
                System.out.println("Thank You For Using Our Atm.");
                System.out.println("********************************\n");
                System.out.println("If You Need Any Kind Of Information");
                System.out.println("Please Call : +8615977208627.");
                System.out.println("********************************\n");

            } else {
                connection = DatabaseConnector.getConnection();
                PreparedStatement pst = null;
                resultSet = null;
                pst = (PreparedStatement) connection.prepareStatement("SELECT * FROM account WHERE cardnumber = '" + cardnumber.getText() + "'");
                resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    int NewBalance = (resultSet.getInt("lastamount") + Integer.parseInt(depositamount.getText()));
                    pst = (PreparedStatement) connection.prepareStatement("UPDATE account SET lastamount =? WHERE cardnumber = '" + cardnumber.getText() + "'");
                    pst.setInt(1, NewBalance);
                    pst.executeUpdate();
                    lastamountshowfield.setText(String.valueOf(NewBalance));
                    checkbalanceshow.setText(String.valueOf(NewBalance));
                }
                textareaUI.clear();
                System.out.println("                       AHT Bank Ltd.");
                System.out.println("********************************");
                System.out.println("Welcome to the AHT Bank Ltd.");
                System.out.println("********************************\n");
                System.out.println("Cash Has Been Deposited");
                System.out.println("Your Card Number is : " + cardnumber.getText() + ".");
                System.out.println("Deposit Amount : " + depositamount.getText() + ".");
                System.out.println("Current Account balance : " + checkbalanceshow.getText() + ".\n");
                System.out.println("Thank You For Using Our Atm.");
                System.out.println("********************************\n");
                System.out.println("If You Need Any Kind Of Information");
                System.out.println("Please Call : +8615977208627.");
                System.out.println("********************************\n");
                password.setVisible(false);
                checkBalance.setVisible(true);
                depositMoney.setVisible(true);
                balanceTransfer.setVisible(true);
                withdrawBalance.setVisible(true);
                changepassword.setVisible(true);
                information.setVisible(true);
                password.setVisible(false);
                label2.setVisible(false);
                Withdrawamount.setVisible(false);
                depositamount.setVisible(false);
                backbutton.setVisible(false);
                oldpasswordlabel3.setVisible(false);
                newpasswordlabel4.setVisible(false);
                retypepasswordlabel5.setVisible(false);
                oldpasswordfield.setVisible(false);
                newpasswordfield.setVisible(false);
                retypepasswordfield.setVisible(false);
                accountnumberfield.setVisible(false);
                transfermoneyfield.setVisible(false);
                tranferpasswordfield.setVisible(false);
                accountnumberlabel6.setVisible(false);
                transferamountlabel7.setVisible(false);
                transferpasswordlabel8.setVisible(false);
                changepasssubmitbutton1.setVisible(false);
                lastamountlabel9.setVisible(false);
                depositsubmitnutton2.setVisible(false);
                lastamountshowfield.setVisible(false);
                withdrawsubmit.setVisible(false);
                transferbutton.setVisible(false);
                informationlabel1.setVisible(false);
                informationlabel2.setVisible(false);
                informationlabel3.setVisible(false);
                done.setVisible(false);
                depositamount.clear();
                pst.close();
                resultSet.close();
                connection.close();
                PrintButton.setVisible(true);
                textareaUI.setEditable(false);
            }
        } catch (SQLException e) {

            textareaUI.clear();
            System.out.println("                       AHT Bank Ltd.");
            System.out.println("********************************");
            System.out.println("Welcome to the AHT Bank Ltd.");
            System.out.println("********************************\n");
            System.out.println("Invalid Database Or Number Format\n");
            System.out.println("Thank You For Using Our Atm.");
            System.out.println("********************************\n");
            System.out.println("If You Need Any Kind Of Information");
            System.out.println("Please Call : +8615977208627.");
            System.out.println("********************************\n");

        }
        System.out.println("");
    }

    @FXML
    void withdrawBalance(ActionEvent actionEvent) {

        textareaUI.clear();
        System.out.println("                       AHT Bank Ltd.");
        System.out.println("********************************");
        System.out.println("Welcome to the AHT Bank Ltd.");
        System.out.println("********************************\n");
        System.out.println("Thank You For Using Our Atm");
        System.out.println("********************************\n");
        System.out.println("If You Need Any Information");
        System.out.println("Please Call : +8615977208627.");
        System.out.println("********************************\n");

        checkBalance.setVisible(false);
        depositMoney.setVisible(false);
        balanceTransfer.setVisible(false);
        withdrawBalance.setVisible(false);
        changepassword.setVisible(false);
        information.setVisible(false);
        label2.setVisible(true);
        Withdrawamount.setVisible(true);
        backbutton.setVisible(true);
        depositamount.setVisible(false);
        oldpasswordlabel3.setVisible(false);
        newpasswordlabel4.setVisible(false);
        retypepasswordlabel5.setVisible(false);
        oldpasswordfield.setVisible(false);
        newpasswordfield.setVisible(false);
        retypepasswordfield.setVisible(false);
        accountnumberfield.setVisible(false);
        transfermoneyfield.setVisible(false);
        tranferpasswordfield.setVisible(false);
        accountnumberlabel6.setVisible(false);
        transferamountlabel7.setVisible(false);
        transferpasswordlabel8.setVisible(false);
        changepasssubmitbutton1.setVisible(false);
        lastamountlabel9.setVisible(false);
        depositsubmitnutton2.setVisible(false);
        lastamountshowfield.setVisible(false);
        withdrawsubmit.setVisible(true);
        transferbutton.setVisible(false);
        informationlabel1.setVisible(false);
        informationlabel2.setVisible(false);
        informationlabel3.setVisible(false);
        done.setVisible(false);
        PrintButton.setVisible(false);

    }

    @FXML
    void withdrawsubmitbutton(ActionEvent event) throws SQLException {

        try {
            if (Withdrawamount.getText().isEmpty() || Integer.parseInt(Withdrawamount.getText()) < 0) {
                textareaUI.clear();
                System.out.println("                       AHT Bank Ltd.");
                System.out.println("********************************");
                System.out.println("Welcome to the AHT Bank Ltd.");
                System.out.println("******************************** \n");
                System.out.println("Please Enter A Valid Amount\n");
                System.out.println("Thank You For Using Our Atm.");
                System.out.println("********************************\n");
                System.out.println("If You Need Any Kind Of Information");
                System.out.println("Please Call : +8615977208627.");
                System.out.println("********************************\n");

            } else {
                connection = DatabaseConnector.getConnection();
                PreparedStatement pst = null;
                resultSet = null;
                int balance;
                pst = (PreparedStatement) connection.prepareStatement("SELECT * FROM account WHERE cardnumber = '" + cardnumber.getText() + "'");
                resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    int NewBalance = (resultSet.getInt("lastamount") - Integer.parseInt(Withdrawamount.getText()));
                    if (NewBalance < 0) {
                        textareaUI.clear();
                        System.out.println("                       AHT Bank Ltd.");
                        System.out.println("********************************");
                        System.out.println("Welcome to the AHT Bank Ltd.");
                        System.out.println("******************************** \n");
                        System.out.println("Your Account Balance Is Low\n");
                        System.out.println("Thank You For Using Our Atm.");
                        System.out.println("******************************** \n");
                        System.out.println("If You Need Any Kind Of Information");
                        System.out.println("Please Call : +8615977208627.");
                        System.out.println("********************************\n");
                    } else {
                        pst = (PreparedStatement) connection.prepareStatement("UPDATE account SET lastamount =? WHERE cardnumber = '" + cardnumber.getText() + "'");
                        pst.setInt(1, NewBalance);
                        pst.executeUpdate();
                        lastamountshowfield.setText(String.valueOf(NewBalance));
                        checkbalanceshow.setText(String.valueOf(NewBalance));
                    }
                }
                textareaUI.clear();
                System.out.println("                       AHT Bank Ltd.");
                System.out.println("********************************");
                System.out.println("Welcome to the AHT Bank Ltd.");
                System.out.println("********************************\n");
                System.out.println("Cash Has Been Withdrawn");
                System.out.println("Card Number is : " + cardnumber.getText() + ".");
                System.out.println("Deposit Amount : " + Withdrawamount.getText() + ".");
                System.out.println("Current Account balance is : " + checkbalanceshow.getText() + ".\n");
                System.out.println("Thank You For Using Our Atm.");
                System.out.println("********************************\n");
                System.out.println("If You Need Any Kind Of Information");
                System.out.println("Please Call : +8615977208627.");
                System.out.println("********************************\n");

                password.setVisible(false);
                checkBalance.setVisible(true);
                depositMoney.setVisible(true);
                balanceTransfer.setVisible(true);
                withdrawBalance.setVisible(true);
                changepassword.setVisible(true);
                information.setVisible(true);
                password.setVisible(false);
                label2.setVisible(false);
                Withdrawamount.setVisible(false);
                depositamount.setVisible(false);
                backbutton.setVisible(false);
                oldpasswordlabel3.setVisible(false);
                newpasswordlabel4.setVisible(false);
                retypepasswordlabel5.setVisible(false);
                oldpasswordfield.setVisible(false);
                newpasswordfield.setVisible(false);
                retypepasswordfield.setVisible(false);
                accountnumberfield.setVisible(false);
                transfermoneyfield.setVisible(false);
                tranferpasswordfield.setVisible(false);
                accountnumberlabel6.setVisible(false);
                transferamountlabel7.setVisible(false);
                transferpasswordlabel8.setVisible(false);
                changepasssubmitbutton1.setVisible(false);
                lastamountlabel9.setVisible(false);
                depositsubmitnutton2.setVisible(false);
                lastamountshowfield.setVisible(false);
                withdrawsubmit.setVisible(false);
                transferbutton.setVisible(false);
                done.setVisible(false);
                informationlabel1.setVisible(false);
                informationlabel2.setVisible(false);
                informationlabel3.setVisible(false);
                Withdrawamount.clear();
                pst.close();
                resultSet.close();
                connection.close();
                PrintButton.setVisible(true);

            }
        } catch (SQLException e) {

            textareaUI.clear();
            System.out.println("                       AHT Bank Ltd.");
            System.out.println("********************************");
            System.out.println("Welcome to the AHT Bank Ltd.");
            System.out.println("******************************** \n");
            System.out.println("Your Account Balance Is Low\n");
            System.out.println("Thank You For Using Our Atm.");
            System.out.println("******************************** \n");
            System.out.println("If You Need Any Kind Of Information");
            System.out.println("Please Call : +8615977208627.");
            System.out.println("********************************\n");
        }
        System.out.println("");
    }

    @FXML
    void balanceTransfer(ActionEvent actionEvent) {

        textareaUI.clear();
        System.out.println("                       AHT Bank Ltd.");
        System.out.println("********************************");
        System.out.println("Welcome to the AHT Bank Ltd.");
        System.out.println("******************************** \n");
        System.out.println("Thank You For Using Our Atm.");
        System.out.println("******************************** \n");
        System.out.println("If You Need Any Kind Of Information");
        System.out.println("Please Call : +8615977208627");
        System.out.println("********************************\n");

        checkBalance.setVisible(false);
        depositMoney.setVisible(false);
        balanceTransfer.setVisible(false);
        withdrawBalance.setVisible(false);
        changepassword.setVisible(false);
        information.setVisible(false);
        label2.setVisible(false);
        Withdrawamount.setVisible(false);
        backbutton.setVisible(true);
        depositamount.setVisible(false);
        oldpasswordlabel3.setVisible(false);
        newpasswordlabel4.setVisible(false);
        retypepasswordlabel5.setVisible(false);
        oldpasswordfield.setVisible(false);
        newpasswordfield.setVisible(false);
        retypepasswordfield.setVisible(false);
        accountnumberfield.setVisible(true);
        transfermoneyfield.setVisible(true);
        tranferpasswordfield.setVisible(true);
        accountnumberlabel6.setVisible(true);
        transferamountlabel7.setVisible(true);
        transferpasswordlabel8.setVisible(true);
        changepasssubmitbutton1.setVisible(false);
        lastamountlabel9.setVisible(false);
        depositsubmitnutton2.setVisible(false);
        lastamountshowfield.setVisible(false);
        withdrawsubmit.setVisible(false);
        transferbutton.setVisible(true);
        informationlabel1.setVisible(false);
        informationlabel2.setVisible(false);
        informationlabel3.setVisible(false);
        done.setVisible(false);



    }

    @FXML
    void transfersubmitbutton(ActionEvent event) {
        try {
            if (transfermoneyfield.getText().isEmpty() || Integer.parseInt(transfermoneyfield.getText()) < 0 || tranferpasswordfield.getText().isEmpty() || accountnumberfield.getText().isEmpty()) {

                textareaUI.clear();
                System.out.println("                       AHT Bank Ltd.");
                System.out.println("********************************");
                System.out.println("Welcome to the AHT Bank Ltd.");
                System.out.println("********************************\n");
                System.out.println("Please Fill Up Everything Correctly.\n");
                System.out.println("Thank You For Using Our Atm.");
                System.out.println("********************************\n");
                System.out.println("If You Need Any Kind Of Information");
                System.out.println("Please Call : +8615977208627.");
                System.out.println("********************************\n");
            } else {
                connection = DatabaseConnector.getConnection();
                PreparedStatement pst = (PreparedStatement) connection.prepareStatement("SELECT * FROM account WHERE cardnumber = '" + cardnumber.getText() + "' and password = '" + tranferpasswordfield.getText() + "' ");
                resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    int newbalance = resultSet.getInt("lastamount") - Integer.parseInt(transfermoneyfield.getText());
                    if (newbalance < 0) {


                        textareaUI.clear();
                        System.out.println("                       AHT Bank Ltd.");
                        System.out.println("********************************");
                        System.out.println("Welcome to the AHT Bank Ltd.");
                        System.out.println("********************************\n");
                        System.out.println("You Dont Have Enough Money To Transfer.\n");
                        System.out.println("Thank You For Using Our Atm.");
                        System.out.println("********************************\n");
                        System.out.println("If You Need Any Kind Of Information");
                        System.out.println("Please Call : +8615977208627.");
                        System.out.println("********************************\n");

                        pst.close();
                        resultSet.close();
                    } else {
                        pst = (PreparedStatement) connection.prepareStatement("UPDATE account SET lastamount = ? WHERE cardnumber = '" + cardnumber.getText() + "' ");
                        pst.setInt(1, newbalance);
                        lastamountshowfield.setText(String.valueOf(newbalance));
                        checkbalanceshow.setText(String.valueOf(newbalance));
                        pst.executeUpdate();
                        pst.close();
                        resultSet.close();
                        PreparedStatement pst2 = (PreparedStatement) connection.prepareStatement("SELECT * FROM account WHERE cardnumber = '" + cardnumber.getText() + "'");
                        ResultSet resultSet2 = pst2.executeQuery();
                        if (resultSet2.next()) {
                            int receivernewbalance = resultSet2.getInt("lastamount") + Integer.parseInt(transfermoneyfield.getText());
                            pst2 = (PreparedStatement) connection.prepareStatement("UPDATE account SET lastamount =? WHERE cardnumber = '" + accountnumberfield.getText() + "' ");
                            pst2.setInt(1, receivernewbalance);
                            pst2.executeUpdate();


                            textareaUI.clear();
                            System.out.println("                       AHT Bank Ltd.");
                            System.out.println("********************************");
                            System.out.println("Welcome to the AHT Bank Ltd.");
                            System.out.println("********************************\n");
                            System.out.println("Successfully Transferred.");
                            System.out.println("Your Card Number is : " + cardnumber.getText() + ".");
                            System.out.println("Transfer Card Number is : " + accountnumberfield.getText() + ".");
                            System.out.println("Transfer Amount : " + transfermoneyfield.getText() + ".");
                            System.out.println("Your Current Account balance is : " + checkbalanceshow.getText() + ".\n");
                            System.out.println("Thank You For Using Our Atm.");
                            System.out.println("********************************");
                            System.out.println("If You Need Any Kind Of Information");
                            System.out.println("Please Call : +8615977208627.");
                            System.out.println("********************************\n");

                            password.setVisible(false);
                            checkBalance.setVisible(true);
                            depositMoney.setVisible(true);
                            balanceTransfer.setVisible(true);
                            withdrawBalance.setVisible(true);
                            changepassword.setVisible(true);
                            information.setVisible(true);
                            password.setVisible(false);
                            label2.setVisible(false);
                            Withdrawamount.setVisible(false);
                            depositamount.setVisible(false);
                            backbutton.setVisible(false);
                            oldpasswordlabel3.setVisible(false);
                            newpasswordlabel4.setVisible(false);
                            retypepasswordlabel5.setVisible(false);
                            oldpasswordfield.setVisible(false);
                            newpasswordfield.setVisible(false);
                            retypepasswordfield.setVisible(false);
                            accountnumberfield.setVisible(false);
                            transfermoneyfield.setVisible(false);
                            tranferpasswordfield.setVisible(false);
                            accountnumberlabel6.setVisible(false);
                            transferamountlabel7.setVisible(false);
                            transferpasswordlabel8.setVisible(false);
                            changepasssubmitbutton1.setVisible(false);
                            lastamountlabel9.setVisible(false);
                            depositsubmitnutton2.setVisible(false);
                            lastamountshowfield.setVisible(false);
                            withdrawsubmit.setVisible(false);
                            transferbutton.setVisible(false);
                            informationlabel1.setVisible(false);
                            informationlabel2.setVisible(false);
                            informationlabel3.setVisible(false);
                            done.setVisible(false);
                            accountnumberfield.clear();
                            transfermoneyfield.clear();
                            tranferpasswordfield.clear();
                            PrintButton.setVisible(true);

                            pst2.close();
                            resultSet2.close();
                        } else {
                            textareaUI.clear();
                            System.out.println("                       AHT Bank Ltd.");
                            System.out.println("********************************");
                            System.out.println("Welcome to the AHT Bank Ltd.");
                            System.out.println("******************************** \n");
                            System.out.println("Card Number Invalid , Failed To Transfer.\n");
                            System.out.println("Thank You For Using Our Atm.");
                            System.out.println("******************************** \n");
                            System.out.println("If You Need Any Kind Of Information");
                            System.out.println("Please Call : +8615977208627.");
                            System.out.println("********************************\n");

                            PreparedStatement pst3 = (PreparedStatement) connection.prepareStatement("SELECT * FROM account WHERE cardnumber ='" + cardnumber.getText() + "'");
                            ResultSet resultSet3 = pst3.executeQuery();
                            while (resultSet3.next()) {
                                int addbalance = resultSet3.getInt("lastamount") + Integer.parseInt(transfermoneyfield.getText());
                                pst3 = (PreparedStatement) connection.prepareStatement("UPDATE account SET lastamount = ? WHERE cardnumber = '" + cardnumber.getText() + "'");
                                pst3.setInt(1, addbalance);
                                pst3.executeUpdate();
                            }
                            pst3.close();
                            resultSet3.close();
                        }
                    }
                } else {
                    textareaUI.clear();
                    System.out.println("                       AHT Bank Ltd.");
                    System.out.println("********************************");
                    System.out.println("Welcome to the AHT Bank Ltd.");
                    System.out.println("******************************** \n");
                    System.out.println("Wrong Password Transaction Failed.\n");
                    System.out.println("Thank You For Using Our Atm.");
                    System.out.println("******************************** \n");
                    System.out.println("If You Need Any Kind Of Information");
                    System.out.println("Please Call : +8615977208627.");
                    System.out.println("********************************\n");
                }
                connection.close();
            }
        } catch (SQLException e) {
            textareaUI.clear();
            System.out.println("                       AHT Bank Ltd.");
            System.out.println("********************************");
            System.out.println("Welcome to the AHT Bank Ltd.");
            System.out.println("******************************** \n");
            System.out.println("Invalid Database Or Number Format\n");
            System.out.println("Thank You For Using Our Atm.");
            System.out.println("******************************** \n");
            System.out.println("If You Need Any Kind Of Information");
            System.out.println("Please Call : +8615977208627.");
            System.out.println("********************************\n");
        }
    }

    @FXML
    void changepassword(ActionEvent actionEvent) {
        textareaUI.clear();
        System.out.println("                       AHT Bank Ltd.");
        System.out.println("********************************");
        System.out.println("Welcome to the AHT Bank Ltd.");
        System.out.println("******************************** \n");
        System.out.println("Thank You For Using Our Atm.");
        System.out.println("******************************** \n");
        System.out.println("If You Need Any Kind Of Information");
        System.out.println("Please Call : +8615977208627.");
        System.out.println("********************************\n");

        checkBalance.setVisible(false);
        depositMoney.setVisible(false);
        balanceTransfer.setVisible(false);
        withdrawBalance.setVisible(false);
        changepassword.setVisible(false);
        information.setVisible(false);
        backbutton.setVisible(true);
        depositamount.setVisible(false);
        oldpasswordlabel3.setVisible(true);
        newpasswordlabel4.setVisible(true);
        retypepasswordlabel5.setVisible(true);
        oldpasswordfield.setVisible(true);
        newpasswordfield.setVisible(true);
        retypepasswordfield.setVisible(true);
        accountnumberfield.setVisible(false);
        transfermoneyfield.setVisible(false);
        tranferpasswordfield.setVisible(false);
        accountnumberlabel6.setVisible(false);
        transferamountlabel7.setVisible(false);
        transferpasswordlabel8.setVisible(false);
        changepasssubmitbutton1.setVisible(true);
        lastamountlabel9.setVisible(false);
        depositsubmitnutton2.setVisible(false);
        lastamountshowfield.setVisible(false);
        withdrawsubmit.setVisible(false);
        transferbutton.setVisible(false);
        informationlabel1.setVisible(false);
        informationlabel2.setVisible(false);
        informationlabel3.setVisible(false);
        done.setVisible(false);
        PrintButton.setVisible(false);

    }

    @FXML
    void changepassSubmitbutton(ActionEvent actionEvent) {

        connection = DatabaseConnector.getConnection();
        String sql = "UPDATE customer SET password = '"+retypepasswordfield.getText()+"' WHERE cardnumber = '"+cardnumber.getText()+"'";
        String sql2 = "UPDATE account SET password = '"+retypepasswordfield.getText()+"' WHERE cardnumber = '"+cardnumber.getText()+"'";

        try {
            if (oldpasswordfield.getText().isEmpty() || newpasswordfield.getText().isEmpty() || retypepasswordfield.getText().isEmpty()) {
                textareaUI.clear();
                System.out.println("                       AHT Bank Ltd.");
                System.out.println("********************************");
                System.out.println("Welcome to the AHT Bank Ltd.");
                System.out.println("******************************** \n");
                System.out.println("Please fill your password correctly\n");
                System.out.println("Thank You For Using Our Atm.");
                System.out.println("******************************** \n");
                System.out.println("If You Need Any Kind Of Information");
                System.out.println("Please Call : +8615977208627.");
                System.out.println("********************************\n");
            } else {
                pst = (PreparedStatement) connection.prepareStatement(sql);
                PreparedStatement pst2 = (PreparedStatement) connection.prepareStatement(sql2);

                int numRowsChanged = pst.executeUpdate();
                int numRowsChanged2 = pst2.executeUpdate();

                if (resultSet.next() || oldpasswordfield.getText().equals(password.getText()) || newpasswordfield.getText().equals(retypepasswordfield.getText())) {
                    System.out.println(" ");
                }
                textareaUI.clear();
                System.out.println("                       AHT Bank Ltd.");
                System.out.println("********************************");
                System.out.println("Welcome to the AHT Bank Ltd.");
                System.out.println("******************************** \n");
                System.out.println("Card Number : " + cardnumber.getText());
                System.out.println("Password Has Been Changed. \n");
                System.out.println("Thank You For Using Our Atm.");
                System.out.println("******************************** \n");
                System.out.println("If You Need Any Kind Of Information");
                System.out.println("Please Call : +8615977208627.");
                System.out.println("********************************\n");



                checkBalance.setVisible(true);
                depositMoney.setVisible(true);
                balanceTransfer.setVisible(true);
                withdrawBalance.setVisible(true);
                changepassword.setVisible(true);
                information.setVisible(true);
                oldpasswordlabel3.setVisible(false);
                newpasswordlabel4.setVisible(false);
                retypepasswordlabel5.setVisible(false);
                oldpasswordfield.setVisible(false);
                newpasswordfield.setVisible(false);
                retypepasswordfield.setVisible(false);
                changepasssubmitbutton1.setVisible(false);
                backbutton.setVisible(false);
                lastamountlabel9.setVisible(false);
                depositsubmitnutton2.setVisible(false);
                lastamountshowfield.setVisible(false);
                withdrawsubmit.setVisible(false);
                transferbutton.setVisible(false);
                informationlabel1.setVisible(false);
                informationlabel2.setVisible(false);
                informationlabel3.setVisible(false);
                oldpasswordfield.clear();
                newpasswordfield.clear();
                retypepasswordfield.clear();
                done.setVisible(false);
                PrintButton.setVisible(false);

            }
        } catch (SQLException e) {
            textareaUI.clear();
            System.out.println("                       AHT Bank Ltd.");
            System.out.println("********************************");
            System.out.println("Welcome to the AHT Bank Ltd.");
            System.out.println("******************************** \n");
            System.out.println("Please fill your password correctly\n");
            System.out.println("Thank You For Using Our Atm.");
            System.out.println("******************************** \n");
            System.out.println("If You Need Any Kind Of Information");
            System.out.println("Please Call : +8615977208627.");
            System.out.println("********************************\n");
        }
        System.out.println("");
    }

    @FXML
    void information(ActionEvent actionEvent) {
        checkBalance.setVisible(false);
        depositMoney.setVisible(false);
        balanceTransfer.setVisible(false);
        withdrawBalance.setVisible(false);
        changepassword.setVisible(false);
        information.setVisible(false);
        backbutton.setVisible(true);
        depositamount.setVisible(false);
        oldpasswordlabel3.setVisible(false);
        newpasswordlabel4.setVisible(false);
        retypepasswordlabel5.setVisible(false);
        oldpasswordfield.setVisible(false);
        newpasswordfield.setVisible(false);
        retypepasswordfield.setVisible(false);
        accountnumberfield.setVisible(false);
        transfermoneyfield.setVisible(false);
        tranferpasswordfield.setVisible(false);
        accountnumberlabel6.setVisible(false);
        transferamountlabel7.setVisible(false);
        transferpasswordlabel8.setVisible(false);
        changepasssubmitbutton1.setVisible(false);
        lastamountlabel9.setVisible(false);
        depositsubmitnutton2.setVisible(false);
        lastamountshowfield.setVisible(false);
        withdrawsubmit.setVisible(false);
        transferbutton.setVisible(false);
        informationlabel1.setVisible(true);
        informationlabel2.setVisible(true);
        informationlabel3.setVisible(true);
        done.setVisible(false);
        PrintButton.setVisible(false);

        textareaUI.clear();
        System.out.println("                       AHT Bank Ltd.");
        System.out.println("********************************");
        System.out.println("Welcome to the AHT Bank Ltd.");
        System.out.println("******************************** \n");
        System.out.println("Thank You For Using Our Atm.");
        System.out.println("******************************** \n");
        System.out.println("If You Need Any Kind Of Information");
        System.out.println("Please Call : +8615977208627.");
        System.out.println("********************************\n");
    }

    @FXML
    void PrintButtonHandler(ActionEvent event) {
        PrintButton.setOnAction(e -> print(textareaUI));
    }

    private void print(Node node) {
//        System.out.println("Creating a printer job...");


        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            System.out.println(job.jobStatusProperty().asString());

            boolean printed = job.printPage(textareaUI);
            if (printed) {
                job.endJob();
            } else {
                System.out.println("Printing failed.");
            }
        } else {
            System.out.println("Could not create a printer job.");
        }
    }
}
