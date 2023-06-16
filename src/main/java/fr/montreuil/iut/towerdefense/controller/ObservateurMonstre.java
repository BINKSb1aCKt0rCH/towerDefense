package fr.montreuil.iut.towerdefense.controller;

import fr.montreuil.iut.towerdefense.modele.lesmonstres.Monstre;
import fr.montreuil.iut.towerdefense.vue.MonstreVue;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;


public class ObservateurMonstre implements ListChangeListener<Monstre> {
    private Pane panneauDeJeu;
    private MonstreVue monstreVue;
    private Label nbmonstresTues;
    public ObservateurMonstre(Pane panneauDeJeu, Label nbmonstresTues){
        super();
        this.panneauDeJeu = panneauDeJeu;
        this.monstreVue = new MonstreVue(panneauDeJeu);
        this.nbmonstresTues = nbmonstresTues;
    }
    @Override
    public void onChanged(javafx.collections.ListChangeListener.Change<? extends Monstre> m){
        while (m.next()){
            if (m.wasAdded()) {
                for (Monstre nouveau : m.getAddedSubList()) {
                    this.nbmonstresTues.setText("" + m.getList().size());
                    try {
                        //chaque fois qu'un monstre est crée dans le model on crée un sprite coté vue
                        monstreVue.creerSprite(nouveau);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            else if (m.wasRemoved()) {
                for(Monstre mort:m.getRemoved()){
                    //regarde la liste d'ennemis morts si un monstre est mort il se supprime
                    System.out.println(mort.getId());
                    this.panneauDeJeu.getChildren().remove(this.panneauDeJeu.lookup("#" + mort.getId()));

                }
            }

        }
    }
}
