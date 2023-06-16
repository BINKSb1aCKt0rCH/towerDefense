package fr.montreuil.iut.towerdefense.modele.lestours;

import fr.montreuil.iut.towerdefense.modele.MapModele;

public class TourCryo extends Tour{

    public TourCryo(double x, double y, MapModele mapModele) {
        super(100, "Cryo",32*2 ,x, y, 175, mapModele);
    }
}
