package fr.montreuil.iut.towerdefense.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

import java.lang.annotation.Target;
import java.util.ArrayList;

public class Projectile {

    private int degats;
    private int vitesseAtk;
    private int portee;
    private String couleur;
    private IntegerProperty xProperty, yProperty;
    private ArrayList<Projectile> projectiles;
    private ArrayList<Projectile> monstres;
    private String id;

    //Connaitre la position de l'ennemi;

    public Projectile(int degats, int vitesseAtk, int portee, String couleur){

        this.degats=degats;
        this.vitesseAtk=vitesseAtk;
        this.portee=portee;
        this.couleur=couleur;
        this.xProperty= new SimpleIntegerProperty();
        this.yProperty= new SimpleIntegerProperty();
        this.projectiles= new ArrayList<>();
        this.monstres= new ArrayList<>();
    }

    public int getPositionX(){ return this.xProperty.getValue(); }
    public int getPositionY(){ return this.yProperty.getValue(); }
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

    public void seDeplace() {
        setX(getPositionX() + 3);
        setY(getPositionY() + 3);
    }

    public final IntegerProperty getxProperty() {

        return this.xProperty;
    }

    public final int getxValue(){ return this.xProperty.getValue();}

    public final int getyValue(){ return this.yProperty.getValue();}
    public final IntegerProperty getyProperty() {

        return this.yProperty;
    }

    public void collision(Monstre m){

        if(getxValue()== m.getPositionX() && getyValue()== m.getPositionY()){
            monstres.remove(m);
            //this.remove();
        }


    }

}
