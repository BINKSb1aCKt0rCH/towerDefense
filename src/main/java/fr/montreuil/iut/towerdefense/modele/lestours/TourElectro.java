package fr.montreuil.iut.towerdefense.modele.lestours;

import fr.montreuil.iut.towerdefense.modele.MapModele;
import fr.montreuil.iut.towerdefense.modele.lesmonstres.Monstre;
import fr.montreuil.iut.towerdefense.modele.lestours.Tour;

public class TourElectro extends Tour {

    public TourElectro(double x, double y, MapModele mapModele) {
        super("electro",150,32, y, mapModele);
    }
}