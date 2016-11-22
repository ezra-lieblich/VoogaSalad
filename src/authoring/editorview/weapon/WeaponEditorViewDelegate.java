package authoring.editorview.weapon;

public interface WeaponEditorViewDelegate {
    
    public void setWeaponFireRate (double fireRate);

    public void setWeaponSpeed (double speed);
    
    public void setWeaponEffect (String collisionEffect);
    
    public void setWeaponRange (int range);
    
    public void setWeaponImage (int weaponImageID);

    public void setWeaponDamage (int damage);

    public void createWeapon ();
    
}
