package fr.montreuil.iut.towerdefense.modele.lestours;

import fr.montreuil.iut.towerdefense.modele.MapModele;
import fr.montreuil.iut.towerdefense.modele.lesmonstres.Monstre;
import fr.montreuil.iut.towerdefense.modele.lestours.Tour;

public class TourCryo extends Tour {
    public TourCryo(double x, double y, MapModele mapModele) {
        super(100, "Cryo",32*2 , x, y, mapModele);
    }
    public  void  attaque(Monstre m, int atk){
        if (detectionEnnemi(m) == true /*&& !m.estMort()*/){
            m.setPv(m.getPv() - atk);
            System.out.println("attaque");
        }
    }
}
