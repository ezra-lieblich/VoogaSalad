package engine.ability;

import engine.AbstractTypeManagerController;
import engine.ability.AbilityManager;

public class AbilityTypeManagerController extends AbstractTypeManagerController<AbilityManager, AbilityBuilder, Ability> implements AbilityManagerController {
    
    AbilityTypeManagerController(AbilityManager abilityManager) {
        super(abilityManager, new AbilityTypeBuilder());
    }

    @Override
    protected AbilityBuilder constructTypeProperties (engine.AbstractTypeManagerController.ViewFiller viewFiller,
                                                      AbilityBuilder typeBuilder) {
        return typeBuilder
                .addEffectListener((oldValue, newValue) -> viewFiller
                                   .updateEffect(newValue))
                .addRateListener((oldValue, newValue) -> viewFiller
                                   .updateRate(newValue));
    }

    @Override
    public void setRate (int abilityID, double abilityRate) {
        getTypeManager().getEntity(abilityID).setRate(abilityRate);
    }

    @Override
    public void setEffect (int abilityID, String abilityEffect) {
        getTypeManager().getEntity(abilityID).setEffect(abilityEffect);        
    }

    @Override
    public double getRate (int abilityID) {
        return getTypeManager().getEntity(abilityID).getRate();        
    }

    @Override
    public String getEffect (int abilityID) {
        return getTypeManager().getEntity(abilityID).getEffect();        
    }
}