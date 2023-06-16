package fr.iut.montreuil.towerdefense;

import fr.montreuil.iut.towerdefense.vue.MapVue;
import org.junit.jupiter.api.Test;

public class TestMapVue {

    @Test
    public void testAfficherMap(){
        int[][] map = new int[][]{
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
        MapVue mapVue = new MapVue();

    }

}
