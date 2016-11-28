package authoring.editorview.tower.subviews.editorfields;

import authoring.editorview.tower.ITowerEditorView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerUpgradeField implements ITowerEditorView {

    private ComboBox<Object> towerUpgradeBox;
    private TowerEditorViewDelegate delegate;

    public TowerUpgradeField () {
        ObservableList<Object> upgradeOptions = setList();
        createComboBox(upgradeOptions);
    }

    private ObservableList<Object> setList () {
        ObservableList<Object> upgradeOptions =
                FXCollections.observableArrayList("IDK", "Sorry");
        return upgradeOptions;
    }

    private void createComboBox (ObservableList<Object> upgradeOptions) {
        towerUpgradeBox =
                ComboBoxFactory.makeComboBox("Set tower upgrade: ", e -> delegate
                        .onUserEnteredTowerUpgrade((String) towerUpgradeBox.getValue()),
                                             upgradeOptions);
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerUpgradeBox;
    }

    public void updateTowerUpgrade (String towerUpgrade) {
        towerUpgradeBox.setValue(towerUpgrade);
    }

}