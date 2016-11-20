package engine.tower;

import engine.AbstractTypeManager;

public class AbilityTypeManager extends AbstractTypeManager<AbilityType> {

    @Override
    protected AbilityType createInstance () {
        return new AbilityType();
    }

}
