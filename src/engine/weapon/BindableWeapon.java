package engine.weapon;

import java.util.function.BiConsumer;
import engine.BindableType;


public interface BindableWeapon extends BindableType<WeaponBuilder> {

    WeaponBuilder addFireRateListener (BiConsumer<Double, Double> listener);

    WeaponBuilder addTrajectoryListener (BiConsumer<String, String> listener);

    WeaponBuilder addEffectListener (BiConsumer<String, String> listener);

    WeaponBuilder addSpeed (BiConsumer<Double, Double> listener);

    WeaponBuilder addRangeListener (BiConsumer<Double, Double> listener);

}
