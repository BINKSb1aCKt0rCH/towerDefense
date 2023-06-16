package fr.montreuil.iut.towerdefense.modele;

public class TourCryo extends Tour{
    public TourCryo(double x, double y, MapModele mapModele) {
        super(100, "Cryo",32*2 , x, y, mapModele);
    }
    public  void  attaque(Monstre m){
        if (detectionEnnemi(m) == true && !m.estMort()){
            m.setPv(m.getPv() - 175);
        }
    }
}
