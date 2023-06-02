package fr.montreuil.iut.towerdefense.modele;

import fr.montreuil.iut.towerdefense.vue.MonstreVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class ObservateurMonstre implements ListChangeListener<Monstre> {
    private Pane panneauDeJeu;
    private MonstreVue monstreVue;
    public ObservateurMonstre(Pane panneauDeJeu){
        super();
        this.panneauDeJeu = panneauDeJeu;
        this.monstreVue = new MonstreVue(panneauDeJeu);
    }
    @Override
    public void onChanged(javafx.collections.ListChangeListener.Change<? extends Monstre> m){
        while (m.next()){
            for(Monstre nouveau: m.getAddedSubList()){
                monstreVue.creerSprite(nouveau);
            }
            for(Monstre mort:m.getRemoved()){
                monstreVue.retirerSprite(mort);
            }
        }
    }
}
