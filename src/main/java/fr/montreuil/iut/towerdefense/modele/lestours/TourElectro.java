package fr.montreuil.iut.towerdefense.modele.lestours;

import fr.montreuil.iut.towerdefense.modele.MapModele;
import fr.montreuil.iut.towerdefense.modele.lesmonstres.Monstre;
import fr.montreuil.iut.towerdefense.modele.lestours.Tour;

public class TourElectro extends Tour {

    public TourElectro(double x, double y, MapModele mapModele) {
        super(150,"electro",32, x,y, mapModele);
    }
    public  void  attaque(Monstre m, int atk){
        if (detectionEnnemi(m) == true /*&& !m.estMort()*/){
            m.setPv(m.getPv() - atk);
            System.out.println("attaque");
        }
    }
    public int degats(){
        return 300;
    }

}