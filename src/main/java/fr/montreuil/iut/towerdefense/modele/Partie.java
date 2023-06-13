package fr.montreuil.iut.towerdefense.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.LinearGradient;

import java.util.ArrayList;
import javafx.collections.ObservableArray;

public class Partie {
    MapModele mapModele;
    private IntegerProperty berrys;
    public IntegerProperty tempsSurvie;
    private ObservableList<Tour> listeTours;
    private ObservableList<Monstre> monstres;

    public Partie(){
        this.monstres = FXCollections.observableArrayList();
        this.mapModele = new MapModele();
        this.berrys = new SimpleIntegerProperty(75);
        this.tempsSurvie = new SimpleIntegerProperty(0);
        this.listeTours = FXCollections.observableArrayList();

    }
    public void ajouter(Monstre m){
        monstres.add(m);
    }
    public ObservableList<Monstre> getMonstres(){
        return monstres;
    }
    public boolean dansTerrain(int x, int y){return x < 5 && y <9 && x >0 && y>0;}

    public int getBerrys(){return this.berrys.getValue();}
    public void setBerrys(int b){
        berrys.setValue(b);
    }
    public IntegerProperty berrysProperty(){
        return this.berrys;
    }
    public IntegerProperty compteurBerrys(){
        for (int i = 0; i < monstres.size(); i++) {
            if (monstres.get(i).estMort()){
                if (monstres.get(i)instanceof Slime){
                    setBerrys(getBerrys()+5);
                }
                else if (monstres.get(i)instanceof Zodd) {
                    setBerrys(getBerrys()+15);
                }
                else if (monstres.get(i)instanceof Kaido) {
                    setBerrys(getBerrys()+45);
                }
            }
        }
        return berrys;
    }
    public void setTempsSurvie(int x){
        tempsSurvie.setValue(x);
    }
    public IntegerProperty tempsSurvie(){
        return tempsSurvie;
    }
    public int getTempsSurvie(){return tempsSurvie.getValue();}

    //les vagues sont faites en fonction du temps

    /*
    la premiere vague de slime jusqu'à 30s les monstres vont apparaitre toutes les 3s
    jusqu'à 40s les slime vont apparaitre toutes les 2s (légère acceleration du spawn de monstre)
    puis reprise à 45s afin d'acheter une tour geo
    puis les slimes apparaissent toutes les 1.7s jusqu'à 80s
    */
    //36monstres apparaissent pdt vagueMonstres1
    public void vagueMonstres1(int temps){
        //Pdt les 30premières secondes 10slimes vont apparaitre
        if (getTempsSurvie() < 30) {
            if (temps % 30 == 0) {
                Slime s = new Slime();
                ajouter(s);
            }
        }
         else if (getTempsSurvie() < 40) {
                if (temps% 20 == 0){
                    Slime s = new Slime();
                    ajouter(s);
                }
        }
         //pause de 5secondes afin de pouvoir acheter une 2eme tour
        else if (getTempsSurvie() >= 45 &&getTempsSurvie() < 80){
            if (temps%17 == 0){
                Slime s = new Slime();
                ajouter(s);
                System.out.println("2eme partie");
            }
        }
    }
    public void vagueMonstres2(int temps) {

    }
    //méthode permettant la gestion des vagues
    public void vagueMonstres(int temps){
            if (getTempsSurvie() < 80){//<40
                vagueMonstres1(temps);
                System.out.println("vague1");
            }
             else if (getTempsSurvie() < 100) {
                //vagueMonstres2(temps);
            }
    }
    public MapModele getMapModele(){
        return mapModele;
    }
    public void unTour(int temps){
        setTempsSurvie(temps/10);
        vagueMonstres(temps);
        for (int i = 0; i < monstres.size(); i++) {
            Monstre a = monstres.get(i);
            a.bouge();
        }
    }



    public void ajouterTour (Tour t){
        listeTours.add(t);
    }

    public void ajouterPositionTour (int x, int y, MapModele mapModele){
        listeTours.add(new TourElectro(x,y,mapModele));
    }
    public ObservableList<Tour> getListeTours() {
        return listeTours;
    }

}
