package authoring.editorview.weapon;

import authoring.editorview.EditorViewDelegate;

/**
 * 
 * @author Kayla Schulz
 * @author Andrew Bihl
 *
 */
public interface WeaponAuthoringViewDelegate extends EditorViewDelegate {

    public void onUserEnteredWeaponFireRate (String weaponRate);

    public void onUserEnteredWeaponSpeed (String weaponSpeed);

    public void onUserEnteredWeaponRange (String weaponRange);

    public void onUserEnteredWeaponImagePath (String weaponImagePath);

    public void onUserEnteredWeaponTrajectory (String weaponTrajectory);

    public void onUserEnteredNewTargetEnemy (String enemyID);

    public void onUserPressedCreateWeapon ();

    public void onUserEnteredWeaponSize (String weaponSize);

    public void onUserSelectedWeapon (int weaponID);

    public void onUserPressedAddEffect ();

}
