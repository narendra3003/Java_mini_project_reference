

import java.sql.SQLException;

/*for LoginPage.fxml */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
public class loginPage {

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfPass;

    @FXML
    void btnClicked(ActionEvent event)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{//to throw basic exceptions
        // Stage mainWindow = (Stage) tfEmail.getScene().getWindow();
        String email = tfEmail.getText();
        String pass = tfPass.getText();
        dbcBasic.checkLogin(email, pass);
    }

}


