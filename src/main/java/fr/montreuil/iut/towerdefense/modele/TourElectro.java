package fr.montreuil.iut.towerdefense.modele;

public class TourElectro extends Tour{

    public TourElectro(double x, double y, MapModele mapModele) {
        super(150,"electro",32, x,y, mapModele);
    }
    public  void  attaque(Monstre m){
        if (detectionEnnemi(m) == true && !m.estMort()){
            m.setPv(m.getPv() - 300);
        }
    }

}