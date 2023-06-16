package fr.montreuil.iut.towerdefense.controller;

import fr.montreuil.iut.towerdefense.modele.lestours.Tour;
import fr.montreuil.iut.towerdefense.vue.TourVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;

public class ObservateurTour implements ListChangeListener<Tour> {

    private Pane panneauDeJeu;
    private TourVue tourVue;

    public ObservateurTour (Pane panneauDeJeu){
        super();
        this.panneauDeJeu = panneauDeJeu;
        this.tourVue = new TourVue(panneauDeJeu);
    }

    @Override
    public void onChanged(javafx.collections.ListChangeListener.Change<? extends Tour> change) {
        while (change.next()) {
            for (Tour nouvelleTour : change.getAddedSubList()) {
                try {
                    tourVue.creerSpriteTourImage(nouvelleTour);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            for (Tour supTour : change.getRemoved()) {
                tourVue.supSpriteTour(supTour);
            }
        }
    }


}