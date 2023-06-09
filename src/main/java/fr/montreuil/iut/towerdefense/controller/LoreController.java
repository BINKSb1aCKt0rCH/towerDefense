package fr.montreuil.iut.towerdefense.controller;

import fr.montreuil.iut.towerdefense.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoreController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void initialize(URL url, ResourceBundle ressourceBundle) {
    }


    @FXML
    void defendre(ActionEvent event) throws IOException {
        System.out.println("Click sur defendre Arrassia");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Vue.fxml"));
        root = fxmlLoader.load();
        //Controller controller = fxmlLoader.getController();
        Main.stg.setScene(new Scene(root));
        Main.stg.setTitle("Defendre ARRASSIA!");
        Main.stg.show();
    }
    @FXML
    void proprieteTours(ActionEvent event) throws IOException {
        System.out.println("Click sur propriété des Tours");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("proprieteTours.fxml"));
        root = fxmlLoader.load();
        Main.stg.setScene(new Scene(root));
        Main.stg.setTitle("Les Tours!");
        Main.stg.show();
    }
    @FXML
    void imageContinent(ActionEvent event) throws IOException {
        System.out.println("Click sur continent Celestia");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Continent.fxml"));
        root = fxmlLoader.load();
        Main.stg.setTitle("Continent de Celestia!");
        Main.stg.setScene(new Scene(root));
        Main.stg.show();
    }
}
