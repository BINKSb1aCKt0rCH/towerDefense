package fr.montreuil.iut.towerdefense.controller;

import fr.montreuil.iut.towerdefense.modele.*;
import fr.montreuil.iut.towerdefense.vue.MapVue;
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
    private Label tempsSurvie1;
    @FXML
    private Label vies;

    @Override
    public void initialize(URL url, ResourceBundle ressourceBundle){
        tuile = new TilePane();
        tuile.setPrefRows(10);
        tuile.setPrefColumns(15);
        panneauDeJeu.getChildren().add(tuile);
        this.partie = new Partie();
        this.mapModele = partie.getMapModele();
        this.mapVue = new MapVue();
        //affiche la map composée de tuiles
        try {
            mapVue.afficherMap2D(mapModele,tuile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        initAnimation();
        this.partie.getMonstres().addListener(new ObservateurMonstre(this.panneauDeJeu,this.nbmonstresTues));
        this.berrys.textProperty().bind(partie.berrysProperty().asString());
        this.tempsSurvie.textProperty().bind(partie.tempsSurvie().asString());
        //this.nbmonstresTues.textProperty().addListener(new ObservateurMonstre(th));
        this.vies.textProperty().bind(partie.vies);
        ListChangeListener<Tour> listenerTours = new ListChangeListener<Tour>() {
            @Override
            public void onChanged(Change<? extends Tour> change) {
                while (change.next()){
                    for(Tour tour : change.getAddedSubList()){
                        try {
                            creerSpriteTour(tour);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };
        this.partie.getListeTours().addListener(listenerTours);
    }
    @FXML
    void commencerPartie(ActionEvent event){
        gameLoop.play();
    }

    public void creerSpriteTour (Tour tour) throws FileNotFoundException {
//        Rectangle r = new Rectangle();
//        r.translateXProperty().bind(tour.XProperty());
//        r.translateYProperty().bind(tour.YProperty());
//        r.setWidth(5);
//        r.setHeight(10);
//        r.setFill(Color.VIOLET);

        Image image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/foudre.png"));
        ImageView imageView = new ImageView(image);
        imageView.translateXProperty().bind(tour.XProperty());
        imageView.translateYProperty().bind(tour.YProperty());
        imageView.setId(tour.getId());
        panneauDeJeu.getChildren().add(imageView);
    }
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

        //vérifie qu'on est bien dans le panneau de jeu
        if (x >= panneauDeJeu.getLayoutX() && x <= panneauDeJeu.getLayoutX() + panneauDeJeu.getWidth() && y >= panneauDeJeu.getLayoutY() && y <= panneauDeJeu.getLayoutY() + panneauDeJeu.getHeight()){
            System.out.println("enter");
            //vérif que c'est bien un emplacement de tour & qu'il à cliquer sur la tour choisi (cf.fxml)
            if (partie.getMapModele().getTile((int)((y - panneauDeJeu.getLayoutY())/32), (int)((x - panneauDeJeu.getLayoutX())/32)) == 2 && autorisationPlacement){
                this.partie.ajouterPositionTour((int) (x- panneauDeJeu.getLayoutX()), (int) (y- panneauDeJeu.getLayoutY()), mapModele);
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