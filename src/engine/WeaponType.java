package engine;

public class WeaponType extends Entity{
    private double fireRate;
    private String path;
    private String effect;
    private double speed;
    private double range;
    
    WeaponType() {
        this.fireRate = 0;
        this.path = "straight";
        this.effect = "";
        this.speed = 0;
        this.range = 0;
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
