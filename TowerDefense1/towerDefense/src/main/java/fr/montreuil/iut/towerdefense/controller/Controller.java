package fr.montreuil.iut.towerdefense.controller;

import fr.montreuil.iut.towerdefense.modele.MapModele;
import fr.montreuil.iut.towerdefense.modele.Monstre;
import fr.montreuil.iut.towerdefense.modele.Partie;
import fr.montreuil.iut.towerdefense.modele.Slime;
import fr.montreuil.iut.towerdefense.vue.MapVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    @Override
    public void initialize(URL url, ResourceBundle ressourceBundle){
        tuile = new TilePane();
        tuile.setPrefRows(5);
        tuile.setPrefColumns(9);
        panneauDeJeu.getChildren().add(tuile);
        this.mapModele = new MapModele();
        this.mapVue = new MapVue();

        try {
            mapVue.afficherMap2D(mapModele,tuile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.partie = new Partie(500,500);
        initAnimation();
        this.monstre = new Monstre(350,5,"Slime");

    }
    @FXML
    void commencerPartie(ActionEvent event) throws InterruptedException {
        gameLoop.play();
        commencerPartie.setText("Pause");
        /*if(commencerPartie.getText().equals("Pause") ){
            System.out.println("Click sur Pause");
            gameLoop.pause();
            commencerPartie.setText("Reprendre");
        } else if (commencerPartie.getText().equals("Reprendre")) {
            gameLoop.wait();
        }*/
    }
    //
    void creerSprite(Monstre m){
        Circle c = new Circle(5);
        c.setFill(Color.BLUEVIOLET);
        c.translateXProperty().bind(m.PositionXProperty());
        c.translateYProperty().bind(m.PositionYProperty());
        panneauDeJeu.getChildren().add(c);
    }

    void ajouter(Monstre m){
            partie.ajouter(m);
            creerSprite(m);
    }

    void unTour(){
        partie.unTour();
    }

    private void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);
            Monstre m = new Slime();
            creerSprite(m);
            ajouter(m);

        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.1),
                // on définit ce qui se passe à chaque frame 
                // c'est un eventHandler d'ou le lambda
                (ev ->{
                    if(temps==100){
                        System.out.println("fini");
                       // gameLoop.stop();
                    }
                    else if (temps%5==0){
                        System.out.println("un tour");
                        m.bouge();
                    }
                    temps++;
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }
}