package fr.montreuil.iut.towerdefense.vue;

import fr.montreuil.iut.towerdefense.modele.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import javafx.scene.node;

public class ProjectileVue {

    private Pane panneauJeu;
    public ProjectileVue(Pane panneauJeu){ this.panneauJeu=panneauJeu; }

    //créer et afficher des projectiles dans le panneau du jeu
    public void créerSprite(Projectile projectiles) throws FileNotFoundException {

        Image projectile = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/bouleDeTerre.gif"));
        ImageView projectileVue = new ImageView(projectile);
        /*
        Circle cercle = new Circle(2);
        cercle.setFill(Color.RED);
        cercle.setId(projectiles.getId());
        cercle.translateXProperty().bind(projectiles.xProperty());
        cercle.translateYProperty().bind(projectiles.yProperty());

         */
        projectileVue.setId(projectiles.getId());
        projectileVue.translateXProperty().bind(projectiles.xProperty());
        projectileVue.translateYProperty().bind(projectiles.yProperty());

        this.panneauJeu.getChildren().add(projectileVue);
        //this.panneauJeu.getChildren().add(l);
    }

}

