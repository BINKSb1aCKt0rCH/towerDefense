module fr.montreuil.iut.towerdefense {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;

    opens fr.montreuil.iut.towerdefense to javafx.fxml;
    exports fr.montreuil.iut.towerdefense;
    exports fr.montreuil.iut.towerdefense.controller;
    opens fr.montreuil.iut.towerdefense.controller to javafx.fxml;
    exports fr.montreuil.iut.towerdefense.modele;
    opens fr.montreuil.iut.towerdefense.modele to javafx.fxml;
    exports fr.montreuil.iut.towerdefense.modele.lesmonstres;
    opens fr.montreuil.iut.towerdefense.modele.lesmonstres to javafx.fxml;
    exports fr.montreuil.iut.towerdefense.modele.lestours;
    opens fr.montreuil.iut.towerdefense.modele.lestours to javafx.fxml;
}