package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.tower.ITowerSetView;
import authoring.editorview.tower.TowerAuthoringViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerSellPriceField implements ITowerSetView {

    private TextField towerSellField;
    private TowerAuthoringViewDelegate delegate;

    public TowerSellPriceField (ResourceBundle labelsResource) {
        towerSellField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredTowerSellPrice(towerSellField
                                                               .getText()));
    }

    @Override
    public void setDelegate (TowerAuthoringViewDelegate delegate) {
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
