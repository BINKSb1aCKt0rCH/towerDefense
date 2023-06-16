package fr.montreuil.iut.towerdefense.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Objects;

public class Tuile {

    private IntegerProperty posX,posY;

    public Tuile(int x, int y){
        this.posX=new SimpleIntegerProperty(x);
        this.posY=new SimpleIntegerProperty(y);
    }

    public int getX(){
        return this.posX.getValue();
    }

    public int gety(){
        return this.posY.getValue();
    }
    public void setX(int x){this.posX.setValue(x);}
    public void setY(int y){this.posY.setValue(y);}
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
