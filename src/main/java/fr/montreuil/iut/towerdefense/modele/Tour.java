package fr.montreuil.iut.towerdefense.modele;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Tour {

    private int cout;
    private String element;
    private int perimetre;
    private DoubleProperty x, y ;
    private MapModele mapModele;
    private Monstre monstre;
    private String id;

    private static int compteur =0;
    public Tour(int cout, String element, int perimetre, double x, double y, MapModele mapModele){
        this.cout=cout;
        this.element = element;
        this.perimetre = perimetre;
        this.x= new SimpleDoubleProperty(x);
        this.y= new SimpleDoubleProperty(y);
        this.mapModele = mapModele;
        compteur++;
        this.id = "T"+compteur;
    }

    public String getId (){
        return this.id;
    }

    public DoubleProperty getXProperty(){
        return this.x;
    }

    public DoubleProperty getYProperty(){
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

    public void detectionEnnemi (){
        //(RacineCarré((PosXTour - posXEnnemis)^2 + (PosYTtour - posYEnnemis)^2 ) <=
        //périmètre )
       // Math.sqrt(Math.pow(getXProperty().getValue() - this.monstre.))
    }

    public String toString (){
        return "La tour de " + this.element + " coûte " + this.cout + " berrys ";
    }


}
