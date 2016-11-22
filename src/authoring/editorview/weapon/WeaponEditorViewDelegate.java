package authoring.editorview.weapon;

public interface WeaponEditorViewDelegate {

    public void onUserEnteredWeaponFireRate (String rate);

    public void onUserEnteredProjectileSpeed (String speed);

    public void onUserEnteredWeaponEffect (String collisionEffect);

    public void onUserEnteredWeaponRange (String range);

    public void onUserEnteredWeaponImage (String weaponImagePath);

    public void onUserEnteredWeaponDamage (String damage);

    public void onUserEnteredWeaponName (String weaponName);
    
    public void onUserEnteredWeaponPath (String path);

    public void onUserPressedCreate ();

}
