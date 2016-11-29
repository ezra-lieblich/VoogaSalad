package engine.weapon;

import java.util.List;
import java.util.function.BiConsumer;
import engine.BindableType;


public interface BindableWeapon extends BindableType<WeaponBuilder> {

    WeaponBuilder addTargetsListener (BiConsumer<List<Integer>, List<Integer>> listener);
    
    WeaponBuilder addFireRateListener (BiConsumer<Double, Double> listener);

    WeaponBuilder addTrajectoryListener (BiConsumer<String, String> listener);

    WeaponBuilder addEffectListener (BiConsumer<String, String> listener);

    WeaponBuilder addSpeed (BiConsumer<Double, Double> listener);

    WeaponBuilder addRangeListener (BiConsumer<Double, Double> listener);

}
