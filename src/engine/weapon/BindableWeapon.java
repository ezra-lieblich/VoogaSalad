package engine.weapon;

import java.util.function.BiConsumer;


public interface BindableWeapon {

    WeaponBuilder addFireRateListener (BiConsumer<Double, Double> listener);

    WeaponBuilder addTrajectoryListener (BiConsumer<String, String> listener);

    WeaponBuilder addEffectListener (BiConsumer<String, String> listener);

    WeaponBuilder addSpeed (BiConsumer<Double, Double> listener);

    WeaponBuilder addRangeListener (BiConsumer<Double, Double> listener);

}
