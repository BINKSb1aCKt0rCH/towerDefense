package fr.montreuil.iut.towerdefense.modele.lestours;

import fr.montreuil.iut.towerdefense.modele.MapModele;
import fr.montreuil.iut.towerdefense.modele.Partie;

public class TourGeo extends Tour {
    public TourGeo(double x, double y, MapModele mapModele, Partie partie) {
        super("Geo", 32*3,x, y,100, mapModele,partie);
    }
}

