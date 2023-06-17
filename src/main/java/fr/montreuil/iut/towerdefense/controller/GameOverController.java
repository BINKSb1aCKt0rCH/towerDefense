package fr.montreuil.iut.towerdefense.controller;

import fr.montreuil.iut.towerdefense.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class GameOverController {
    Parent root;
    @FXML
    void recommencer(ActionEvent event) throws IOException {
        System.out.println("Click sur defendre Arrassia");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Vue.fxml"));
        root = fxmlLoader.load();
        //Controller controller = fxmlLoader.getController();
        Main.stg.setScene(new Scene(root));
        Main.stg.setTitle("Defendre ARRASSIA!");
        Main.stg.show();
    }
}
