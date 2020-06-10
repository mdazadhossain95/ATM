package sample;

import com.mysql.jdbc.PreparedStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private Label examplelabel;
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
    private Button one;

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
    private Button submitbutton1;

    @FXML
    private Button submitnutton2;

    @FXML
    private TextField lastamountfield;

    @FXML
    private Label lastamountlabel9;


    @FXML
    void backbutton(ActionEvent event) {
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
        submitbutton1.setVisible(false);
        lastamountlabel9.setVisible(false);


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


    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement pst = null;
//    Statement statement = null;

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
        submitbutton1.setVisible(false);
        lastamountlabel9.setVisible(false);

    }

    @FXML
    void cardnumberdone(ActionEvent event) {
        password.setVisible(true);

    }

    @FXML
    void cancelbutton(ActionEvent event) {

    }

    @FXML
    void clearbutton(ActionEvent event) {
        password.clear();

    }


    @FXML
    private void enterbutton(ActionEvent event) throws Exception {
        connection = DatabaseConnector.getConnection();
        String sql = "SELECT * FROM `customer` WHERE cardnumber = ? and password = ?";
        try {
            pst = (PreparedStatement) connection.prepareStatement(sql);
            pst.setString(1, cardnumber.getText());
            pst.setString(2, password.getText());

            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "cardnumber and password is correct");
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
                submitbutton1.setVisible(false);
                lastamountlabel9.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "cardnumber or password is not correct");
                password.setVisible(true);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);


        }


    }

    @FXML
    void checkBalance(ActionEvent actionEvent) {
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
        submitbutton1.setVisible(false);
        lastamountlabel9.setVisible(false);

    }


    @FXML
    void depositMoney(ActionEvent actionEvent) throws SQLException {


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
        submitbutton1.setVisible(false);
        lastamountlabel9.setVisible(true);
//                }
//                else {
//                    JOptionPane.showMessageDialog(null, "have some problem");
//                }
//            } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//
    }

    @FXML
    void balanceTransfer(ActionEvent actionEvent) {
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
        submitbutton1.setVisible(false);
        lastamountlabel9.setVisible(false);


    }

    @FXML
    void withdrawBalance(ActionEvent actionEvent) {
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
        submitbutton1.setVisible(false);
        lastamountlabel9.setVisible(false);

    }

    @FXML
    void changepassword(ActionEvent actionEvent) {
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
        submitbutton1.setVisible(true);
        lastamountlabel9.setVisible(false);

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
        submitbutton1.setVisible(false);
        lastamountlabel9.setVisible(false);

    }

    @FXML
    void Submitbutton1(ActionEvent actionEvent) {

        connection = DatabaseConnector.getConnection();
        String sql = "UPDATE customer SET password = ? WHERE cardnumber = ?";
        try {
            pst = (PreparedStatement) connection.prepareStatement(sql);
            pst.setString(1, retypepasswordfield.getText());
            pst.setString(2, cardnumber.getText());


            int numRowsChanged = pst.executeUpdate();

            if (resultSet.next() || oldpasswordfield.getText().equals(password.getText()) || newpasswordfield.getText().equals(retypepasswordfield.getText())) {
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
                submitbutton1.setVisible(false);
                backbutton.setVisible(false);
                oldpasswordfield.clear();
                newpasswordfield.clear();
                retypepasswordfield.clear();
                lastamountlabel9.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "have some problem");


            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    void depositbuttonsubmit(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        connection = DatabaseConnector.getConnection();
        String sql = "UPDATE account SET amount = ? WHERE cardnumber = ?";
        try {
            pst = (PreparedStatement) connection.prepareStatement(sql);
//            pst.setString(1, lastamountfield.getText());
            pst.setString(1, depositamount.getText());
            pst.setString(2, cardnumber.getText());


            int numRowsChanged = pst.executeUpdate();

//            sql = "SELECT updatebalance FROM account WHERE cardnumber = ?;";
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()){
//                lastamountfield.setText(resultSet.getString(1));
//            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

//        String cardnumber1 = cardnumber.getText();
//
//        try {
//            statement = connection.createStatement();
//            sql = "SELECT updatebalance FROM account WHERE cardnumber = '" + cardnumber1 + "';";
//            statement.executeQuery(sql);
//
//            System.out.println(statement.executeUpdate(sql));
//            lastamountfield.setText(Integer.toString(statement.executeUpdate(sql)));
//

//            while (resultSet.next()) {
//                lastamountfield.setText(resultSet.getString(3));
//                System.out.println("ok");
//
//            }

//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//
//        }

    }

//    @FXML
//    void lastamountactionfield(ActionEvent actionEvent) throws SQLException {
////        connection = DatabaseConnector.getConnection();
////        String sql = "SELECT * FROM account;";
////        resultSet = statement.executeQuery(sql);
////        while (resultSet.next()){
////            lastamountfield.setText(resultSet.getString(3));
////            System.out.println("ok");
////        }
//    }
}
