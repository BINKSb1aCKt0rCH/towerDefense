package fr.montreuil.iut.towerdefense.modele;

        import javafx.beans.property.DoubleProperty;
        import javafx.beans.property.IntegerProperty;
        import javafx.beans.property.SimpleDoubleProperty;
        import javafx.beans.property.SimpleIntegerProperty;

        import java.util.ArrayList;

public abstract class Tour {

    private int cout;
    private String element;
    private int perimetre;
    private int degat;
    private DoubleProperty x, y ;
    private MapModele mapModele;
    private String id;
    private ArrayList<Projectile> projectiles;
    private ArrayList<Monstre> monstres;

    private static int compteur =0;
    private Tour Partie;

    public Tour(int cout, String couleur, int perimetre, double x, double y, int degat, MapModele mapModele){
        this.cout=cout;
        this.element = couleur;
        this.perimetre=perimetre;
        this.x= new SimpleDoubleProperty(x);
        this.y= new SimpleDoubleProperty(y);
        this.mapModele = mapModele;
        this.degat=degat;
        compteur++;
        this.id = "T"+compteur;
        this.projectiles=new ArrayList<>();
        this.monstres=new ArrayList<>();
    }

    public String getId (){
        return this.id;
    }

    public DoubleProperty getXProperty (){
        return this.x;
    }

    public DoubleProperty getYProperty (){
        return this.y;
    }

    public int getDegat(){
        return this.degat;
    }

    public void emplacement(int x, int y){
        if (peutEtrePositionné()==true){
            this.x.setValue(x);
            this.y.setValue(y);
        }
    }
    public boolean peutEtrePositionné(){
        for (int i = 0; i < mapModele.getTuileMap().length; i++) {
            if (mapModele.getTuileMap().equals(2)){
                return true;
            }
        }
        return false;
    }

    public int getCout (){
        return this.cout;
    }

    public void detectionEnnemi (Monstre monstre){
        //(RacineCarré((PosXTour - posXEnnemis)^2 + (PosYTtour - posYEnnemis)^2 ) <= périmètre )
        if (Math.sqrt(Math.pow(getXProperty().getValue() - monstre.getXProperty().getValue(),2) + (Math.pow(getYProperty().getValue() - monstre.getYProperty().getValue(),2))) <= this.perimetre){
            System.out.println("Ennemis détecter !!");
        }
    }
    public ArrayList<Projectile> getProjectiles() { return projectiles; }
    public void ajouterProjectile(Projectile p){ projectiles.add(p); }

    public void creerProjectile(){

        for(int i=0; i < monstres.size(); i++){
            boolean ennemiTrouve = false;
            if(Math.sqrt(Math.pow(getXProperty().getValue() - monstres.get(i).getXProperty().getValue(),2) + (Math.pow(getYProperty().getValue() - monstres.get(i).getYProperty().getValue(),2))) <= 65){
                this.Partie.projectiles.add(new Projectile(100, 2, "BLUE"));
                ennemiTrouve = true;
            } if(ennemiTrouve){
                break;
            }
        }
    }


    public String toString (){
        return "La tour de " + this.element + " coûte " + this.cout + " berrys ";
    }


}
