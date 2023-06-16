package fr.montreuil.iut.towerdefense.controller;

import fr.montreuil.iut.towerdefense.modele.*;
import fr.montreuil.iut.towerdefense.modele.lesmonstres.Monstre;
import fr.montreuil.iut.towerdefense.modele.lestours.Tour;
import fr.montreuil.iut.towerdefense.vue.MapVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
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
    @FXML
    private BorderPane borderPane;
    private Tour tour;
    private boolean autorisationPlacement = false;
    @FXML
    private Label nbmonstresTues;
    @FXML
    private Label tempsSurvie1;
    @FXML
    private Button pyroBouton;
    @FXML
    private Button electroBouton;
    @FXML
    private Button geoBouton;
    @FXML
    private Button cryoBouton;
    private int choixTour = 0;
    @FXML
    private Label vies;
    @FXML
    private Label score;

    @Override
    public void initialize(URL url, ResourceBundle ressourceBundle){
        tuile = new TilePane();
        tuile.setPrefRows(10);
        tuile.setPrefColumns(15);
        panneauDeJeu.getChildren().add(tuile);
        this.partie = new Partie();
        this.mapModele = partie.getMapModele();//recuperation de la mapModele
        this.mapVue = new MapVue();//création de la mapvue
        //affiche la map composée de tuiles
        try {
            mapVue.afficherMap2D(mapModele,tuile);//affichage de la mapVue(le pane)
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //initialisation de la methode initAnimation

        this.partie.getMonstres().addListener(new ObservateurMonstre(this.panneauDeJeu,this.nbmonstresTues));//ajout d'un Listener pour les Monstres
        this.partie.getListeTours().addListener(new ObservateurTour(this.panneauDeJeu));

        this.berrys.textProperty().bind(partie.berrysProperty().asString()); //bind des Berrys du modele dans la vue
        this.tempsSurvie.textProperty().bind(partie.tempsSurvie().asString());//bind du temps du modele dans la vue
        //this.nbmonstresTues.textProperty().addListener(new ObservateurMonstre(th));
        this.score.textProperty().bind(partie.scoreProperty().asString());//bind du score du modele dans la vue
        this.vies.textProperty().bind(partie.viesProperty().asString());//bind des vi
        //this.partie.getListeTours().addListener(listenerTours);

    }
    @FXML
    void commencerPartie(ActionEvent event){
        gameLoop.play();
    }


    @FXML
    public void cliquerTour() {
        //débloque la possibilité de poser des tour (peut etre debloquer si cliquer au bonne endroit et assez d'argent pour débloquer)
        this.autorisationPlacement = true;

        //choix pour savoir quel boutton à été selectionner pour dans Partie pouvoir ajouter la bonne tour dans la liste
        if (this.geoBouton.isArmed())
            this.choixTour = 1;
        else if (this.cryoBouton.isArmed())
            this.choixTour = 2;
        else if (this.pyroBouton.isArmed())
            this.choixTour = 3;
        else
            this.choixTour = 4;
    }

    @FXML
    public void placerTour (MouseEvent eventSouris){

        //obtient les coordonnée de la souris
        double x = eventSouris.getX();
        double y = eventSouris.getY();

        //vérifie qu'on est bien dans le panneau de jeu
        if (x >= 0 && x <= panneauDeJeu.getWidth() && y >= 0 && y <= panneauDeJeu.getHeight()){

            //vérif que c'est bien un emplacement de tour & qu'il à cliquer sur la tour choisi (cf.fxml)
            if (partie.getMapModele().getTile((int)(y/32), (int)((x/32))) == 2 && autorisationPlacement){

                //positionne l'image au centre
                int positionX =((int)x/32) * 32;
                int positionY =((int)y/32) * 32;
                this.partie.ajouterTourDansListe(positionX, positionY, mapModele, this.choixTour);
                autorisationPlacement = false;
            }
        }
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
}