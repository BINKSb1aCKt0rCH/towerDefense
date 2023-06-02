package fr.montreuil.iut.towerdefense.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Monstre {
    private int pv;
    private int vitesse;
    private String nom;
    private IntegerProperty positionXProperty;
    private IntegerProperty positionYProperty;
    public Partie partie;
    private MapModele mapModele;
    public Monstre(int pv, int v,String nom){
        this.pv = pv;
        this.vitesse = v;
        this.nom =nom;
        this.positionXProperty = new SimpleIntegerProperty(1);
        this.positionYProperty = new SimpleIntegerProperty(1);
        this.partie = new Partie(500,500);
        this.mapModele = new MapModele();
    }
    public int getPositionX(){return this.positionXProperty.getValue();}
    public int getPositionY(){return this.positionYProperty.getValue();}
    public void setX(int x){
        positionXProperty.setValue(x);
    }
    public void setY(int y){
        positionYProperty.setValue(y);
    }
    public IntegerProperty PositionXProperty(){
        return this.positionXProperty;
    }
    public IntegerProperty PositionYProperty(){
        return this.positionYProperty;
    }
    public boolean estMort(Monstre m){
        return pv <0;
    }

    public void bouge(){
            setX(getPositionX() +5);
            setY(getPositionY()+ 5);
    }

}
