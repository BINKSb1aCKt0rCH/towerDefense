package fr.montreuil.iut.towerdefense.controller;

import fr.montreuil.iut.towerdefense.modele.*;
import fr.montreuil.iut.towerdefense.vue.MapVue;
import fr.montreuil.iut.towerdefense.vue.TourVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.FileInputStream;
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
    @FXML
    private BorderPane borderPane;
    private Tour tour;
    private boolean autorisationPlacement = false;
    @FXML
    private Label nbmonstresTues;
    @FXML
    private Label tempsSurvie;
    @FXML
    private Label tempsSurvie1;
    @FXML
    private ImageView tourElectro;
    @FXML
    private ImageView tourFeu;
    @FXML
    private ImageView tourGlace;
    @FXML
    private ImageView tourTerre;

    @Override
    public void initialize(URL url, ResourceBundle ressourceBundle){
        tuile = new TilePane();
        tuile.setPrefRows(10);
        tuile.setPrefColumns(15);
        panneauDeJeu.getChildren().add(tuile);
        this.mapModele = new MapModele();
        this.partie = new Partie(500,500);
        this.mapModele = partie.getMapModele();
        this.mapVue = new MapVue();
        //affiche la map composée de tuiles
        try {
            mapVue.afficherMap2D(mapModele,tuile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        initAnimation();
        this.monstre = new Slime();

        this.partie.getMonstres().addListener(new ObservateurMonstre(this.panneauDeJeu));
        this.partie.getListeTours().addListener(new ObservateurTour(this.panneauDeJeu));

        this.berrys.textProperty().bind(partie.berrysProperty().asString());
        this.tempsSurvie.textProperty().bind(partie.tempsSurvie().asString());

        this.partie.getListeTours().addListener(listenerTours);
        this.partie.getListeTours().addListener(new ObservateurTour(this.panneauDeJeu));

    }
    @FXML
    void commencerPartie(ActionEvent event) throws InterruptedException {
        gameLoop.play();
    }

    //
   /* void creerSprite(Monstre m){
        Circle c = new Circle(5);
        c.setFill(Color.BLUEVIOLET);
        c.translateXProperty().bind(m.PositionXProperty());
        c.translateYProperty().bind(m.PositionYProperty());
        panneauDeJeu.getChildren().add(c);
    }

    void ajouter(Monstre m){
            partie.ajouter(m);
            creerSprite(m);
    }*/


    @FXML
    public void cliquerTour (MouseEvent eventSouris){
        System.out.println("OK apuyer");
        this.autorisationPlacement = true;
    }

    @FXML
    public void placerTour (MouseEvent eventSouris){
        System.out.println("enter2");
        double x = eventSouris.getX();
        double y = eventSouris.getY(); //obtient les coordonnée de la souris
        int choix = (tourElectro.is)
//button.isArmed
        //vérifie qu'on est bien dans le panneau de jeu
        if (x >= panneauDeJeu.getLayoutX() && x <= panneauDeJeu.getLayoutX() + panneauDeJeu.getWidth() && y >= panneauDeJeu.getLayoutY() && y <= panneauDeJeu.getLayoutY() + panneauDeJeu.getHeight()){
            System.out.println("enter");
            //vérif que c'est bien un emplacement de tour & qu'il à cliquer sur la tour choisi (cf.fxml)
            if (partie.getMapModele().getTile((int)((y - panneauDeJeu.getLayoutY())/32), (int)((x - panneauDeJeu.getLayoutX())/32)) == 2 && autorisationPlacement){
                this.partie.ajouterPositionTour(x- panneauDeJeu.getLayoutX(),y- panneauDeJeu.getLayoutY(), mapModele);
                autorisationPlacement = false;
            }
        }
    }


    private void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);
            /*Monstre m = new Slime();
            creerSprite(m);
            ajouter(m);*/

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
}