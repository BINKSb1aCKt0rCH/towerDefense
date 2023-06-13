package fr.montreuil.iut.towerdefense.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import javafx.collections.ObservableArray;

public class Partie {
    MapModele mapModele;
    private int width,height;
    private int berrys  = 75;
    private ObservableList<Tour> listeTours;
    private ObservableList<Monstre> monstres;

    public Partie(int width,int height){
        this.width = width;
        this.height=height;
        this.monstres = FXCollections.observableArrayList();
        this.mapModele = new MapModele();
        this.listeTours = FXCollections.observableArrayList();

    }
    public void ajouter(Monstre m){
        monstres.add(m);
    }

    public void ajouterTour (Tour t){
        listeTours.add(t);
    }

    public ObservableList<Monstre> getMonstres(){
        return monstres;
    }

    public ObservableList<Tour> getListeTours() {
        return listeTours;
    }

    public boolean dansTerrain(int x, int y){return x < 5 && y <9 && x >0 && y>0;}

    public void unTour(int temps){
        if (temps % 10 == 0){
            Monstre m = new Slime();
            ajouter(m);
        }
        for (int i = 0; i < monstres.size(); i++) {
            Monstre a = monstres.get(i);
            a.bouge();
        }
    }
    public int getBerrys(Monstre m){
        if (m.estMort(m)) {
            if (m instanceof Slime){
                return berrys = 5;
            } else if (m instanceof Zodd) {
                return berrys = 15;
            }
            else {
                return  berrys = 45;
            }
        }
        return 0;
    }

    public void ajouterPositionTour (double x, double y, MapModele mapModele){
        listeTours.add(new TourElectro(x,y,mapModele));
    }


    public MapModele getMapModele (){
        return this.mapModele;
    }
}
