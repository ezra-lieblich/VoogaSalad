package authoring.editorview.tower.subviews.editorfields;

import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


public class TowerSellPriceField {

    private TextField towerSellField;
    private TowerEditorViewDelegate delegate;

    public TowerSellPriceField () {
        towerSellField =
                TextFieldFactory.makeTextField("Set tower sell price: ",
                                               e -> delegate
                                                       .onUserEnteredTowerSellPrice(towerSellField
                                                               .getText()));
    }

    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getTowerSellPriceField () {
        return towerSellField;
    }

    public void updateTowerSellPrice (String towerSellPrice) {
        towerSellField.setText(towerSellPrice);
    }

}
