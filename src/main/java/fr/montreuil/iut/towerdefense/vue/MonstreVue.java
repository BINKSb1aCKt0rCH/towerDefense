package fr.montreuil.iut.towerdefense.vue;

import fr.montreuil.iut.towerdefense.modele.Monstre;
import fr.montreuil.iut.towerdefense.modele.Slime;
import fr.montreuil.iut.towerdefense.modele.Zodd;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MonstreVue {
    
    private Pane panneauDeJeu;

    public MonstreVue(Pane pane){
        this.panneauDeJeu = pane;
    }
    public void creerSprite(Monstre m) throws FileNotFoundException {
        Image image;
        if(m instanceof Slime){
             image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/slime.png"));
        } else if (m instanceof Zodd) {
             image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/zodd.png"));
        }
        else {
             image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/kaido.jpg"));
        }
        ImageView image1Bis = new ImageView(image);
        image1Bis.translateXProperty().bind(m.positionXProperty());
        image1Bis.translateYProperty().bind(m.positionYProperty());
        panneauDeJeu.getChildren().add(image1Bis);
    }
    public void retirerSprite(Monstre m){
        this.panneauDeJeu.getChildren().remove("#"+ m.getId());
    }
}
