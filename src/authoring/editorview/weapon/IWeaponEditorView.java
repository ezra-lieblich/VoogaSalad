package authoring.editorview.weapon;

import java.util.List;
import authoring.editorview.IEditorView;


/**
 * The Weapon View interface will detail the components of the weapon creation. The interface
 * determines a portion of our internal API.
 *
 */
public interface IWeaponEditorView extends IEditorView {

    public void setDelegate (WeaponEditorViewDelegate delegate);

    public void updateFireRateDisplay (int rate);

    public void updateSpeedDisplay (int speed);

    public void updateCollisionEffectDisplay (String collisionEffect);

    public void updateRangeDisplay (int range);

    public void updateImagePath (String imagePath);

    public void updateWeaponID (int weaponID);

    public void updateDamageDisplay (int damage);

    public void updateWeaponBank (List<Integer> activeWeapons);

    public void onUserPressedCreate ();

}
