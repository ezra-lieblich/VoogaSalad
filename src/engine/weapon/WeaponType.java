package engine.weapon;

import engine.AbstractType;
import engine.Type;
import engine.TypeInitializer;

public class WeaponType extends AbstractType implements Weapon {
    


    private double fireRate;
    private String trajectory;
    private String effect;
    private double speed;
    private double range;
    
    
    protected WeaponType (TypeInitializer typeBuilder) {
        super(typeBuilder);
        // TODO Auto-generated constructor stub
    }
    
//    WeaponType() {
//        this.fireRate = Double.parseDouble(getResources("WeaponTypeFireRate"));
//        this.trajectory = getResources("WeaponTypePath");
//        this.effect = getResources("WeaponTypeEffect");
//        this.speed = Double.parseDouble(getResources("WeaponTypeSpeed"));
//        this.range = Double.parseDouble(getResources("WeaponTypeRange"));
//    }
    
    @Override
    public double getFireRate () {
        return fireRate;
    }

    @Override
    public void setFireRate (double fireRate) {
        this.fireRate = fireRate;
    }

    
    @Override
    public String getPath () {
        return trajectory;
    }

    @Override
    public void setPath (String path) {
        this.trajectory = path;
    }

    @Override
    public String getEffect () {
        return effect;
    }

    @Override
    public void setEffect (String effect) {
        this.effect = effect;
    }

    @Override
    public double getSpeed () {
        return speed;
    }

    @Override
    public void setSpeed (double speed) {
        this.speed = speed;
    }
    /* (non-Javadoc)
     * @see engine.weapon.Weapon#getRange()
     */
    @Override
    public double getRange () {
        return range;
    }

    @Override
    public void setRange (double range) {
        this.range = range;
    }

}
