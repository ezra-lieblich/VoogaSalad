package authoring.editorview.weapon;

import java.util.List;


/**
 * Passes edits made to the weapon by the designer to the game engine.
 * 
 * @author Andrew Bihl
 */
public interface WeaponDataSource {

    public void setWeaponImagePath (int weaponID, String weaponImagePath);

    public void setWeaponDamage (int weaponID, int damage);

    public void setWeaponRange (int weaponID, int range);

    public void setWeaponFireRate (int weaponID, int fireRate);

    public void setWeaponSpeed (int weaponID, int speed);

    public void setWeaponCollisionEffect (int weaponID, String collisionEffect);

    public void setWeaponName (int weaponID, String name);

    public void setWeaponPath (int weaponID, String path);

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
