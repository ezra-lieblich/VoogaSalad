package authoring.editorview.weapon;

/**
 * Passes edits made to the weapon by the designer to the game engine.
 *
 */
public interface WeaponDataSource {

    public void setWeaponImage (int weaponID, int weaponImageID);
    public void setWeaponDamage(int weaponID, int damage);
}
