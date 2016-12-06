package engine.effect;

import java.lang.reflect.Method;
import java.util.List;
import engine.AbstractType;
import engine.TypeInitializer;
import engine.observer.ObservableList;
import engine.observer.ObservableProperty;

public class EffectType extends AbstractType implements Effect {

    private EffectParticipant trigger;
    private EffectParticipant destination;
    
    protected EffectType (EffectInitializer typeBuilder) {
        super(typeBuilder);
        this.trigger = typeBuilder.getTrigger();
        this.destination = typeBuilder.getDestination();
    }

    
    public EffectParticipant getTrigger() {
        return trigger;
    }
    
    public EffectParticipant getDestination() {
        return destination;
    }
    
//    private Class<?> triggerClass;
//    private List<Condition> triggerConditions;
//    private Class<?> destinationClass;
//    private List<Condition> destinationConditions;
//    private Method destinationMethod;
//    private Object value;
    
}
