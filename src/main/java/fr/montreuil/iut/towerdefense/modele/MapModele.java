package fr.montreuil.iut.towerdefense.modele;

import fr.montreuil.iut.towerdefense.modele.lesmonstres.Monstre;

import java.util.ArrayList;

public class MapModele {
    public int map[][];
    private ArrayList<Tuile> tuiles, sommetsParcourus; // Déclaration de deux listes d'objets Tuile et sommetsParcourus
    private ArrayList<String> listeDirection; // Déclaration d'une liste de chaînes de caractères pour stocker les directions
    private Tuile depart, arrive;

    public MapModele() {
        // Initialisation de la carte avec des valeurs initiales
        this.map = new int[][]{
                {1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                {1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                {3, 2, 1, 2, 3, 3, 3, 2, 3, 3, 3, 3, 3, 3, 3},
                {3, 3, 1, 1, 1, 3, 1, 1, 1, 3, 3, 3, 3, 3, 3},
                {3, 3, 3, 2, 1, 2, 1, 2, 1, 3, 1, 1, 1, 3, 3},
                {3, 3, 3, 3, 1, 1, 1, 3, 1, 2, 1, 2, 1, 3, 3},
                {3, 3, 3, 3, 3, 2, 3, 2, 1, 1, 1, 2, 1, 2, 3},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 3, 3},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 4, 4},
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
        this.setDepart(this.calculerPointDepart());
        this.setArrive(this.calculerPointArrive());
    }
    public int[][]getMap(){
        return this.map;
    }
    public Tuile getDepart(){return  this.depart;}
    public Tuile getArrive(){return this.arrive;}
    public void setDepart(Tuile t){this.depart = t;}
    public void setArrive(Tuile t){this.arrive = t;}

    public Tuile calculerPointDepart(){
        //on crée une premiere case de depart
        Tuile t = new Tuile(0,0);
        //boucle qui permet de connaitre la case de depart
        for (int i = 0; i < this.getMap().length; i++) {
            for (int j = 0; j < this.getMap()[i].length; j++) {
                if (map[i][j]==1){
                    //inversion i et j pour mettre en relation la position du tableau et la pos sur la map
                    t = new Tuile(j,i);
                }
            }
        }return t;
    }
    public Tuile calculerPointArrive(){
        //on crée une premiere case de depart
        Tuile t = new Tuile(0,0);
        //boucle qui permet de connaitre la case de depart
        for (int i = 0; i < this.getMap().length; i++) {
            for (int j = 0; j < this.getMap()[i].length; j++) {
                if (this.map[i][j]== 5){
                    //inversion i et j pour mettre en relation la position du tableau et la pos sur la map
                    t = new Tuile(j,i);
                }
            }
        }return t;
    }

    public int[][] getTuileMap() {
        return this.map; // Renvoie la carte sous forme de tableau à deux dimensions
    }

    public int valeur(int y, int x) {
        if (x < 0 || y < 0) {
            //System.out.println(x+"_"+y); // Affiche les coordonnées de la case en dehors de la carte
            return -1;
        }
        if (x > map.length - 1 || y > map[0].length - 1) {
            //System.out.println("x ou y > taille map"); // Affiche un message si les coordonnées dépassent la taille de la carte
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
        //System.out.println("i et j : "+i+"-"+j);
        return null;
    }

    public Tuile tuileSuivante(int xDepart, int yDepart) {
        this.sommetsParcourus.add(getTuile(xDepart, yDepart)); // Ajoute la tuile de départ aux sommets parcourus
        Tuile tuileSuivant = getTuile(xDepart, yDepart); // Récupère la tuile de départ
        //System.out.println(xDepart+"-"+yDepart); // Affiche les coordonnées de la tuile de départ

        // Vérification des cases voisines pour trouver la prochaine tuile à parcourir
        if (valeur(xDepart, yDepart + 1) == 1 && !sommetsParcourus.contains(getTuile(xDepart, yDepart + 1))) {
            listeDirection.add("bas");
            return getTuile(xDepart, yDepart+1); // Renvoie la tuile suivante

        } else if (valeur(xDepart+1, yDepart) == 1 && !sommetsParcourus.contains(getTuile(xDepart + 1, yDepart))) {
            listeDirection.add("droite");
            return getTuile(xDepart+1, yDepart); // Renvoie la tuile suivante

        } else if (valeur(xDepart-1, yDepart) == 1 && !sommetsParcourus.contains(getTuile(xDepart - 1, yDepart))) {
            listeDirection.add("gauche");
            return getTuile(xDepart-1, yDepart); // Renvoie la tuile suivante

        } else if (valeur(xDepart , yDepart-1) == 1 && !sommetsParcourus.contains(getTuile(xDepart , yDepart - 1))) {
            listeDirection.add("haut");
            return getTuile(xDepart, yDepart-1); // Renvoie la tuile suivante

        } else {
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
        //System.out.println(count); // Affiche le nombre de cases ayant la valeur 1
        Tuile tuile = new Tuile(0, 0);
        int i = 0;
        // Parcours des tuiles pour déterminer les directions à prendre
        while (i < count - 1) {
            if (tuile == null) {
                //System.out.println("TUILE NULL dns mapmodel");
                tuile = tuileSuivante(0, 0);
            } else {
                tuile = tuileSuivante(tuile.getX(), tuile.gety());
            }
            i++;
        }
        //System.out.println(listeDirection); // Affiche la liste des directions
        sommetsParcourus.removeAll(sommetsParcourus); // Vide la liste des sommets parcourus
        return listeDirection; // Renvoie la liste des directions
    }

    public void setListeDirectionToEmpty() {
        this.listeDirection.removeAll(this.listeDirection); // Vide la liste des directions
    }

    public int getTile (int x, int y){
        return this.map[x][y];
    }
    public boolean verificationArrive(int x,int y){
        boolean verification = false;
        System.out.println("posx" + x +"pos y " + y);
        System.out.println("position case arrive" + arrive.getX() +arrive.gety());
        if ((x) == arrive.getX()*31+4 && (y) == arrive.gety()*28){
            System.out.println("est arrivé");
             verification = true;
        }
        return verification;
    }
}
