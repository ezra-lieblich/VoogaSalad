package engine.ability;

import engine.AbstractType;
import engine.TypeInitializer;

public class AbilityType extends AbstractType implements Ability {

    private String effect;
    private double rate;
    
    protected AbilityType (TypeInitializer typeBuilder) {
        super(typeBuilder);
        // TODO Auto-generated constructor stub
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
