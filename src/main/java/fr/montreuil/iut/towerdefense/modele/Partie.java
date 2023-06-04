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
    private ObservableList<Monstre> monstres;public Partie(int width,int height){
        this.width = width;
        this.height=height;
        this.monstres = FXCollections.observableArrayList();
        this.mapModele = new MapModele();
        this.berrys = new SimpleIntegerProperty(75);

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

    public void unTour(int temps){
        if (temps % 20 == 0){
            Monstre m = new Slime();
            ajouter(m);
        } else if (temps % 50 ==0) {
            Monstre m = new Zodd();
            ajouter(m);
        } else if (temps % 300 == 0) {
            Monstre m = new Kaido();
            ajouter(m);
        }
        for (int i = 0; i < monstres.size(); i++) {
            Monstre a = monstres.get(i);
            a.bouge();
        }
    }
}
