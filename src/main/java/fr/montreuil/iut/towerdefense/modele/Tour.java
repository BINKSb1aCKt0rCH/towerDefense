package fr.montreuil.iut.towerdefense.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Tour {

    private int cout;
    private String element;
    private DoubleProperty x, y ;
    private MapModele mapModele;
    private String id;

    private static int compteur =0;
    public Tour(int cout, String couleur, double x, double y, MapModele mapModele){
        this.cout=cout;
        this.element = couleur;
        this.x= new SimpleDoubleProperty(x);
        this.y= new SimpleDoubleProperty(y);
        this.mapModele = mapModele;
        compteur++;
        this.id = "T"+compteur;
    }

    public String getId (){
        return this.id;
    }

    public DoubleProperty XProperty (){
        return this.x;
    }

    public DoubleProperty YProperty (){
        return this.y;
    }

    public void emplacement(int x, int y){
        if (peutEtrePositionné()==true){
            this.x.setValue(x);
            this.y.setValue(y);
        }
    }
    public boolean peutEtrePositionné(){
        for (int i = 0; i < mapModele.getTuileMap().length; i++) {
            if (mapModele.getTuileMap().equals(2)){
                return true;
            }
        }
        return false;
    }

    public int getCout (){
        return this.cout;
    }

    public String toString (){
        return "La tour de " + this.element + " coûte " + this.cout + " berrys ";
    }


}
