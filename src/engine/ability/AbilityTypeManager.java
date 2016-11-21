package engine.ability;

import engine.AbstractTypeManager;

public class AbilityTypeManager extends AbstractTypeManager<Ability> implements Ability {

    @Override
    protected Ability createInstance () {
        return new AbilityType();
    }

    @Override
    public String getEffect () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setEffect (String effect) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public double getRate () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setRate (double rate) {
        // TODO Auto-generated method stub
        
    }

}
