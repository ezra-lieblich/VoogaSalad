package authoring.editorview.weapon;

import authoring.editorview.weapon.subviews.WeaponImageBank;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class WeaponEditorView implements IWeaponEditorView {

    private BorderPane weaponEditorView;
    private WeaponImageBank weaponBank;

    public WeaponEditorView () {
        weaponEditorView = new BorderPane();
        setBorderPane();
        weaponBank = new WeaponImageBank();
    }

    private void setBorderPane () {
        weaponEditorView.setLeft(weaponBank.getInstanceAsNode());
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponEditorView;
    }

}
