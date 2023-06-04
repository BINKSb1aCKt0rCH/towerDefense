package fr.montreuil.iut.towerdefense.controller;

import fr.montreuil.iut.towerdefense.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ContinentController {
    private Parent root;
        @FXML
    void revenirAuLore(ActionEvent event) throws IOException {
            System.out.println("Lore");
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Lore.fxml"));
            root = fxmlLoader.load();
            Main.stg.setScene(new Scene(root));
            Main.stg.show();
        }
}
