package fr.montreuil.iut.towerdefense.vue;

import fr.montreuil.iut.towerdefense.modele.Monstre;
import fr.montreuil.iut.towerdefense.modele.Slime;
import fr.montreuil.iut.towerdefense.modele.Zodd;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
public class MonstreVue {
    
    private Pane panneauDeJeu;

    public MonstreVue(Pane pane){
        this.panneauDeJeu = pane;
    }
    public void creerSprite(Monstre m){
        if(m instanceof Slime){
            Circle c = new Circle(5);
            c.setFill(Color.BLUE);
            c.translateXProperty().bind(m.PositionXProperty());
            c.translateYProperty().bind(m.PositionYProperty());
            panneauDeJeu.getChildren().add(c);
        } else if (m instanceof Zodd) {
            /*Polygon p = new Polygon(5,5,5);
            p.setFill(Color.BLACK);
            p.translateXProperty().bind(m.PositionXProperty());
            p.translateYProperty().bind(m.PositionYProperty());
            panneauDeJeu.getChildren().add(p);*/
            Circle c = new Circle(8);
            c.setFill(Color.BLACK);
            c.translateXProperty().bind(m.PositionXProperty());
            c.translateYProperty().bind(m.PositionYProperty());
            panneauDeJeu.getChildren().add(c);
        }
        else {
           /* Polygon k = new Polygon(5,5,5,5,5);
            k.setFill(Color.GOLD);
            k.translateXProperty().bind(m.PositionXProperty());
            k.translateYProperty().bind(m.PositionYProperty());
            panneauDeJeu.getChildren().add(k);*/
            Circle c = new Circle(10);
            c.setFill(Color.GOLD);
            c.translateXProperty().bind(m.PositionXProperty());
            c.translateYProperty().bind(m.PositionYProperty());
            panneauDeJeu.getChildren().add(c);
        }
    }
    public void retirerSprite(Monstre m){
        this.panneauDeJeu.getChildren().remove(m);
    }
}
