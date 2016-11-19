package engine;

public class AbilityTypeManager extends EntityManager<AbilityType> {

    @Override
    protected AbilityType createInstance () {
        return new AbilityType();
    }

}
