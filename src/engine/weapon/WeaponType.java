package engine.weapon;

import engine.AbstractType;
import engine.Type;
import engine.TypeInitializer;
import engine.observer.ObservableProperty;

public class WeaponType extends AbstractType implements Weapon {
    


    private ObservableProperty<Double> fireRate;
    private ObservableProperty<String> trajectory;
    private ObservableProperty<String> effect;
    private ObservableProperty<Double> speed;
    private ObservableProperty<Double> range;
    
    
    protected WeaponType (WeaponInitializer weaponInitializer) {
        super(weaponInitializer);
        // TODO Auto-generated constructor stub
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
    /* (non-Javadoc)
     * @see engine.weapon.Weapon#getRange()
     */
    @Override
    public double getRange () {
        return range.getProperty();
    }

    @Override
    public void setRange (double range) {
        this.range.setProperty(range);
    }

}
