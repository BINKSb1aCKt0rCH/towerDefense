package fr.montreuil.iut.towerdefense.modele.lestours;

import fr.montreuil.iut.towerdefense.modele.MapModele;

public class TourGeo extends Tour {
    public TourGeo(double x, double y, MapModele mapModele) {
        super(75, "Geo", 32*3,x, y,100, mapModele);
    }
}
