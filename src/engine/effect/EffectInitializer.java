package engine.effect;

import engine.TypeInitializer;
import engine.observer.ObservableProperty;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public interface EffectInitializer extends TypeInitializer {

    ObservableProperty<String> getTriggerClass ();

    ObservableProperty<String> getTriggerConditionGroovy ();

    ObservableProperty<String> getEffectGroovy ();

}
