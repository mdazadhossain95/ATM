package sample;

import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.SQLException;

public class Controller {

    public void aVoid(ActionEvent actionEvent) throws SQLException{

        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection();
    }


}
