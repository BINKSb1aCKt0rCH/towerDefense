package fr.montreuil.iut.towerdefense.modele;

import fr.montreuil.iut.towerdefense.vue.ProjectileVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class ListObsProjectile implements ListChangeListener<Projectile> {

    private ProjectileVue projectileVue;
    private Pane panneauJeu;

    public ListObsProjectile(Pane panneauJeu){

        this.panneauJeu=panneauJeu;
    }
    @Override
    public void onChanged(Change<? extends Projectile> change) {

        while(change.next()) {
            if(change.wasAdded()){
                for(Projectile a : change.getAddedSubList()) {
                    ProjectileVue projectileVue = new ProjectileVue(panneauJeu);
                    projectileVue.créerSprite(a);
                }
            }else if(change.wasRemoved()){

            }

        }

    }
}
