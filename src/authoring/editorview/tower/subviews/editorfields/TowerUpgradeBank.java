package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.tower.ITowerSetView;
import authoring.editorview.tower.TowerAuthoringViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerUpgradeBank implements ITowerSetView {

    private HBox towerUpgradeBox;
    private TowerAuthoringViewDelegate delegate;
    private ResourceBundle labelsResource;
    private Button addTowerUpgrade;

    public TowerUpgradeBank (ResourceBundle labelsResource) {
        this.labelsResource = labelsResource;
        towerUpgradeBox = new HBox(5);
        setHBox();
    }

    @Override
    public void setDelegate (TowerAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerUpgradeBox;
    }

    public void addTowerUpgrade (String towerUpgrade) {
        // towerUpgradeBox.setValue(towerUpgrade);
    }

    public void deleteTowerUpgrade (String towerUpgrade) {

    }

    private void setHBox () {
        addTowerUpgrade = ButtonFactory.makeButton("Add Upgrade", e -> dummyMethod());
        towerUpgradeBox.getChildren().add(addTowerUpgrade);
        towerUpgradeBox.setStyle("-fx-padding: 5;" +
                                 "-fx-border-style: solid inside;" +
                                 "-fx-border-width: 1;" +
                                 "-fx-border-insets: 3;" +
                                 "-fx-border-radius: 2;" +
                                 "-fx-border-color: black;");
    }

    private void dummyMethod () {
        System.out.println("Help");
    }

}
