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

        monstre.setPv(0); // on set le nombre de points de vie à 0 pour le monstre
        partie.getMonstres().add(monstre); // on l'ajoute à la liste de monstres (qui est une liste vide)
        partie.verifierEnnemisMorts(); //appel de la méthode (étant dans la classe Partie) vérifiant que le monstre est mort et donc enlever de la liste de monstres ssi nb de pvs <= 0
        assertEquals(0,partie.getMonstres().size()); //On voit si la liste de monstres est vide sachant que le monstre n'a plus de pvs

        monstre.setPv(10); // on set le nombre de points de vie à plus de 0 pour le monstre
        partie.getMonstres().add(monstre); // on l'ajoute à la liste de monstres (qui est une liste vide)
        partie.verifierEnnemisMorts(); //appel de la méthode (étant dans la classe Partie) vérifiant que le monstre est mort et donc enlever de la liste de monstres ssi nb de pvs <= 0
        assertEquals(1,partie.getMonstres().size()); //On voit si la liste de monstres est vide sachant que le monstre a encore des pvs

    }
    @Test
    public void projectilesCollisions(){

        monstre.setPositionX(2); // set position de x à 2 par exemple
        monstre.setPositionY(2); // set position de y à 2 par exemple
        projectile = new Projectile(2,3,"white",monstre,3,3, partie); //déclarer un projectile
        partie.getProjectiles().add(projectile); // ajouter projectile à la liste des projectiles qui est vide
        projectile.collision(monstre); // projectile inflige des dégâts à monstre
        partie.projectilesCollisions(); // il y a eu une collision entre projectile et monstre donc enlever monstre et projectile de la partie
        assertEquals(0,partie.getProjectiles().size()); //projectile enlevé donc on vérifie que la liste de projectiles est vide
    }
    @Test
    public void ajouterTourDansListe(){

        tour = new TourCryo(1,4,partie.getMapModele(),partie); //on prend la tourCryo comme exemple
        partie.getListeTours().add(tour); // on l'ajoute à la liste des tours(initialement vide)
        assertEquals(1,partie.getListeTours().size()); //on vérifie qu'elle a bien été ajouté

    }




}
