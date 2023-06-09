package fr.montreuil.iut.towerdefense.modele.lestours;


import fr.montreuil.iut.towerdefense.modele.MapModele;
import fr.montreuil.iut.towerdefense.modele.Partie;
import fr.montreuil.iut.towerdefense.modele.Projectile;
import fr.montreuil.iut.towerdefense.modele.lesmonstres.Monstre;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public abstract class Tour {

    private String element;
    private int perimetre;
    private int degat;
    private DoubleProperty x, y ;
    private MapModele mapModele;
    private String id;
    private Partie partie;
    private static int compteur =0;
    public Tour(String element, int perimetre, double x, double y,int degat, MapModele mapModele,Partie partie){
        this.element = element;
        this.perimetre = perimetre;
        this.x= new SimpleDoubleProperty(x);
        this.y= new SimpleDoubleProperty(y);
        this.mapModele = mapModele;
        this.degat=degat;
        compteur++;
        this.id = "T"+compteur;
        this.partie = partie;
    }

    public String getId (){
        return this.id;
    }

    public DoubleProperty getXProperty (){
        return this.x;
    }

    public DoubleProperty getYProperty (){
        return this.y;
    }



    public int getDegat(){
        return this.degat;
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

    public boolean detectionEnnemi (Monstre monstre){
        //(RacineCarré((PosXTour - posXEnnemis)^2 + (PosYTtour - posYEnnemis)^2 ) <= périmètre )
        if (Math.sqrt(Math.pow(getXProperty().getValue() - monstre.getXProperty().getValue(),2) + (Math.pow(getYProperty().getValue() - monstre.getYProperty().getValue(),2))) <= this.perimetre){
            this.partie.getProjectiles().add(new Projectile(10, 2, "BLUE",monstre,this.x.getValue(),this.y.getValue(),this.partie));
            System.out.println("Ennemis détecter !!");
        }
        return true;
    }

    /*
    public void creerProjectile(){

        for(int i=0; i < monstres.size(); i++){
            boolean ennemiTrouve = false;
            if(Math.sqrt(Math.pow(getXProperty().getValue() - monstres.get(i).getXProperty().getValue(),2) + (Math.pow(getYProperty().getValue() - monstres.get(i).getYProperty().getValue(),2))) <= 65){
                System.out.println("Ennemi trouvé ");
                this.Partie.projectiles.add(new Projectile(100, 2, "BLUE"));
                ennemiTrouve = true;
            } if(ennemiTrouve){
                break;
            }
        }
    }

     */


    public String toString (){
        return "La tour de " + this.element + " avec un périmètre de " + this.perimetre;
    }


}

