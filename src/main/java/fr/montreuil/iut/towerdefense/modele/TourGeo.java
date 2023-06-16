package fr.montreuil.iut.towerdefense.modele;

public class TourGeo extends Tour {
    public TourGeo(double x, double y, MapModele mapModele) {
        super( "Geo", 32*3, x, y, mapModele);
    }
}
