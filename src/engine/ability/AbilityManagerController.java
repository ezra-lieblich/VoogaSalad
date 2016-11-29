package engine.ability;

import engine.ManagerController;

public interface AbilityManagerController extends ManagerController<AbilityManager, AbilityBuilder, Ability> {
    
    public void setRate (int abilityID, double abilityRate);
    
    public void setEffect (int abilityID, String abilityEffect);
    
    public double getRate (int abilityID);
    
    public String getEffect (int abilityID);

}
