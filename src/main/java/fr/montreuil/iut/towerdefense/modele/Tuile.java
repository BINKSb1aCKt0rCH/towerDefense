package fr.montreuil.iut.towerdefense.modele;

import java.util.Objects;

public class Tuile {

    private int posX,posY;

    public Tuile(int x, int y){
        this.posX=x;
        this.posY=y;
    }

    public int getX(){
        return this.posX;
    }

    public int gety(){
        return this.posY;
    }

    @Override
    public String toString() {
        return "Tuile{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuile tuile = (Tuile) o;
        return posX == tuile.posX && posY == tuile.posY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }
}
