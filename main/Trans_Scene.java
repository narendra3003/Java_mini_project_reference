package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Trans_Scene implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private TableView<Transactions> Trans_table;

    @FXML
    private TableColumn<Transactions, String> Trans_type;

    @FXML
    private TableColumn<Transactions, Integer> Trans_amt;

    @FXML
    private TableColumn<Transactions, String> Trans_categ;

    @FXML
    private TableColumn<Transactions, String> Trans_date;

    ObservableList<Transactions> list = FXCollections.observableArrayList(
        new Transactions("Expense", 2000, "Transportation", "22-08-23"),
        new Transactions("income", 10000, "Job", "1-08-23")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Trans_type.setCellValueFactory(new PropertyValueFactory<Transactions, String>("type"));
        Trans_amt.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("amt"));
        Trans_categ.setCellValueFactory(new PropertyValueFactory<Transactions, String>("categ"));
        Trans_date.setCellValueFactory(new PropertyValueFactory<Transactions, String>("date"));
        Trans_table.setItems(list);
    }
    public void switchToAddTrans(ActionEvent event) throws IOException{        // to switch the scene to add transaction
        root = FXMLLoader.load(getClass().getResource("finalAddTransaction.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToEditTrans(ActionEvent event) throws IOException{        // to switch the scene to edit transaction
        root = FXMLLoader.load(getClass().getResource("finalEditTrans.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
