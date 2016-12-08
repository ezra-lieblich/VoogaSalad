package engine.effect;

import java.lang.reflect.Method;
import java.util.List;
import engine.TypeBuilder;
import engine.tower.BindableTower;
import engine.tower.Tower;
import engine.tower.TowerBuilder;


public interface EffectBuilder extends TypeBuilder<Effect, EffectBuilder>, BindableEffect { //TODO - Add bindable interface

    EffectBuilder BuildTriggerClass (Class<?> triggerClass);

    EffectBuilder BuildTriggerConditions (List<EffectFunction> participantConditions);

    EffectBuilder BuildTriggerConditions (EffectFunction ... participantConditions);

    EffectBuilder BuildTriggerMethod (Method triggerMethod);

    EffectBuilder BuildDestinationClass (Class<?> triggerClass);

    EffectBuilder BuildDestinationConditions (List<EffectFunction> participantConditions);

    EffectBuilder BuildDestinationConditions (EffectFunction ... participantConditions);

    EffectBuilder BuildDestinationMethod (Method triggerMethod);

}
