package fr.montreuil.iut.towerdefense.controller;

import fr.montreuil.iut.towerdefense.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private Button buttonPlay;

    @FXML
    private Button buttonRegleJeu;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void initialize(URL url, ResourceBundle ressourceBundle) {
    }
    @FXML
    void play(ActionEvent event) throws IOException {
        System.out.println("Click sur PLAY");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Lore.fxml"));
        root = fxmlLoader.load();
        Main.stg.setTitle("Lore!");
        Main.stg.setScene(new Scene(root));
        Main.stg.show();
    }

    @FXML
    void règleJeu(ActionEvent event) {
    }
}
