package fr.montreuil.iut.towerdefense.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

import java.lang.annotation.Target;
import java.util.ArrayList;

public class Projectile {

    private int degats;
    private int vitesseAtk;
    private String couleur;
    private IntegerProperty xProperty, yProperty;
    private ArrayList<Projectile> projectiles;
    private ArrayList<Projectile> monstres;
    private String id;
    private boolean aAttaque;
    private Monstre monstreCible;

    public Projectile(int degats, int vitesseAtk, String couleur){

        this.degats=degats;
        this.vitesseAtk=vitesseAtk;
        this.couleur=couleur;
        this.xProperty= new SimpleIntegerProperty();
        this.yProperty= new SimpleIntegerProperty();
        this.projectiles= new ArrayList<>();
        this.monstres= new ArrayList<>();
        this.aAttaque = false;
    }

    public final int getxValue(){ return this.xProperty.getValue();}
    public final int getyValue(){ return this.yProperty.getValue();}

    public void setX(int x){
        xProperty.setValue(x);
    }

    public void setY(int y){
        yProperty.setValue(y);
    }
    public IntegerProperty xProperty(){
        return this.xProperty;
    }
    public IntegerProperty yProperty(){
        return this.yProperty;
    }
    public boolean getaAttaque(){ return this.aAttaque; }
    public int getVitesseAtk(){ return this.vitesseAtk; }
    public String getId() { return this.id; }
    public void collision(Monstre m){
        // si position du projectile - position de l'ennemi < pixel
        if (getxValue() - m.getPositionX() < 3 && getyValue() - m.getPositionY() <3) {

            m.decrementerPv(degats); // diminuer le nombre de pv de l'ennemi en lui infligeant des dégâts
            aAttaque=true;
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
