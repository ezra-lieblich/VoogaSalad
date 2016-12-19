package engine.effect;

import engine.AbstractType;
import engine.observer.ObservableProperty;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public class EffectType extends AbstractType implements Effect {

    private ObservableProperty<String> triggerClass;
    private ObservableProperty<String> triggerConditionGroovy;
    private ObservableProperty<String> effectGroovy;
    
    protected EffectType (EffectInitializer effectInitializer) {
        super(effectInitializer);
        this.triggerClass = effectInitializer.getTriggerClass();
        this.triggerConditionGroovy = effectInitializer.getTriggerConditionGroovy();
        this.effectGroovy = effectInitializer.getEffectGroovy();
    }

    @Override
    public String getTriggerClass () {
        return triggerClass.getProperty();
    }

    @Override
    public String getTriggerConditionGroovy () {
        return triggerConditionGroovy.getProperty();
    }

    @Override
    public String getEffectGroovy () {
        return effectGroovy.getProperty();
    }

    @Override
    public void setTriggerClass (String triggerClass) {
        this.triggerClass.setProperty(triggerClass);
    }

    @Override
    public void setTriggerConditionGroovy (String triggerConditionGroovy) {
        this.triggerConditionGroovy.setProperty(triggerConditionGroovy);        
    }

    @Override
    public void setEffectGroovy (String effectGroovy) {
        this.effectGroovy.setProperty(effectGroovy);        
    }
    
}
