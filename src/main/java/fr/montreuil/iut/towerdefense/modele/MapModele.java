package fr.montreuil.iut.towerdefense.modele;

public class MapModele {
    private int map[][];
    public MapModele(){
        this.map = new int[][] {
                {1,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
                {1,1,1,3,3,3,3,3,3,3,3,3,3,3,3},
                {3,2,1,2,3,3,3,2,3,3,3,3,3,3,3},
                {3,3,1,1,1,3,1,1,1,3,3,3,3,3,3},
                {3,3,3,2,1,2,1,2,1,3,1,1,1,3,3},
                {3,3,3,3,1,1,1,3,1,2,1,2,1,3,3},
                {3,3,3,3,3,2,3,2,1,1,1,2,1,2,3},
                {3,3,3,3,3,3,3,3,3,3,3,3,1,3,3},
                {3,3,3,3,3,3,3,3,3,3,4,4,4,4,4},
                {3,3,3,3,3,3,3,3,3,3,4,4,4,4,4},
        };
    }public int[][]getTuileMap(){
        return this.map;
    }

    public int getTile (int x, int y){
        return this.map[x][y];
    }

}
