package fr.montreuil.iut.towerdefense.modele;

import fr.montreuil.iut.towerdefense.modele.lesmonstres.Monstre;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Projectile {

    private int degats;
    private int vitesseAtk;
    private String couleur;
    private DoubleProperty posX, posY;
    private String id;
    private static int compteur = 0;
    private Monstre monstreCible;
    private Partie partie;

    public Projectile(int degats, int vitesseAtk, String couleur,Monstre monstreCible,double posX,double posY,Partie partie){
        compteur++;
        this.id = "" + compteur;
        this.degats=degats;
        this.vitesseAtk=vitesseAtk;
        this.couleur=couleur;
        this.posX = new SimpleDoubleProperty(posX);
        this.posY = new SimpleDoubleProperty(posY);
        this.monstreCible = monstreCible;
        this.partie = partie;
    }


    public final double getxValue(){ return this.posX.getValue();}
    public final double getyValue(){ return this.posY.getValue();}

    public void setX(int x){
        posX.setValue(x);
    }

    public void setY(int y){
        posY.setValue(y);
    }
    public DoubleProperty xProperty(){
        return this.posX;
    }
    public DoubleProperty yProperty(){
        return this.posY;
    }
    public int getVitesseAtk(){ return this.vitesseAtk; }
    public String getId() { return this.id; }
    public void collision(Monstre m){
        // si position du projectile - position de l'ennemi < pixel
        if (getxValue() - m.getPositionX() < 3 && getyValue() - m.getPositionY() <3) {

            m.decrementerPv(degats); // diminuer le nombre de pv de l'ennemi en lui infligeant des dégâts
            System.out.println("Taille liste projectiles : " + this.partie.getProjectiles().size());
            this.partie.getProjectiles().remove(this);
            System.out.println("Taille liste projectiles après enlever : " + this.partie.getProjectiles().size());
        }
    }
    public void seDeplacer(){

        if(this.monstreCible != null) { // si le monstre ciblé est trouvé alors
            //x droite : si position x du projectile en mouvement < position x du monstre alors incrémente position x du projectile en mouvement en additionnant sa vitesse d'attaque.
            if (this.xProperty().getValue() < this.monstreCible.getXProperty().getValue()) {
                this.xProperty().setValue(this.xProperty().getValue() + this.getVitesseAtk());
            } else { // x gauche | décrémente position x du projectile en mouvement en soustrayant sa vitesse d'attaque.
                this.xProperty().setValue(this.xProperty().getValue() - this.vitesseAtk);
            }
            //y droite : incrémente position y du projectile en mouvement en additionnant sa vitesse d'attaque.

            if (this.yProperty().getValue() < this.monstreCible.getYProperty().getValue()) {
                this.yProperty().setValue(this.yProperty().getValue() + this.getVitesseAtk());
            } else { // y gauche : décrémente position y du projectile en mouvement en soustrayant sa vitesse d'attaque.
                this.yProperty().setValue(this.yProperty().getValue() - this.vitesseAtk);
            }
        }


    }
}

