package fr.montreuil.iut.towerdefense.modele;

public class TourPyro extends Tour{
    public TourPyro(double x, double y, MapModele mapModele) {
        super(100, "Pyro", 32+32/2, x, y, mapModele);
    }
    public  void  attaque(Monstre m){
        if (detectionEnnemi(m) == true && !m.estMort()){
            m.setPv(m.getPv() - 225);
        }
    }
}
