package fr.montreuil.iut.towerdefense.modele.lestours;

import fr.montreuil.iut.towerdefense.modele.MapModele;
import fr.montreuil.iut.towerdefense.modele.Partie;

public class TourPyro extends Tour{
    public TourPyro(double x, double y, MapModele mapModele,Partie partie) {
        super("Pyro", 32+32/2, x, y, 225, mapModele,partie);
    }
}

