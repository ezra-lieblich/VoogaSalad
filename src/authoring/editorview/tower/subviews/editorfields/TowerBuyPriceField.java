package authoring.editorview.tower.subviews.editorfields;

import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


public class TowerBuyPriceField {

    private TextField towerBuyField;
    private TowerEditorViewDelegate delegate;

    public TowerBuyPriceField () {
        towerBuyField =
                TextFieldFactory.makeTextField("Set tower buy price: ",
                                               e -> delegate
                                                       .onUserEnteredTowerBuyPrice(towerBuyField
                                                               .getText()));
    }

    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getTowerBuyPriceField () {
        return towerBuyField;
    }

    public void updateTowerBuyPrice (String towerBuyPrice) {
        towerBuyField.setText(towerBuyPrice);
    }

}
