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
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                if (terrain[i][j] == 1){
                    Image image1 = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/chemin.png"));
                    ImageView image1Bis = new ImageView(image1);
                    tuile.getChildren().add(image1Bis);
                }
                else if (terrain[i][j] == 2) {
                    Image image2 = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/tour.png"));
                    ImageView image2Bis = new ImageView(image2);
                    tuile.getChildren().add(image2Bis);
                }
                else if (terrain[i][j] == 3) {
                    Image image3 = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/herbe.png"));
                    ImageView image3Bis = new ImageView(image3);
                    tuile.getChildren().add(image3Bis);
                }
                else {
                    Image image4 = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/towerdefense/chateau.png"));
                    ImageView image4Bis = new ImageView(image4);
                    tuile.getChildren().add(image4Bis);
                }
            }
        }
    }
}
