package fr.montreuil.iut.towerdefense.modele;

import fr.montreuil.iut.towerdefense.vue.ProjectileVue;
import javafx.scene.layout.Pane;

public class ObsProjectile {

    private ProjectileVue projectileVue;
    private Pane panneauJeu;

    public ObsProjectile(Pane panneauJeu){

        this.panneauJeu=panneauJeu;
    }

}
