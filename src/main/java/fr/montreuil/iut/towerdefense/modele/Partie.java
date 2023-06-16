package fr.montreuil.iut.towerdefense.modele;

import fr.montreuil.iut.towerdefense.modele.lesmonstres.Kaido;
import fr.montreuil.iut.towerdefense.modele.lesmonstres.Monstre;
import fr.montreuil.iut.towerdefense.modele.lesmonstres.Slime;
import fr.montreuil.iut.towerdefense.modele.lesmonstres.Zodd;
import fr.montreuil.iut.towerdefense.modele.lestours.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Partie {
    MapModele mapModele;
    private IntegerProperty berrys;
    public IntegerProperty tempsSurvie;
    private ObservableList<Tour> listeTours;
    private ObservableList<Monstre> monstres;
    private IntegerProperty vies;
    //private Vague vague;
    private boolean tourPrésent = false;
    private IntegerProperty score;

    public Partie(){
        this.monstres = FXCollections.observableArrayList();
        this.mapModele = new MapModele();
        this.berrys = new SimpleIntegerProperty(75);
        this.tempsSurvie = new SimpleIntegerProperty(0);
        this.listeTours = FXCollections.observableArrayList();
        this.vies = new SimpleIntegerProperty(3);
        this.score = new SimpleIntegerProperty(0);
    }
    public int getScore(){return score.getValue();}
    public void setScore(int x){ score.setValue(x);}
    public IntegerProperty scoreProperty(){return this.score ;}
    public int getVies(){
        return this.vies.getValue();
    }
    public void setVies(int x){this.vies.setValue(x);}
    public IntegerProperty viesProperty(){return this.vies;}
    public void ajouter(Monstre m){
        monstres.add(m);
    }

    public void ajouterTour (Tour t){
        listeTours.add(t);
    }

    public ObservableList<Monstre> getMonstres(){
        return monstres;
    }

    public ObservableList<Tour> getListeTours() {
        return listeTours;
    }

    public boolean dansTerrain(int x, int y){
        return x < 5 && y <9 && x >0 && y>0;
    }

    public int getBerrys(){
        return this.berrys.getValue();
    }

    public void setBerrys(int b){
        berrys.setValue(b);
    }
    public IntegerProperty berrysProperty(){
        return this.berrys;
    }
    public void compteurScoreBerrys(){
        for (int i = 0; i < monstres.size(); i++) {
            if (monstres.get(i).estMort()){
                if (monstres.get(i)instanceof Slime){
                    setBerrys(getBerrys()+5);
                    setScore(getScore()+10);
                }
                else if (monstres.get(i)instanceof Zodd) {
                    setBerrys(getBerrys()+15);
                    setScore(getScore()+50);
                }
                else if (monstres.get(i)instanceof Kaido) {
                    setBerrys(getBerrys()+45);
                    setScore(getScore()+100);

                }
            }
        }
    }

    public void setTempsSurvie(int x){
        tempsSurvie.setValue(x);
    }
    public IntegerProperty tempsSurvie(){
        return tempsSurvie;
    }
    public int getTempsSurvie(){return tempsSurvie.getValue();}

    //les vagues sont faites en fonction du temps

    public void apparitionSlime(){
        Slime s = new Slime();
        ajouter(s);
    }
    public void apparitionZodd(){
        Zodd z = new Zodd();
        ajouter(z);
    }
    public void apparitionKaido(){
        Kaido k = new Kaido();
        ajouter(k);
    }
    public void vagueMonstres1(int temps){
        //Pdt les 30premières secondes 10slimes vont apparaitre
        if (getTempsSurvie() < 30) {
            if (temps % 30 == 0) {
                    apparitionSlime();
            }
        }
        else if (getTempsSurvie() < 40) {
            if (temps% 20 == 0){
                apparitionSlime();
            }
        }
        //pause de 5secondes afin de pouvoir acheter une 2eme tour
        else if (getTempsSurvie() >= 45 &&getTempsSurvie() < 80){
            if (temps%17 == 0){
                apparitionSlime();
                System.out.println("2eme partie");
            }
        }
    }
    public void vagueMonstres2(int temps) {
        if (getTempsSurvie() < 100) {
            if (temps % 85 == 0) {
                apparitionZodd();
            }
        }
        else if (getTempsSurvie() < 120) {
             if (temps % 100 ==0) {
                apparitionZodd();
            }
        }
        else if(getTempsSurvie() < 140) {
            if (temps% 10 ==0 ){
                apparitionSlime();
            }
        }
    }
    public void vagueMonstres3(int temps){
        if(getTempsSurvie() < 160){
            if (temps%150 ==0){
                apparitionZodd();
                apparitionSlime();
            }
        }
        //apparition de 2 zodds mais il n'y a qu'un seul Zodd visible
        else if (getTempsSurvie() <190) {
            if(temps % 161 ==0){
                for (int i = 0; i < 2; i++) {
                  apparitionZodd();
                }
            } else if (temps% 175 == 0) {apparitionZodd();}
        }
        else if (getTempsSurvie() < 210) {
            if (temps % 10 == 0){
                for (int i = 0; i < 5; i++) {
                    apparitionSlime();
                }
            }
        } else {
                if (temps% 20 ==0)
                for (int i = 0; i < 10; i++) {
                    apparitionSlime();
                }
            }
    }
    public void vaguesMonstres4(int temps){
        if (getTempsSurvie() < 270){
            if (temps % 260 ==0){
                apparitionKaido();
            }
        } else if (getTempsSurvie() < 280) {
            if (temps % 275 ==0){
                apparitionKaido();
            }
        }
    }
    public void vaguesMonstres5(int temps){
        if (getTempsSurvie() > 300 && getTempsSurvie() < 350){
            if (temps%10 == 0){
                for (int i = 0; i < 20; i++) {
                    apparitionSlime();
                }
            } else if (temps% 33 ==0) {
                apparitionZodd();
            }
        } else if (getTempsSurvie() > 355 &&getTempsSurvie() < 410) {
            if (temps % 50 == 0){
                for (int i = 0; i < 5; i++) {
                    apparitionZodd();
                }
            }
        }
    }
    public void vaguesMonstres6(int temps){
        if (getTempsSurvie() < 440){
            if (temps%100 == 0){
                apparitionKaido();
            } else if (temps % 30 ==0) {
                apparitionZodd();
            }
        } else if (getTempsSurvie() < 520) {
            if (temps % 20 == 0 ){
                for (int i = 0; i < 2; i++) {
                    apparitionZodd();
                }
                for (int i = 0; i < 10; i++) {
                    apparitionSlime();
                }
            }
            else if (temps% 200 ==0){
                for (int i = 0; i < 2; i++) {
                    apparitionKaido();
                }
            }
        }
    }
    //méthode permettant la gestion des vagues
    public void vagueMonstres(int temps) {
        if (getTempsSurvie() < 80) {//<40
            vagueMonstres1(temps);
        } else if (getTempsSurvie() < 150) {
            vagueMonstres2(temps);
        } else if (getTempsSurvie() < 240) {
            vagueMonstres3(temps);
        } else if (getTempsSurvie() < 300) {
            vaguesMonstres4(temps);
        } else if (getTempsSurvie() < 420) {
            vaguesMonstres5(temps);
        } else if (getTempsSurvie() < 530) {
            vaguesMonstres6(temps);
        }
    }
    public MapModele getMapModele(){
        return mapModele;
    }

    public void unTour(int temps){
        compteurScoreBerrys();
        setTempsSurvie(temps/10);
        vagueMonstres(temps);

        for (int i = 0; i < monstres.size(); i++) {
            Monstre a = monstres.get(i);
            a.bouge();
        }
        tourEstPrésent();
        int k=0;
        if (tourPrésent) {
            for (int i = 0; i< getListeTours().size(); i++) {
                for (int j = 0 ; j < this.getMonstres().size(); j++){
                    getListeTours().get(i).detectionEnnemi(this.getMonstres().get(j));
                    getListeTours().get(i).attaque(this.getMonstres().get(j),300,temps);
                    getMonstres().get(j).ennemiMort();
                }
            }
        }
    }

    //ajoute les nouvelles tours dans la liste des tours
    public void ajouterTourDansListe(double x, double y, MapModele mapModele, int choixTour){
    if (choixTour == 1)
        listeTours.add(new TourGeo(x, y, mapModele));
    else if (choixTour == 2)
        listeTours.add(new TourCryo(x, y, mapModele));
    else if (choixTour == 3)
        listeTours.add(new TourPyro(x, y, mapModele));
    else
        listeTours.add(new TourElectro(x, y, mapModele));
    }

    public void tourEstPrésent (){
        if (!getListeTours().isEmpty())
            this.tourPrésent = true;
        else
            tourPrésent = false;
    }

}
