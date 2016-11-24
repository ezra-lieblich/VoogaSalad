package authoring.editorview.weapon;

import java.util.List;


/**
 * The Weapon View interface will detail the components of the weapon creation. The interface
 * determines a portion of our internal API.
 *
 */
public interface IWeaponUpdateView extends IWeaponEditorView {

    public void updateFireRateDisplay (int rate);

    public void updateSpeedDisplay (int speed);

    public void updateCollisionEffectDisplay (String collisionEffect);

    public void updateRangeDisplay (int range);

    public void updateWeaponImagePath (String imagePath);

    public void updateWeaponName (String weaponName);

    public void updateDamageDisplay (int damage);

    public void updateWeaponBank (List<Integer> activeWeapons);

    public void updateWeaponPath (String path);

    public void createNewWeapon ();

}
