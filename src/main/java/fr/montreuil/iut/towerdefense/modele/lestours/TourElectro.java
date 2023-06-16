package fr.montreuil.iut.towerdefense.modele.lestours;

import fr.montreuil.iut.towerdefense.modele.MapModele;

public class TourElectro extends Tour{

    public TourElectro(double x, double y, MapModele mapModele) {
        super("electro",32, x, y,300, mapModele);
    }

}