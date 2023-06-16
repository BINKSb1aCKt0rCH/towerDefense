package fr.montreuil.iut.towerdefense.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public abstract class Monstre {
    private int pv; // Points de vie du monstre
    private int vitesse; // Vitesse de déplacement du monstre
    private String nom; // Nom du monstre
    private IntegerProperty positionXProperty; // Propriété pour la position X du monstre
    private IntegerProperty positionYProperty; // Propriété pour la position Y du monstre
    private Partie partie; // Instance de la partie en cours
    private int directionX; // Direction en X du monstre
    private int directionY; // Direction en Y du monstre
    private fr.montreuil.iut.towerdefense.modele.MapModele mapModele; // Modèle de la carte
    private ArrayList<String> listePositions ; // Liste des positions du monstre
    private int numPos; // Numéro de position courant
    private  MapModele map;

    public Monstre(int pv, int v, String nom) {
        this.pv = pv;
        this.vitesse = 5;
        this.nom = nom;
        this.positionXProperty = new SimpleIntegerProperty(16); // Position X initiale du monstre
        this.positionYProperty = new SimpleIntegerProperty(16); // Position Y initiale du monstre
        this.partie = new Partie(); // Instance d'une partie avec une taille de 500x500
        this.mapModele = new fr.montreuil.iut.towerdefense.modele.MapModele(); // Modèle de la carte
        this.listePositions = new ArrayList<>(); // Liste des positions du monstre
        setListePositions(mapModele.getListeDirection());
        this.numPos = 0; // Numéro de position initial
    }

    public int getPositionX() {
        return this.positionXProperty.get(); // Renvoie la position X du monstre
    }

    public int getPositionY() {
        return this.positionYProperty.get(); // Renvoie la position Y du monstre
    }

    public void setPositionX(int x) {
        this.positionXProperty.set(x); // Définit la position X du monstre
    }

    public void setPositionY(int y) {
        this.positionYProperty.set(y); // Définit la position Y du monstre
    }

    public IntegerProperty positionXProperty() {
        return this.positionXProperty; // Renvoie la propriété de la position X du monstre
    }

    public IntegerProperty positionYProperty() {
        return this.positionYProperty; // Renvoie la propriété de la position Y du monstre
    }

    public void bouge() {
        //this.listePositions.clear();
        //setListePositions(mapModele.getListeDirection());
        //System.out.println(listePositions.size() + "aze");
        //mapModele.setListeDirectionToEmpty();
        //System.out.println(mapModele.getListeDirection() +  " liste de direction");
        //System.out.println(listePositions.size() + " liste");
        if (numPos < listePositions.size()) {
            String pos = listePositions.get(numPos);
            setPositionX(Integer.valueOf(pos.split("_")[0])); // Met à jour la position X du monstre avec la valeur extraite de la liste des positions
            setPositionY(Integer.valueOf(pos.split("_")[1])); // Met à jour la position Y du monstre avec la valeur extraite de la liste des positions

            for (int i = 0; i < mapModele.getTuileMap().length; i++) {
                for (int j = 0; j < mapModele.getTuileMap()[i].length; j++) {
                    if (mapModele.getTuileMap()[i][j] == 12 && mapModele.getTuileMap()[i][j] == 6) {
                        System.out.println("ok");
                    }
                    System.out.println(" ok 2");
                }
            }



        }
        this.numPos++; // Incrémente le numéro de position courant



    }

    public void bouge2() {

    }


    /**W
     * Calcule les coordonnées de la case correspondant à une position donnée en pixels.
     *
     * @param positionX Position X du monstre en pixels
     * @param positionY Position Y du monstre en pixels
     * @return Tableau contenant les coordonnées de la case correspondante [ligne, colonne]
     */
    private int[] calculeNumeroCase(int positionX, int positionY) {
        int numeroCaseColonnes = positionY / 35; // Calcule le numéro de la colonne en divisant la position Y par la taille d'une tuile
        int numeroCaseLigne = positionX / 35; // Calcule le numéro de la ligne en divisant la position X par la taille d'une tuile
        int[] numeroDeLaCase = {numeroCaseLigne, numeroCaseColonnes}; // Tableau contenant les coordonnées de la case
        return numeroDeLaCase; // Renvoie les coordonnées de la case
    }

    public ArrayList<String> getListePositions() {

        return listePositions; // Renvoie la liste des positions du monstre
    }


    public void setListePositions(ArrayList<String> listeDirection) {
        ArrayList<String> listePos = new ArrayList<>(); // Nouvelle liste de positions
        //listeDirection =mapModele.getListeDirection();
        int xCourant = getPositionX(); // Position X courante du monstre
        int yCourant = getPositionY(); // Position Y courante du monstre
        int  nbpos = 30 / vitesse + 2; // Nombre de positions à ajouter en fonction de la vitesse du monstre
        for (String dir : listeDirection) {
            if ("bas".equals(dir)) {
                for (int i = 1; i < nbpos; i++) {
                    String pos = xCourant + "_" + (yCourant + i * 4); // Calcule la position basée sur la position courante et la vitesse du monstre
                    listePos.add(pos); // Ajoute la position à la liste des positions
                }
                yCourant = yCourant + 30; // Met à jour la position Y courante
            } else if ("haut".equals(dir)) {
                for (int i = 1; i < nbpos; i++) {
                    String pos = xCourant + "_" + (yCourant - i * 4); // Calcule la position basée sur la position courante et la vitesse du monstre
                    listePos.add(pos); // Ajoute la position à la liste des positions
                }
                yCourant = yCourant - 30; // Met à jour la position Y courante
            } else if ("droite".equals(dir)) {
                for (int i = 1; i < nbpos; i++) {
                    String pos = (xCourant + i * 4) + "_" + yCourant; // Calcule la position basée sur la position courante et la vitesse du monstre
                    listePos.add(pos); // Ajoute la position à la liste des positions
                }
                xCourant = xCourant + 30; // Met à jour la position X courante
            } else if ("gauche".equals(dir)) {
                for (int i = 1; i < nbpos; i++) {
                    String pos = (xCourant - i * 4) + "_" + yCourant; // Calcule la position basée sur la position courante et la vitesse du monstre
                    listePos.add(pos); // Ajoute la position à la liste des positions
                }
                xCourant = xCourant - 30; // Met à jour la position X courante
            }
        }
        this.listePositions = listePos; // Met à jour la liste des positions du monstre
      //  System.out.println(listePositions);
    }


    public void setX(int x){
        positionXProperty.setValue(x);
    }
    public void setY(int y){
        positionYProperty.setValue(y);
    }
    public IntegerProperty getXProperty(){
        return this.positionXProperty;
    }
    public IntegerProperty getYProperty(){
        return this.positionYProperty;
    }


    public boolean estMort(){
        return this.pv <= 0;
    }

}
