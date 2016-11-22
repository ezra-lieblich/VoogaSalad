package authoring.editorview.weapon;

import java.util.List;


/**
 * Passes edits made to the weapon by the designer to the game engine.
 *
 */
public interface WeaponDataSource {

    public void setWeaponImage (int weaponID, String weaponImagePath);

    public void setWeaponDamage (int weaponID, int damage);

    public void setWeaponRange (int weaponID, int range);

    public void setWeaponFireRate (int weaponID, int fireRate);

    public void setWeaponSpeed (int weaponID, int speed);

    public void setWeaponCollisionEffect (int weaponID, String collisionEffect);

    public void setWeaponName (int weaponID, String name);

    public void setWeaponPath (int weaponID, String path);

    public int createWeapon ();

    public int getWeaponImage (int weaponID);

    public int getWeaponDamage (int weaponID);

    public int getWeaponRange (int weaponID);

    public List<Integer> getActiveWeaponIDs ();

}
