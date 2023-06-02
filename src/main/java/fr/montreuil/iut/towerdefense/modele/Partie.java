package fr.montreuil.iut.towerdefense.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Partie {
    MapModele mapModele;
    private int width,height;
    private int berrys ;
    private ObservableList<Monstre> monstres;public Partie(int width,int height){
        this.width = width;
        this.height=height;
        this.monstres = FXCollections.observableArrayList();
        this.mapModele = new MapModele();

    }
    public void ajouter(Monstre m){
        monstres.add(m);
    }
    public ObservableList<Monstre> getMonstres(){
        return monstres;
    }
    public boolean dansTerrain(int x, int y){return x < 5 && y <9 && x >0 && y>0;}

    public void unTour(){
        Monstre m = new Slime();
        ajouter(m);
        for (int i = 0; i < monstres.size(); i++) {
            Monstre a = monstres.get(i);
            a.bouge();
        }
    }
}
