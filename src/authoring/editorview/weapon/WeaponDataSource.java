package authoring.editorview.weapon;

import java.util.List;


/**
 * Passes edits made to the weapon by the designer to the game engine.
 * 
 * @author Andrew Bihl
 */
public interface WeaponDataSource {

    public void setWeaponImagePath (int weaponID, String weaponImagePath);

    public void setWeaponRange (int weaponID, double weaponRange);

    public void setWeaponFireRate (int weaponID, double weaponFireRate);

    public void setWeaponSpeed (int weaponID, double weaponSpeed);

    public void setWeaponCollisionEffect (int weaponID, String weaponCollisionEffect);

    public void setWeaponName (int weaponID, String weaponName);

    public void setWeaponTrajectory (int weaponID, String weaponTrajectory);

    public void setNewWeaponTargetEnemy (int weaponID, int enemyID);

    public void removeWeaponTargetEnemy (int weaponID, int enemyID);

    public int createWeapon ();

    public void deleteWeapon (int weaponID);

    public String getWeaponImagePath (int weaponID);

    public double getWeaponRange (int weaponID);

    public double getWeaponFireRate (int weaponID);

    public double getWeaponSpeed (int weaponID);

    public String getWeaponCollisionEffect (int weaponID);

    public String getWeaponName (int weaponID);

    public String getWeaponTrajectory (int weaponID);

    public List<Integer> getCreatedWeaponIDs ();

    public List<Integer> getTargetEnemies (int weaponID);

}
