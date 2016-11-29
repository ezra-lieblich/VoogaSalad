package engine.weapon;

import java.util.Collections;
import java.util.List;
import engine.AbstractType;
import engine.Type;
import engine.TypeInitializer;
import engine.observer.ObservableList;
import engine.observer.ObservableProperty;

public class WeaponType extends AbstractType implements Weapon {
    
    private ObservableList<Integer> targets;
    private ObservableProperty<Double> fireRate;
    private ObservableProperty<String> trajectory;
    private ObservableProperty<String> effect;
    private ObservableProperty<Double> speed;
    private ObservableProperty<Double> range;
    
    
    protected WeaponType (WeaponInitializer weaponInitializer) {
        super(weaponInitializer);
        this.targets = weaponInitializer.getTargets();
        this.fireRate = weaponInitializer.getFireRate();
        this.trajectory = weaponInitializer.getTrajectory();
        this.effect = weaponInitializer.getEffect();
        this.speed = weaponInitializer.getSpeed();
        this.range = weaponInitializer.getRange();
    }

    @Override
    public void removeTarget (int target) {
        targets.remove(target);
    }

    @Override
    public void addTarget (int target) {
        targets.add(target);
    }

    @Override
    public List<Integer> getTargets () {
        return Collections.unmodifiableList(targets.getProperty());
    }
    
    @Override
    public double getFireRate () {
        return fireRate.getProperty();
    }

    @Override
    public void setFireRate (double fireRate) {
        this.fireRate.setProperty(fireRate);
    }

    
    @Override
    public String getPath () {
        return trajectory.getProperty();
    }

    @Override
    public void setPath (String path) {
        this.trajectory.setProperty(path);
    }

    @Override
    public String getEffect () {
        return effect.getProperty();
    }

    @Override
    public void setEffect (String effect) {
        this.effect.setProperty(effect);
    }

    @Override
    public double getSpeed () {
        return speed.getProperty();
    }

    @Override
    public void setSpeed (double speed) {
        this.speed.setProperty(speed);
    }

    @Override
    public double getRange () {
        return range.getProperty();
    }

    @Override
    public void setRange (double range) {
        this.range.setProperty(range);
    }

}
