package fr.montreuil.iut.towerdefense.modele;

public class TourGeo extends Tour {
    public TourGeo(double x, double y, MapModele mapModele) {
        super(75, "Geo", 32*3, x, y, mapModele);
    }
    public  void  attaque(Monstre m){
        if (detectionEnnemi(m) == true && !m.estMort()){
            m.setPv(m.getPv() - 100);
        }
    }
}
