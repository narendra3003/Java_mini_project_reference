package main;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

public class Saving_scene implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static ArrayList<saving> save_values= new ArrayList<saving>();

    @FXML
    private TableView<saving> saving_table;

    @FXML
    private TableColumn<saving, String> save_categ;

    @FXML
    private TableColumn<saving, Integer> save_saving;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        save_categ.setCellValueFactory(new PropertyValueFactory<saving, String>("categ"));
        save_saving.setCellValueFactory(new PropertyValueFactory<saving, Integer>("saving"));
        save_values.add(new saving("Expense", 50000));
        ObservableList<saving> save_list;
        try {
            giveSave();
            System.out.println("out of func");
            save_list = FXCollections.observableArrayList(save_values);
            System.out.println("Runned budget");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | IOException e) {
            System.out.println("error occured ="+e);
            save_list = FXCollections.observableArrayList(
                new saving("Expense", 50000),
                new saving("income", 2000)
            );
        }
        saving_table.setItems(save_list);
    }

    private void giveSave() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException{
        save_values.clear();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exp_tracker", "root", "oracle");
		
        PreparedStatement p = con.prepareStatement("select * from savings;");
        ResultSet rs = p.executeQuery();
        System.out.println("printing now");
        while(rs.next()){
			String categ = rs.getString("saving_id");
            int saving = rs.getInt("amount");
            System.out.println(saving+"\t\t"+categ);
            save_values.add(new saving(categ, saving));
            System.out.println("obj added");
        }
		con.close();
    }

    @FXML
    public void switchToTransaction(ActionEvent event) throws IOException{        // to switch the scene to transaction
        root = FXMLLoader.load(getClass().getResource("finalTransaction.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToBL(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("finalBorrow&Lend.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToBudget(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("finalBudget.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToSave(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("finalSavings.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToAddSave(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("finalAddSaving.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
