package engine.effect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import engine.AbstractTypeBuilder;
import engine.observer.ObservableList;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;


public class EffectTypeBuilder extends AbstractTypeBuilder<Effect, EffectBuilder> implements EffectBuilder, EffectInitializer {
    
    public static final String DEFAULT_NAME = "New Enemy";
    public static final String DEFAULT_IMAGE_PATH = "Images/butterfly.png";
    public static final double DEFAULT_SIZE = 1;
    public static final Class<?> DEFAULT_TRIGGER_CLASS = Enemy.class;
    public static final EffectFunction[] DEFAULT_TRIGGER_CONDITIONS = new EffectFunction[]{};
    public static final Method DEFAULT_TRIGGER_METHOD = null; //TODO-MAKE NOT NULL
    public static final Class<?> DEFAULT_DESTINATION_CLASS = Enemy.class;
    public static final EffectTypeFunction[] DEFAULT_DESTINATION_CONDITIONS = new EffectTypeFunction[]{};
    public static final Method DEFAULT_DESTINATION_METHOD = null; //TODO-MAKE NOT NULL

    private BindableEffectParticipant trigger;
    private BindableEffectParticipant destination;

    public EffectTypeBuilder () {
        super(DEFAULT_NAME, DEFAULT_IMAGE_PATH, DEFAULT_SIZE);
    }

    @Override
    public EffectBuilder BuildTriggerClass(Class<?> triggerClass) {
        trigger.setParticipantClass(triggerClass);
        return this;
    }
    
    @Override
    public EffectBuilder BuildTriggerConditions(List<EffectFunction> participantConditions) {
        trigger.setParticipantConditions(participantConditions);
        return this;
    }
    
    @Override
    public EffectBuilder BuildTriggerConditions(EffectFunction... participantConditions) {
        return BuildTriggerConditions(Arrays.stream(participantConditions).collect(Collectors.toList()));
    }
    
    @Override
    public EffectBuilder BuildTriggerMethod(Method triggerMethod) {
        trigger.setParticipantMethod(triggerMethod);
        return this;
    }
    
    @Override
    public EffectBuilder BuildDestinationClass(Class<?> triggerClass) {
        destination.setParticipantClass(triggerClass);
        return this;
    }
    
    @Override
    public EffectBuilder BuildDestinationConditions(List<EffectFunction> participantConditions) {
        destination.setParticipantConditions(participantConditions);
        return this;
    }
    
    @Override
    public EffectBuilder BuildDestinationConditions(EffectFunction... participantConditions) {
        return BuildTriggerConditions(Arrays.stream(participantConditions).collect(Collectors.toList()));
    }
    
    @Override
    public EffectBuilder BuildDestinationMethod(Method triggerMethod) {
        destination.setParticipantMethod(triggerMethod);
        return this;
    }
    
    @Override
    public EffectBuilder addTriggerClassListener (BiConsumer<Class<?>, Class<?>> listener) {
        trigger.addParticipantClassListener(listener);
        return this;
    }

    @Override
    public EffectBuilder addTriggerConditionsListener (BiConsumer<List<EffectFunction>, List<EffectFunction>> listener) {
        trigger.addParticipantConditionsListener(listener);
        return this;   
        }

    @Override
    public EffectBuilder addTriggerMethodListener (BiConsumer<Method, Method> listener) {
        trigger.addParticipantMethodListener(listener);
        return this;
    }

    @Override
    public EffectBuilder removeTriggerClassListener (BiConsumer<Class<?>, Class<?>> listener) {
        trigger.removeParticipantClassListener(listener);
        return this;
    }

    @Override
    public EffectBuilder removeTriggerConditionsListener (BiConsumer<List<EffectFunction>, List<EffectFunction>> listener) {
        trigger.removeParticipantConditionsListener(listener);
        return this;
    }

    @Override
    public EffectBuilder removeTriggerMethodListener (BiConsumer<Method, Method> listener) {
        trigger.removeParticipantMethodListener(listener);
        return this;
    }
    
    @Override
    public EffectBuilder addDestinationClassListener (BiConsumer<Class<?>, Class<?>> listener) {
        destination.addParticipantClassListener(listener);
        return this;
    }

    @Override
    public EffectBuilder addDestinationConditionsListener (BiConsumer<List<EffectFunction>, List<EffectFunction>> listener) {
        destination.addParticipantConditionsListener(listener);
        return this;   
        }

    @Override
    public EffectBuilder addDestinationMethodListener (BiConsumer<Method, Method> listener) {
        destination.addParticipantMethodListener(listener);
        return this;
    }

    @Override
    public EffectBuilder removeDestinationClassListener (BiConsumer<Class<?>, Class<?>> listener) {
        destination.removeParticipantClassListener(listener);
        return this;
    }

    @Override
    public EffectBuilder removeDestinationConditionsListener (BiConsumer<List<EffectFunction>, List<EffectFunction>> listener) {
        destination.removeParticipantConditionsListener(listener);
        return this;
    }

    @Override
    public EffectBuilder removeDestinationMethodListener (BiConsumer<Method, Method> listener) {
        destination.removeParticipantMethodListener(listener);
        return this;
    }

    @Override
    public EffectParticipant getTrigger() {
        return trigger;
    }
    
    @Override
    public EffectParticipant getDestination() {
        return trigger;
    }
    
    @Override
    protected Effect create () {
        return new EffectType(this);
    }

    @Override
    protected void restoreTypeDefaults () {
        this.trigger = new EffectTypeParticipant(DEFAULT_TRIGGER_CLASS, Arrays.stream(DEFAULT_TRIGGER_CONDITIONS).collect(Collectors.toList()), DEFAULT_TRIGGER_METHOD);
        this.destination = new EffectTypeParticipant(DEFAULT_DESTINATION_CLASS, Arrays.stream(DEFAULT_DESTINATION_CONDITIONS).collect(Collectors.toList()), DEFAULT_DESTINATION_METHOD);
    }

    @Override
    protected EffectBuilder getThis () {
        return this;
    }

}
