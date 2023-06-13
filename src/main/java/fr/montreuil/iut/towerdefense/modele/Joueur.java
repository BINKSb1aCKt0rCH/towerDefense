package fr.montreuil.iut.towerdefense.modele;

public class Joueur {

    private int berry;
    private int score;
    private int nbMonstresTué;
    private Tour tour;

    public Joueur (int berry, int score, int nbMonstresTué){
        this.berry = 75;
        this.score = 0;
        this.nbMonstresTué = 0;
    }


    public int getBerry (){
        return this.berry;
    }

    public void setBerry (int berry){
        this.berry=berry;
    }

    public int getScore (){
        return this.score;
    }

    public void setScore (int newScore){
        this.score= newScore;
    }

    public int getNbMonstresTué() {
        return nbMonstresTué;
    }

    public void setNbMonstresTué(int nbMonstresTué) {
        this.nbMonstresTué = nbMonstresTué;
    }

    public void achatTour (){
        if (this.berry > this.tour.getCout())
            this.berry -= this.tour.getCout();
    }



    public String toString (){
        return "Vous avez " + this.berry + "de Berrys \n" + "Votre score est à " + this.score + "\n et vous avez tué " + this.nbMonstresTué + " monstres \n";
    }
}
