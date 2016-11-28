package authoring.editorview.tower.subviews.editorfields;

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
        towerBuyField =
                TextFieldFactory.makeTextField("Set tower buy price: ",
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
