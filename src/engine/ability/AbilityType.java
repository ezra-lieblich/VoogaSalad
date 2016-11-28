package engine.ability;

import engine.AbstractType;
import engine.TypeInitializer;
import engine.observer.ObservableProperty;

public class AbilityType extends AbstractType implements Ability {

    private ObservableProperty<Double> rate;
    private ObservableProperty<String> effect;
    
    protected AbilityType (AbilityBuilder abilityBuilder) {
        super(abilityBuilder);
        this.rate = abilityBuilder.getFireRate();
        this.effect = abilityBuilder.getEffect();
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
    public double getRate () {
        return rate.getProperty();
    }

    @Override
    public void setRate (double rate) {
        this.rate.setProperty(rate);
    }
    
}
