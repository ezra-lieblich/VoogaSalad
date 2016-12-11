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
public class TowerBuyPriceField implements ITowerSetView {

    private TextField towerBuyField;
    private TowerAuthoringViewDelegate delegate;

    public TowerBuyPriceField (ResourceBundle labelsResource) {
        towerBuyField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredTowerBuyPrice(towerBuyField
                                                               .getText()));
    }

    @Override
    public void setDelegate (TowerAuthoringViewDelegate delegate) {
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
