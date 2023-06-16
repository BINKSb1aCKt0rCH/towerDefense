package fr.montreuil.iut.towerdefense.modele.lestours;

import fr.montreuil.iut.towerdefense.modele.MapModele;
import fr.montreuil.iut.towerdefense.modele.lesmonstres.Monstre;
import fr.montreuil.iut.towerdefense.modele.lestours.Tour;

public class TourPyro extends Tour {
    public TourPyro(double x, double y, MapModele mapModele) {
        super("Pyro", 32+32/2, x, y, mapModele);
    }
}
