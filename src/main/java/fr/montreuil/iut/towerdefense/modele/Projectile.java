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
    private int x,y;
    private int maxTraj, traj;
    private double distance;
    //private Tour tour;
    private IntegerProperty xProperty, yProperty;
    private ArrayList<Projectile> projectiles;

    private Target target;

    //Connaitre la position de l'ennemi;

    public Projectile(int degats, int vitesseAtk, int portee, String couleur){

        this.degats=degats;
        this.vitesseAtk=vitesseAtk;
        this.portee=portee;
        this.couleur=couleur;
        this.x=0;
        this.y=0;
        //this.tour=tour;
        //this.distance=0;
        this.xProperty= new SimpleIntegerProperty();
        this.yProperty= new SimpleIntegerProperty();
        //this.partie = new Partie();
        //this.mapModele = new MapModele();
        this.projectiles= new ArrayList<>();
    }

    public int getPositionX(){return this.xProperty.getValue();}
    public int getPositionY(){return this.yProperty.getValue();}
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

    public final int getValue(){

        return this.xProperty.getValue();

    }


    public final IntegerProperty getyProperty() {

        return this.yProperty;
    }





}
