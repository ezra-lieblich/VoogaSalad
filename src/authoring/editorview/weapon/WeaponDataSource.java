package authoring.editorview.weapon;

import java.util.List;


/**
 * Passes edits made to the weapon by the designer to the game engine.
 * 
 * @author Andrew Bihl
 */
public interface WeaponDataSource {

    public void setWeaponImagePath (int weaponID, String weaponImagePath);

    public void setWeaponDamage (int weaponID, int weaponDamage);

    public void setWeaponRange (int weaponID, int weaponRange);

    public void setWeaponFireRate (int weaponID, int weaponFireRate);

    public void setWeaponSpeed (int weaponID, int weaponSpeed);

    public void setWeaponCollisionEffect (int weaponID, String weaponCollisionEffect);

    public void setWeaponName (int weaponID, String weaponName);

    public void setWeaponPath (int weaponID, String weaponPath);

    public void createWeapon ();

    public int getCreatedWeapon ();

    public String getWeaponImagePath (int weaponID);

    public int getWeaponDamage (int weaponID);

    public int getWeaponRange (int weaponID);

    public int getWeaponFireRate (int weaponID);

    public int getWeaponSpeed (int weaponID);

    public String getWeaponCollisionEffect (int weaponID);

    public String getWeaponName (int weaponID);

    public String getWeaponPath (int weaponID);

    public List<Integer> getActiveWeaponIDs ();

}
