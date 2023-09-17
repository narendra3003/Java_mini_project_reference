package main;
import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class scene_controller extends App{
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToScene1(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("finalDashboard.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene2(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("finaltransaction.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField tfPass;

    @FXML
    void btnClicked(ActionEvent event) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException {
        // Stage mainWindow = (Stage) tfEmail.getScene().getWindow();
        String email = tfEmail.getText();
        String pass = tfPass.getText();
        System.out.println(AlertConnector.checkLogin1(email, pass));
        if(AlertConnector.checkLogin1(email, pass)){
            switchToScene1(event);
            System.out.println("true");
        }
    }
}
