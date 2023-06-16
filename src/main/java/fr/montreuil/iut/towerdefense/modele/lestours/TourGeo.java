package fr.montreuil.iut.towerdefense.modele.lestours;

import fr.montreuil.iut.towerdefense.modele.MapModele;
import fr.montreuil.iut.towerdefense.modele.lesmonstres.Monstre;
import fr.montreuil.iut.towerdefense.modele.lestours.Tour;

public class TourGeo extends Tour {
    public TourGeo(double x, double y, MapModele mapModele) {
        super(75, "Geo", 32*3, x, y, mapModele);
    }    public  void  attaque(Monstre m, int atk){
        if (detectionEnnemi(m) == true /*&& !m.estMort()*/){
            m.setPv(m.getPv() - atk);
            System.out.println("attaque");
        }
    }
}
