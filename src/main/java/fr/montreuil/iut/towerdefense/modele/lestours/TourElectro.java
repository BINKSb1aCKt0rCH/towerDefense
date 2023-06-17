package fr.montreuil.iut.towerdefense.modele.lestours;

import fr.montreuil.iut.towerdefense.modele.MapModele;
import fr.montreuil.iut.towerdefense.modele.Partie;

public class TourElectro extends Tour{

    public TourElectro(double x, double y, MapModele mapModele, Partie partie) {
        super("electro",32, x, y,300, mapModele,partie);
    }

}
