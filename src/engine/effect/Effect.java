package engine.effect;

import engine.Type;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public interface Effect extends Type{
    
    String getTriggerClass();
    
    String getTriggerConditionGroovy();
    
    String getEffectGroovy();
    
    void setTriggerClass(String triggerClass);
    
    void setTriggerConditionGroovy(String triggerConditionGroovy);
    
    void setEffectGroovy(String effectGroovy);

}
