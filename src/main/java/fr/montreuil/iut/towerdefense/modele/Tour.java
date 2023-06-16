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
    public Tour(int cout, String couleur, double x, double y, int degat, MapModele mapModele){
        this.cout=cout;
        this.element = couleur;
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

    public void attaquerEnnemi(Monstre m) {
        int distance = calculerDistance(m.getPositionX(), m.getPositionY());

        if (distance <= perimetre) {
            m.estMort();
            System.out.println("La tour attaque l'ennemi ");
        } else {
            System.out.println("L'ennemi est hors de portée.");
        }
    }

    private int calculerDistance(double cibleX, double cibleY) {
        double disX = cibleX - x.getValue();
        double disY = cibleY - y.getValue();
        return (int) Math.sqrt(disX * disX + disY * disY);
    }

    public void update(){

        //detectionEnnemi();

    }
    public ArrayList<Projectile> getProjectiles() {

        return projectiles;
    }

    public void ajouterProjectile(Projectile p){

        projectiles.add(p);
    }


    public String toString (){
        return "La tour de " + this.element + " coûte " + this.cout + " berrys ";
    }


}
