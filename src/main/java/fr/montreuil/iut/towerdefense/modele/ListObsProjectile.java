package fr.montreuil.iut.towerdefense.modele;

import fr.montreuil.iut.towerdefense.vue.ProjectileVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;

public class ListObsProjectile implements ListChangeListener<Projectile> {

    private ProjectileVue projectileVue;
    private Pane panneauJeu;

    public ListObsProjectile(Pane panneauJeu) {

        this.panneauJeu = panneauJeu;
    }

    @Override
    public void onChanged(Change<? extends Projectile> change) {

        while (change.next()) {
            if (change.wasAdded()) {
                for (Projectile a : change.getAddedSubList()) {
                    System.out.println("ajout projectiles vue");
                    projectileVue = new ProjectileVue(panneauJeu);
                    try {
                        projectileVue.créerSprite(a);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else if (change.wasRemoved()) {

            }
            for (Projectile a : change.getRemoved()) {
                System.out.println("suppression projectiles vue ");
                panneauJeu.getChildren().remove(panneauJeu.lookup("#" + a.getId()));
            }
        }

    }
}
