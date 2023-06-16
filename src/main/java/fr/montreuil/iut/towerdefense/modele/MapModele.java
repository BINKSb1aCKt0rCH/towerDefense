package fr.montreuil.iut.towerdefense.modele;

import fr.montreuil.iut.towerdefense.modele.lesmonstres.Monstre;

import java.util.ArrayList;

public class MapModele {
    public int map[][]; // Déclaration d'une variable pour stocker la carte sous forme d'un tableau à deux dimensions
    private Monstre monstre; // Déclaration d'une variable pour stocker un monstre
    private ArrayList<Tuile> tuiles, sommetsParcourus; // Déclaration de deux listes d'objets Tuile et sommetsParcourus
    private ArrayList<String> listeDirection; // Déclaration d'une liste de chaînes de caractères pour stocker les directions

    public MapModele() {
        // Initialisation de la carte avec des valeurs initiales
        this.map = new int[][]{
                {1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                {1,1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                {3, 2, 1, 2, 3, 3, 3, 2, 3, 3, 3, 3, 3, 3, 3},
                {3, 3, 1, 1, 1, 3, 1, 1, 1, 3, 3, 3, 3, 3, 3},
                {3, 3, 3, 2, 1, 2, 1, 2, 1, 3, 1, 1, 1, 3, 3},
                {3, 3, 3, 3, 1, 1, 1, 3, 1, 2, 1, 2, 1, 3, 3},
                {3, 3, 3, 3, 3, 2, 3, 2, 1, 1, 1, 2, 1, 2, 3},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 3, 3},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 0, 4, 4},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4},
        };

        this.tuiles = new ArrayList<Tuile>(); // Initialisation d'une liste pour stocker les objets Tuile
        // Parcours de la carte pour créer les objets Tuile correspondants à chaque case de la carte
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                this.tuiles.add(new Tuile(j, i)); // Création d'un nouvel objet Tuile et ajout à la liste
            }
        }
        this.sommetsParcourus = new ArrayList(); // Initialisation d'une liste pour stocker les sommets parcourus
        this.listeDirection = new ArrayList<>(); // Initialisation d'une liste pour stocker les directions
    }

    public int[][] getTuileMap() {
        return this.map; // Renvoie la carte sous forme de tableau à deux dimensions
    }

    public int valeur(int y, int x) {
        if (x < 0 || y < 0) {
            System.out.println(x+"_"+y); // Affiche les coordonnées de la case en dehors de la carte
            return -1;
        }
        if (x > map.length - 1 || y > map[0].length - 1) {
            System.out.println("x ou y > taille map"); // Affiche un message si les coordonnées dépassent la taille de la carte
            return -1;
        }
        return this.map[x][y]; // Renvoie la valeur de la case à la position (x, y) dans la carte
    }

    public Tuile getTuile(int i, int j) {
        // Parcours de la liste des tuiles pour trouver celle qui correspond aux coordonnées (i, j)
        for (Tuile t : this.tuiles) {
            if (t.getX() == i && t.gety() == j) {
                return t; // Renvoie la tuile trouvée
            }
        }
        System.out.println("i et j : "+i+"-"+j);
        System.out.println("tuile null"); // Affiche un message si aucune tuile n'est trouvée
        return null;
    }

    public Tuile tuileSuivante(int xDepart, int yDepart) {
        this.sommetsParcourus.add(getTuile(xDepart, yDepart)); // Ajoute la tuile de départ aux sommets parcourus
        Tuile tuileSuivant = getTuile(xDepart, yDepart); // Récupère la tuile de départ
        System.out.println(xDepart+"-"+yDepart); // Affiche les coordonnées de la tuile de départ

        // Vérification des cases voisines pour trouver la prochaine tuile à parcourir
        if (valeur(xDepart, yDepart + 1) == 1 && !sommetsParcourus.contains(getTuile(xDepart, yDepart + 1))) {
            listeDirection.add("bas");
            System.out.println("bas");// Ajoute la direction "bas" à la liste
            return getTuile(xDepart, yDepart+1); // Renvoie la tuile suivante

        } else if (valeur(xDepart+1, yDepart) == 1 && !sommetsParcourus.contains(getTuile(xDepart + 1, yDepart))) {
            listeDirection.add("droite");
            System.out.println("droit");// Ajoute la direction "droite" à la liste
            return getTuile(xDepart+1, yDepart); // Renvoie la tuile suivante

        } else if (valeur(xDepart-1, yDepart) == 1 && !sommetsParcourus.contains(getTuile(xDepart - 1, yDepart))) {
            listeDirection.add("gauche");
            System.out.println("gauche");// Ajoute la direction "gauche" à la liste
            return getTuile(xDepart-1, yDepart); // Renvoie la tuile suivante

        } else if (valeur(xDepart , yDepart-1) == 1 && !sommetsParcourus.contains(getTuile(xDepart , yDepart - 1))) {
            listeDirection.add("haut");
            System.out.println("haut");// Ajoute la direction "haut" à la liste
            return getTuile(xDepart, yDepart-1); // Renvoie la tuile suivante

        } else {
            System.out.println("pas de direction trouvé"); // Affiche un message si aucune direction n'est trouvée


            return null; // Renvoie la tuile de départ par défaut
        }
    }

    public ArrayList<String> getListeDirection() {
        int count = 0;
        // Compte le nombre de cases ayant la valeur 1 dans la carte
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count); // Affiche le nombre de cases ayant la valeur 1
        Tuile tuile = new Tuile(0, 0);
        int i = 0;
        // Parcours des tuiles pour déterminer les directions à prendre
        while (i < count - 1) {
            if (tuile == null) {
                System.out.println("TUILE NULL dns mapmodel");
                tuile = tuileSuivante(0, 0);
            } else {
                tuile = tuileSuivante(tuile.getX(), tuile.gety());
            }
            i++;
        }
        System.out.println(listeDirection); // Affiche la liste des directions
        sommetsParcourus.removeAll(sommetsParcourus); // Vide la liste des sommets parcourus
        return listeDirection; // Renvoie la liste des directions
    }

    public void setListeDirectionToEmpty() {
        this.listeDirection.removeAll(this.listeDirection); // Vide la liste des directions
    }

    public int getTile (int x, int y){
        return this.map[x][y];
    }

}
