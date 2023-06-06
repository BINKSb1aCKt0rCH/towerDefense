package fr.montreuil.iut.towerdefense.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Partie {
    MapModele mapModele;
    private int width,height;
    private IntegerProperty berrys;
    public IntegerProperty tempsSurvie;
    private ObservableList<Monstre> monstres;
    public Partie(int width,int height){
        this.width = width;
        this.height=height;
        this.monstres = FXCollections.observableArrayList();
        this.mapModele = new MapModele();
        this.berrys = new SimpleIntegerProperty(75);
        this.tempsSurvie = new SimpleIntegerProperty(0);

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
                } else if (monstres.get(i)instanceof Kaido) {
                    setBerrys(getBerrys()+45);
                }
            }
        }
        return berrys;
    }
    public void apparitionEnnemis(){
        int i = 0;
        while(!monstres.isEmpty()){
            //spawn de slime
            i++;
        }
    }
    public void setTempsSurvie(int x){
        tempsSurvie.setValue(x);
    }
    public IntegerProperty tempsSurvie(){
        return tempsSurvie;
    }
    public int getTempsSurvie(){return tempsSurvie.getValue();}
    public void unTour(int temps){
        setTempsSurvie(temps);
        if (temps % 10 == 0){
            Monstre m = new Slime();
            ajouter(m);
        } else if (temps % 17 ==0) {
            Monstre m = new Zodd();
            ajouter(m);
        } else if (temps % 29 == 0) {
            Monstre m = new Kaido();
            ajouter(m);
        }
        for (int i = 0; i < monstres.size(); i++) {
            Monstre a = monstres.get(i);
            a.bouge();
        }
    }
}
