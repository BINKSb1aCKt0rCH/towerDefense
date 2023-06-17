package fr.montreuil.iut.towerdefense.modele.lestours;

import fr.montreuil.iut.towerdefense.modele.MapModele;
import fr.montreuil.iut.towerdefense.modele.Partie;

public class TourCryo extends Tour{

    public TourCryo(double x, double y, MapModele mapModele, Partie partie) {
        super("Cryo", 32*2 ,x, y, 175, mapModele,partie);
    }
}

