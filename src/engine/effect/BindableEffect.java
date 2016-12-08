package engine.effect;

import java.lang.reflect.Method;
import java.util.List;
import java.util.function.BiConsumer;


public interface BindableEffect {

    EffectBuilder addTriggerClassListener (BiConsumer<Class<?>, Class<?>> listener);

    EffectBuilder addTriggerConditionsListener (BiConsumer<List<EffectFunction>, List<EffectFunction>> listener);

    EffectBuilder addTriggerMethodListener (BiConsumer<Method, Method> listener);

    EffectBuilder removeTriggerClassListener (BiConsumer<Class<?>, Class<?>> listener);

    EffectBuilder removeTriggerConditionsListener (BiConsumer<List<EffectFunction>, List<EffectFunction>> listener);

    EffectBuilder removeTriggerMethodListener (BiConsumer<Method, Method> listener);

    EffectBuilder addDestinationClassListener (BiConsumer<Class<?>, Class<?>> listener);

    EffectBuilder addDestinationConditionsListener (BiConsumer<List<EffectFunction>, List<EffectFunction>> listener);

    EffectBuilder addDestinationMethodListener (BiConsumer<Method, Method> listener);

    EffectBuilder removeDestinationClassListener (BiConsumer<Class<?>, Class<?>> listener);

    EffectBuilder removeDestinationConditionsListener (BiConsumer<List<EffectFunction>, List<EffectFunction>> listener);

    EffectBuilder removeDestinationMethodListener (BiConsumer<Method, Method> listener);

}
