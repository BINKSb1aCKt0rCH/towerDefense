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
        Image image;
        if (tour instanceof TourElectro) {
             image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/tourElectro.jpg"));
        }
        else if (tour instanceof TourCryo) {
             image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/tourGlace.png"));
        }
        else if (tour instanceof TourPyro) {
             image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/tourFeu.jpg"));
        }
        else {
             image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/tourTerre.png"));
        }
        ImageView imageView = new ImageView(image);
        imageView.translateXProperty().bind(tour.getXProperty());
        imageView.translateYProperty().bind(tour.getYProperty());
        imageView.setId(tour.getId());
        panneauDeJeu.getChildren().add(imageView);
    }


    public void supSpriteTour (Tour tour){
        panneauDeJeu.getChildren().remove(panneauDeJeu.lookup("#"+tour.getId())) ;
    }
}
