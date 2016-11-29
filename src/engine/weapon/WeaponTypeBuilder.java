package engine.weapon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import engine.AbstractTypeBuilder;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.observer.ObservableList;
import engine.observer.ObservableListProperty;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;
import engine.tower.Tower;
import engine.tower.TowerType;
import engine.weapon.Weapon;

public class WeaponTypeBuilder extends AbstractTypeBuilder<Weapon, WeaponBuilder> implements WeaponBuilder, WeaponInitializer {
    
     public static final String DEFAULT_NAME = "New Weapon";
     public static final String DEFAULT_IMAGE_PATH = "Images.penguin.jpg";
     public static final double DEFAULT_SIZE = 1;
     public static final List<Integer> DEFAULT_WEAPONS = Arrays.asList(new Integer[]{});
     public static final double DEFAULT_FIRE_RATE = 2;
     public static final String DEFAULT_TRAJECTORY = "Straight";
     public static final String DEFAULT_EFFECT = "";
     public static final double DEFAULT_SPEED = 10;
     public static final double DEFAULT_RANGE = 50;
     
     private ObservableList<Integer> targets;
     private ObservableProperty<Double> fireRate;
     private ObservableProperty<String> trajectory;
     private ObservableProperty<String> effect;
     private ObservableProperty<Double> speed;
     private ObservableProperty<Double> range;
     
     public WeaponTypeBuilder() {
         super(DEFAULT_NAME, DEFAULT_IMAGE_PATH, DEFAULT_SIZE);
     }
    

     @Override
     public WeaponBuilder buildTargets (Integer ... targets) {
         return buildTargets(Arrays.asList(targets));
     }

     @Override
     public WeaponBuilder buildTargets (List<Integer> targets) {
         this.targets.setProperty(targets);
         return this;
     }
     
    @Override
    public WeaponBuilder buildFireRate(double fireRate) {
        this.fireRate.setProperty(fireRate);
        return this;
    }
    
    @Override
    public WeaponBuilder buildTrajectory(String trajectory) {
        this.trajectory.setProperty(trajectory);
        return this;
    }
    
    @Override
    public WeaponBuilder buildEffect(String effect) {
        this.effect.setProperty(effect);
        return this;
    }

    @Override
    public WeaponBuilder buildSpeed(double speed) {
        this.speed.setProperty(speed);
        return this;
    }
    
    @Override
    public WeaponBuilder buildRange(double range) {
        this.range.setProperty(range);
        return this;
    }
    
    @Override
    protected Weapon create () {
        return new WeaponType(this);
    }

    @Override
    public ObservableProperty<Double> getFireRate () {
        return fireRate;
    }

    @Override
    public ObservableProperty<String> getTrajectory () {
        return trajectory;
    }

    @Override
    public ObservableProperty<String> getEffect () {
        return effect;
    }
    
    @Override
    public ObservableProperty<Double> getSpeed () {
        return speed;
    }
    
    @Override
    public ObservableProperty<Double> getRange () {
        return range;
    }

    @Override
    protected void restoreTypeDefaults () {
        this.targets = new ObservableListProperty<Integer>(DEFAULT_WEAPONS);
        this.fireRate = new ObservableObjectProperty<Double>(DEFAULT_FIRE_RATE);
        this.trajectory = new ObservableObjectProperty<String>(DEFAULT_TRAJECTORY);
        this.effect = new ObservableObjectProperty<String>(DEFAULT_EFFECT);
        this.speed = new ObservableObjectProperty<Double>(DEFAULT_SPEED);
        this.range = new ObservableObjectProperty<Double>(DEFAULT_RANGE);
    }

    @Override
    protected WeaponBuilder getThis () {
        return this;
    }
    
    @Override
    public WeaponBuilder addFireRateListener(BiConsumer<Double, Double> listener) {
        fireRate.addListener(listener);
        return this;
    }
    
    @Override
    public WeaponBuilder addTrajectoryListener(BiConsumer<String, String> listener) {
        trajectory.addListener(listener);
        return this;
    }
    
    @Override
    public WeaponBuilder addEffectListener(BiConsumer<String, String> listener) {
        effect.addListener(listener);
        return this;
    }

    @Override
    public WeaponBuilder addSpeed(BiConsumer<Double, Double> listener) {
        speed.addListener(listener);
        return this;
    }
    
    @Override
    public WeaponBuilder addRangeListener(BiConsumer<Double, Double> listener) {
        range.addListener(listener);
        return this;
    }

    @Override
    public ObservableList<Integer> getTargets () {
        return targets;
    }
    
}
