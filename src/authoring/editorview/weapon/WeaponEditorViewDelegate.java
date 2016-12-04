package authoring.editorview.weapon;

public interface WeaponEditorViewDelegate {

    public void onUserEnteredWeaponFireRate (String weaponRate);

    public void onUserEnteredWeaponSpeed (String weaponSpeed);

    public void onUserEnteredWeaponEffect (String weaponCollisionEffect);

    public void onUserEnteredWeaponRange (String weaponRange);

    public void onUserEnteredWeaponImagePath (String weaponImagePath);

    public void onUserEnteredWeaponName (String weaponName);

    public void onUserEnteredWeaponTrajectory (String weaponTrajectory);

    public void onUserEnteredNewTargetEnemy (String enemyID);

    public void onUserPressedCreateWeapon ();

    public void onUserPressedDeleteWeapon ();

    public void onUserEnteredWeaponSize (String weaponSize);
    
    public void onUserSelectedWeapon (int weaponID);

}
