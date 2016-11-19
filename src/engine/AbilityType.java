package engine;

public class AbilityType extends Entity {
    private String effect;
    private double rate;
    
    AbilityType() {
        this.effect = "";
        this.rate = 0;
    }

    public String getEffect () {
        return effect;
    }

    public void setEffect (String effect) {
        this.effect = effect;
    }

    public double getRate () {
        return rate;
    }

    public void setRate (double rate) {
        this.rate = rate;
    }
    
}
