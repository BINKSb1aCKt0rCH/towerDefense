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
    public ProjectileVue(Pane panneauJeu){ this.panneauJeu=panneauJeu; }

    //créer et afficher des projectiles dans le panneau du jeu
    public void créerSprite(Projectile projectiles) {

        Circle cercle = new Circle(10);
        //cercle .setId(projectiles.getId());
        cercle.translateXProperty().bind(projectiles.xProperty());
        cercle.translateYProperty().bind(projectiles.yProperty());

        Label l = new Label();
        l.translateXProperty().bind(projectiles.xProperty());
        l.translateYProperty().bind(projectiles.yProperty());

        l.setBackground(Background.fill(Color.CORNFLOWERBLUE));

        this.panneauJeu.getChildren().add(cercle);
        this.panneauJeu.getChildren().add(l);
    }

}
