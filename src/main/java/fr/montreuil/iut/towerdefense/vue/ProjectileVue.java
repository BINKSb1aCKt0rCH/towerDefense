package fr.montreuil.iut.towerdefense.vue;

import fr.montreuil.iut.towerdefense.modele.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
//import javafx.scene.node;

public class ProjectileVue {

    private Pane panneauJeu;
    private Projectile projectiles;

    public ProjectileVue(Pane panneauJeu){ this.panneauJeu=panneauJeu; }

    public void créerSprite(Projectile projectiles) {

        Circle cercle = new Circle(10);
        //cercle .setId(projectiles.getId());
        cercle.translateXProperty().bind(projectiles.getxProperty());
        cercle.translateYProperty().bind(projectiles.getyProperty());

        Label l = new Label();
        l.translateXProperty().bind(projectiles.getxProperty());
        l.translateYProperty().bind(projectiles.getyProperty());

        l.setBackground(Background.fill(Color.CORNFLOWERBLUE));
    }

}
