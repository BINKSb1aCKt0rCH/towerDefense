package fr.montreuil.iut.towerdefense.vue;

import fr.montreuil.iut.towerdefense.modele.MapModele;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MapVue {
    private MapModele map;
    public MapVue(){this.map =  new MapModele();}
    public void afficherMap2D(MapModele map, TilePane tuile) throws FileNotFoundException {
        int terrain[][] = map.getTuileMap();
        Image image;
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                if (terrain[i][j] == 1){
                     image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/chemin.png"));
                }
                else if (terrain[i][j] == 2) {
                     image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/tour.png"));

                }
                else if (terrain[i][j] == 3) {
                     image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/herbe.png"));

                }
                else {
                     image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/chateau.png"));

                }
                ImageView image1Bis = new ImageView(image);
                tuile.getChildren().add(image1Bis);
            }
        }
    }
}
