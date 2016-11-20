package engine.tower;

import engine.AbstractType;

public class AbilityType extends AbstractType implements Ability {
    private String effect;
    private double rate;
    
    AbilityType() {
        this.effect = "";
        this.rate = 0;
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
    public double getRate () {
        return rate;
    }

    @Override
    public void setRate (double rate) {
        this.rate = rate;
    }
    
}
