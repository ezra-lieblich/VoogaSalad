package authoring.editorview.weapon.subviews;

import java.io.File;
import java.util.List;
import java.util.ResourceBundle;

import authoring.editorview.ImageBank;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * 
 * @author Kayla Schulz, Andrew Bihl
 *
 */

public class WeaponImageBank extends ImageBank {

    private WeaponEditorViewDelegate delegate;

    public WeaponImageBank (ResourceBundle labelsResource) {
    	super();
        Button createWeaponButton =
                ButtonFactory.makeButton("Create Weapon",
                                         e -> {
                                             delegate.onUserPressedCreateWeapon();
                                         });

        // First cell is a button
        items.add(createWeaponButton);
    }

    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public void updateWeaponBank (List<Integer> activeWeapons) {
        super.updateBank(activeWeapons);
    }


	@Override
	protected void userSelectedRow(int index) {
		int selectedWeaponID = this.itemIDs.get(index);
		this.delegate.onUserSelectedWeapon(selectedWeaponID);
	}

}
