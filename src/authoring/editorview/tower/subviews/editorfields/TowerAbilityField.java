package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;
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
public class TowerAbilityField implements ITowerEditorView {

    private ComboBox<Object> towerAbilityBox;
    private TowerEditorViewDelegate delegate;
    private ResourceBundle labelsResource;

    public TowerAbilityField (ResourceBundle labelsResource) {
        this.labelsResource = labelsResource;
        ObservableList<Object> abilityOptions = setList();
        createComboBox(abilityOptions);
    }

    private ObservableList<Object> setList () {
        ObservableList<Object> abilityOptions =
                FXCollections.observableArrayList("IDK", "Sorry");
        return abilityOptions;
    }

    private void createComboBox (ObservableList<Object> abilityOptions) {
        towerAbilityBox =
                ComboBoxFactory.makeComboBox(labelsResource.getString("Ability"), e -> delegate
                        .onUserEnteredTowerAbility((String) towerAbilityBox.getValue()),
                                             abilityOptions);
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerAbilityBox;
    }

    public void updateTowerAbility (String towerAbility) {
        towerAbilityBox.setValue(towerAbility);
    }

}
