package engine.weapon;

import engine.AbstractType;

public class WeaponType extends AbstractType{
    private double fireRate;
    private String path;
    private String effect;
    private double speed;
    private double range;
    
    WeaponType() {
        this.fireRate = Double.parseDouble(getResources("WeaponTypeFireRate"));
        this.path = getResources("WeaponTypePath");
        this.effect = getResources("WeaponTypeEffect");
        this.speed = Double.parseDouble(getResources("WeaponTypeSpeed"));
        this.range = Double.parseDouble(getResources("WeaponTypeRange"));
    }
    
    public double getFireRate () {
        return fireRate;
    }
    public void setFireRate (double fireRate) {
        this.fireRate = fireRate;
    }
    public String getPath () {
        return path;
    }
    public void setPath (String path) {
        this.path = path;
    }
    public String getEffect () {
        return effect;
    }
    public void setEffect (String effect) {
        this.effect = effect;
    }
    public double getSpeed () {
        return speed;
    }
    public void setSpeed (double speed) {
        this.speed = speed;
    }
    public double getRange () {
        return range;
    }
    public void setRange (double range) {
        this.range = range;
    }
    
}
