package fr.montreuil.iut.towerdefense.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Monstre {
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
        this.partie = new Partie();
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
    public IntegerProperty getXProperty(){
        return this.positionXProperty;
    }
    public IntegerProperty getYProperty(){
        return this.positionYProperty;
    }
    public boolean estMort(){
        return this.pv <= 0;
    }

    public void bouge(){
            setX(getPositionX() +3);
            setY(getPositionY()+ 3);
    }

}
