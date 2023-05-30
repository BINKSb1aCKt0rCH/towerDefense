package fr.montreuil.iut.towerdefense.modele;

public class MapModele {
    private int map[][];
    public MapModele(){
        this.map = new int[][] {
                {1,2,1,1,1,2,3,3,3},
                {1,2,1,2,1,2,3,4,4},
                {1,1,1,2,1,1,1,4,4},
                {1,2,1,2,1,2,3,4,4},
                {1,2,1,1,1,2,3,3,3},
        };
    }public int[][]getTuileMap(){
        return this.map;
    }

}
