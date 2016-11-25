package authoring.editorview.weapon;

public interface WeaponEditorViewDelegate {

    public void onUserEnteredWeaponFireRate (String weaponRate);

    public void onUserEnteredWeaponSpeed (String weaponSpeed);

    public void onUserEnteredWeaponEffect (String weaponCollisionEffect);

    public void onUserEnteredWeaponRange (String weaponRange);

    public void onUserEnteredWeaponImage (String weaponImagePath);

    public void onUserEnteredWeaponDamage (String weaponDamage);

    public void onUserEnteredWeaponName (String weaponName);

    public void onUserEnteredWeaponPath (String weaponPath);

    public void onUserPressedCreateWeapon ();

}
