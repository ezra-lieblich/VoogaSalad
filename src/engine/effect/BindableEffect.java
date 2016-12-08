package engine.effect;

import java.lang.reflect.Method;
import java.util.List;
import java.util.function.BiConsumer;
import engine.effect.depreciated.EffectFunction;


public interface BindableEffect {

    EffectBuilder addTriggerClassListener (BiConsumer<String, String> listener);

    EffectBuilder addTriggerConditionGroovyListener (BiConsumer<String, String> listener);

    EffectBuilder addEffectGroovyListener (BiConsumer<String, String> listener);

    EffectBuilder removeTriggerClassListener (BiConsumer<String, String> listener);

    EffectBuilder removeTriggerConditionGroovyListener (BiConsumer<String, String> listener);

    EffectBuilder removeEffectGroovyListener (BiConsumer<String, String> listener);

}
