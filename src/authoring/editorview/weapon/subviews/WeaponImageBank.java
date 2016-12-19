package authoring.editorview.weapon.subviews;

import java.util.List;
import java.util.ResourceBundle;

import authoring.editorview.imagebank.ImageBank;
import authoring.editorview.weapon.WeaponAuthoringViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.control.Button;


/**
 * 
 * @author Kayla Schulz, Andrew Bihl
 *
 */

public class WeaponImageBank extends ImageBank {

    private WeaponAuthoringViewDelegate delegate;

    public WeaponImageBank (ResourceBundle labelsResource) {
        super();
        Button createWeaponButton =
                ButtonFactory.makeButton("New Weapon",
                                         e -> {
                                             delegate.onUserPressedCreateWeapon();
                                         });

        createWeaponButton.setPrefWidth(130);
        // First cell is a button
        this.addStaticCell(createWeaponButton);
    }

    public void setDelegate (WeaponAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    public void updateWeaponBank (List<Integer> activeWeapons) {
        super.updateBank(activeWeapons);
    }

    @Override
    protected void userSelectedRow (int index) {
        int selectedWeaponID = this.itemIDs.get(index);
        if (selectedWeaponID != -1)
            this.delegate.onUserSelectedWeapon(selectedWeaponID);
    }

}
