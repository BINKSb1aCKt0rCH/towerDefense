package fr.montreuil.iut.towerdefense.vue;

import fr.montreuil.iut.towerdefense.modele.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TourVue {
    private Pane panneauDeJeu;
    public TourVue (Pane pane){
        this.panneauDeJeu = pane;
    }

    public void creerSpriteTourImage (Tour tour) throws FileNotFoundException {

        if (tour instanceof TourElectro) {
            Image image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/tourElectro.jpg"));
            ImageView imageView = new ImageView(image);
            imageView.translateXProperty().bind(tour.getXProperty());
            imageView.translateYProperty().bind(tour.getYProperty());
            imageView.setId(tour.getId());
            panneauDeJeu.getChildren().add(imageView);
        }
        else if (tour instanceof TourCryo) {
            Image image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/tourGlace.png"));
            ImageView imageView = new ImageView(image);
            imageView.translateXProperty().bind(tour.getXProperty());
            imageView.translateYProperty().bind(tour.getYProperty());
            imageView.setId(tour.getId());
            panneauDeJeu.getChildren().add(imageView);
        }
        else if (tour instanceof TourPyro) {
            Image image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/tourFeu.jpg"));
            ImageView imageView = new ImageView(image);
            imageView.translateXProperty().bind(tour.getXProperty());
            imageView.translateYProperty().bind(tour.getYProperty());
            imageView.setId(tour.getId());
            panneauDeJeu.getChildren().add(imageView);
        }
        else {
            Image image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/tourTerre.png"));
            ImageView imageView = new ImageView(image);
            imageView.translateXProperty().bind(tour.getXProperty());
            imageView.translateYProperty().bind(tour.getYProperty());
            imageView.setId(tour.getId());
            panneauDeJeu.getChildren().add(imageView);
        }
    }

//    public void creerSpriteTourRectangle (Tour tour){
//
//        if (tour instanceof TourElectro) {
//            Rectangle r = new Rectangle();
//            r.translateXProperty().bind(tour.XProperty());
//            r.translateYProperty().bind(tour.YProperty());
//            r.setWidth(5);
//            r.setHeight(10);
//            r.setFill(Color.VIOLET);
//            panneauDeJeu.getChildren().add(r);
//        }
//        else if (tour instanceof TourPyro) {
//            Rectangle r = new Rectangle();
//            r.translateXProperty().bind(tour.XProperty());
//            r.translateYProperty().bind(tour.YProperty());
//            r.setWidth(5);
//            r.setHeight(10);
//            r.setFill(Color.DARKORANGE);
//            panneauDeJeu.getChildren().add(r);
//        }
//        else if (tour instanceof TourCryo) {
//            Rectangle r = new Rectangle();
//            r.translateXProperty().bind(tour.XProperty());
//            r.translateYProperty().bind(tour.YProperty());
//            r.setWidth(5);
//            r.setHeight(10);
//            r.setFill(Color.WHITE);
//            panneauDeJeu.getChildren().add(r);
//        }
//        else {
//            Rectangle r = new Rectangle();
//            r.translateXProperty().bind(tour.XProperty());
//            r.translateYProperty().bind(tour.YProperty());
//            r.setWidth(5);
//            r.setHeight(10);
//            r.setFill(Color.BROWN);
//            panneauDeJeu.getChildren().add(r);
//        }
//    }

    public void supSpriteTour (Tour tour){
        panneauDeJeu.getChildren().remove(panneauDeJeu.lookup("#"+tour.getId())) ;
    }
}
