module fr.montreuil.iut.towerdefense {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens fr.montreuil.iut.towerdefense to javafx.fxml;
    exports fr.montreuil.iut.towerdefense;
    exports fr.montreuil.iut.towerdefense.controller;
    opens fr.montreuil.iut.towerdefense.controller to javafx.fxml;
}