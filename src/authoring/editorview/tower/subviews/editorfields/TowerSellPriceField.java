package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.tower.ITowerEditorView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerSellPriceField implements ITowerEditorView {

    private TextField towerSellField;
    private TowerEditorViewDelegate delegate;

    public TowerSellPriceField () {
        ResourceBundle labelsResource;
        String TOWER_EFFECT_RESOURCE_PATH = "resources/GameAuthoringTower";
        labelsResource = ResourceBundle.getBundle(TOWER_EFFECT_RESOURCE_PATH);
        towerSellField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredTowerSellPrice(towerSellField
                                                               .getText()));
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerSellField;
    }

    public void updateTowerSellPrice (String towerSellPrice) {
        towerSellField.setText(towerSellPrice);
    }

}
