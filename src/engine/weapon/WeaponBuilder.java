package engine.weapon;

import engine.TypeBuilder;

public interface WeaponBuilder extends TypeBuilder<Weapon, WeaponBuilder>, BindableWeapon { //TODO - Add bindable interface

    WeaponBuilder buildFireRate (double fireRate);

    WeaponBuilder buildTrajectory (String trajectory);

    WeaponBuilder buildEffect (String effect);

    WeaponBuilder buildSpeed (double speed);

    WeaponBuilder buildRange (double range);

}
