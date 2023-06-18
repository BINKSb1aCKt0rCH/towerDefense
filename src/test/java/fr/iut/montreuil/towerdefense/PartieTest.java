package fr.iut.montreuil.towerdefense;

import fr.montreuil.iut.towerdefense.modele.MapModele;
import fr.montreuil.iut.towerdefense.modele.Partie;
import fr.montreuil.iut.towerdefense.modele.Projectile;
import fr.montreuil.iut.towerdefense.modele.lesmonstres.Kaido;
import fr.montreuil.iut.towerdefense.modele.lesmonstres.Monstre;
import fr.montreuil.iut.towerdefense.modele.lestours.Tour;
import fr.montreuil.iut.towerdefense.modele.lestours.TourCryo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PartieTest {

    private Partie partie = new Partie();
    private Monstre monstre = new Kaido();
    private Projectile projectile;
    private Tour tour;


    @Test
    public void verifPlacement(){
        partie.ajouterTourDansListe(160,192,partie.getMapModele(),1);
        assertFalse(partie.verifPlacement(160,192)); // la tour ne peut pas être placée
        assertTrue(partie.verifPlacement(170,129)); // la tour peut être placée
    }
    @Test
    public void verifierEnnemisMorts(){

        monstre.setPv(0);
        partie.getMonstres().add(monstre);
        partie.verifierEnnemisMorts();
        assertEquals(0,partie.getMonstres().size());

        monstre.setPv(10);
        partie.getMonstres().add(monstre);
        partie.verifierEnnemisMorts();
        assertEquals(1,partie.getMonstres().size());

    }
    @Test
    public void projectilesCollisions(){

        monstre.setPositionX(2);
        monstre.setPositionY(2);
        projectile = new Projectile(2,3,"white",monstre,3,3, partie);
        partie.getProjectiles().add(projectile);
        projectile.collision(monstre);
        partie.projectilesCollisions();
        assertEquals(0,partie.getProjectiles().size());
    }
    @Test
    public void ajouterTourDansListe(){

        tour = new TourCryo(1,4,partie.getMapModele(),partie);
        partie.getListeTours().add(tour);
        assertEquals(1,partie.getListeTours().size());

    }




}
