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
public class TowerBuyPriceField implements ITowerEditorView {

    private TextField towerBuyField;
    private TowerEditorViewDelegate delegate;

    public TowerBuyPriceField () {
        ResourceBundle labelsResource;
        String TOWER_EFFECT_RESOURCE_PATH = "resources/GameAuthoringTower";
        labelsResource = ResourceBundle.getBundle(TOWER_EFFECT_RESOURCE_PATH);
        towerBuyField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredTowerBuyPrice(towerBuyField
                                                               .getText()));
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerBuyField;
    }

    public void updateTowerBuyPrice (String towerBuyPrice) {
        towerBuyField.setText(towerBuyPrice);
    }

}
