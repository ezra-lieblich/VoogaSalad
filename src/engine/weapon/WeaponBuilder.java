package engine.weapon;

import engine.TypeBuilder;

public interface WeaponBuilder extends TypeBuilder<Weapon, WeaponBuilder>, WeaponInitializer, BindableWeapon { //TODO - Add bindable interface

    WeaponBuilder buildFireRate (double fireRate);

    WeaponBuilder buildTrajectory (String trajectory);

    WeaponBuilder buildUnlockLevel (String effect);

    WeaponBuilder buildSpeed (double speed);

    WeaponBuilder buildRange (double range);

}
