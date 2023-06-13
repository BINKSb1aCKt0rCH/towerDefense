package fr.montreuil.iut.towerdefense.controller;

import fr.montreuil.iut.towerdefense.modele.*;
import fr.montreuil.iut.towerdefense.vue.MapVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Timeline gameLoop;
    private Partie partie;
    private MapModele mapModele;
    private MapVue mapVue;
    @FXML
    private Pane panneauDeJeu;
    private TilePane tuile;
    int temps;
    private Monstre monstre;
    @FXML
    private Button commencerPartie;
    @FXML
    private Label berrys;
    @FXML
    private Label tempsSurvie;

    @Override
    public void initialize(URL url, ResourceBundle ressourceBundle){
        tuile = new TilePane();
        tuile.setPrefRows(10);
        tuile.setPrefColumns(15);
        panneauDeJeu.getChildren().add(tuile);
        this.mapModele = new MapModele();
        this.mapVue = new MapVue();
        //affiche la map composée de tuiles
        try {
            mapVue.afficherMap2D(mapModele,tuile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.partie = new Partie();
        initAnimation();
        this.monstre = new Monstre(350,5,"Slime");
        this.partie.getMonstres().addListener(new ObservateurMonstre(this.panneauDeJeu));
        this.berrys.textProperty().bind(partie.berrysProperty().asString());
        this.tempsSurvie.textProperty().bind(partie.tempsSurvie().asString());
    }
    @FXML
    void commencerPartie(ActionEvent event) {
        gameLoop.play();
    }
    private void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.1),
                // on définit ce qui se passe à chaque frame 
                // c'est un eventHandler d'ou le lambda
                (ev ->{
                    this.partie.unTour(temps);
                    temps++;
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }

    public Projectile conversionProjectile(Tour tour){

        Projectile p = new Projectile();

        /*
        if(){

        }else if(){

        }
        return p;

         */
    }
}