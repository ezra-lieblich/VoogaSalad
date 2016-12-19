package engine.effect;

import engine.TypeBuilder;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public interface EffectBuilder extends TypeBuilder<Effect, EffectBuilder>, BindableEffect { //TODO - Add bindable interface

    EffectBuilder buildTriggerClass (String triggerClass);

    EffectBuilder buildTriggerConditionGroovy (String triggerConditionGroovy);

    EffectBuilder buildEffectGroovy (String effectGroovy);

}
