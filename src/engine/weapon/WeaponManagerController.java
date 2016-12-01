package engine.weapon;

import java.util.List;
import authoring.editorview.weapon.IWeaponEditorView;
import engine.ManagerController;


/**
 * Passes edits made to the weapon by the designer to the game engine.
 * 
 * @author Andrew Bihl
 */
public interface WeaponManagerController extends ManagerController<WeaponManager, WeaponBuilder, Weapon, IWeaponEditorView> {

    public void setWeaponRange (int weaponID, double weaponRange);

    public void setWeaponFireRate (int weaponID, double weaponFireRate);

    public void setWeaponSpeed (int weaponID, double weaponSpeed);

    public void setWeaponCollisionEffect (int weaponID, String weaponCollisionEffect);

    public void setWeaponTrajectory (int weaponID, String weaponTrajectory);

    public void setNewWeaponTargetEnemy (int weaponID, int enemyID);

    public void removeWeaponTargetEnemy (int weaponID, int enemyID);

    public double getWeaponRange (int weaponID);

    public double getWeaponFireRate (int weaponID);

    public double getWeaponSpeed (int weaponID);

    public String getWeaponCollisionEffect (int weaponID);

    public String getWeaponTrajectory (int weaponID);

    public List<Integer> getTargetEnemies (int weaponID);

}
