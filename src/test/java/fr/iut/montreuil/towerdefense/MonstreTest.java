package fr.iut.montreuil.towerdefense;

import fr.montreuil.iut.towerdefense.modele.lesmonstres.Monstre;
import fr.montreuil.iut.towerdefense.modele.lesmonstres.Slime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MonstreTest {

    @Test
    void getPositionX() {
        Slime monstre = new Slime();
        monstre.setPositionX(2);

        int positionX = monstre.getPositionX();
        Assertions.assertEquals(2, positionX);
    }



    @Test
    void setPositionX() {
        Slime monstre = new Slime();
        int newPositionX = 2;
        monstre.setPositionX(newPositionX);
        int actualPositionX = monstre.getPositionX();
        Assertions.assertEquals(newPositionX, actualPositionX, "La position X doit être mise à jour avec la nouvelle valeur.");

    }

    @Test
    void setPositionY() {
        Slime monstre = new Slime();
        int newPositionY = 2;
        monstre.setPositionY(newPositionY);
        int actualPositionY = monstre.getPositionY();
        Assertions.assertEquals(newPositionY, actualPositionY, "La position Y doit être mise à jour avec la nouvelle valeur.");
    }

}

