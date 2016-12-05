package engine.effect;

import java.lang.reflect.Method;
import java.util.List;
import engine.observer.ObservableList;
import engine.observer.ObservableProperty;

public class Effect {
    private ObservableProperty<String> triggerClass;
    private ObservableList<Condition> triggerConditions;
    private ObservableProperty<Class<?>> destinationClass;
    private ObservableList<Condition> destinationConditions;
    private ObservableProperty<Method> destinationMethod;
    private ObservableProperty<Object> value;
    
    
    
    public void setTriggerClass (ObservableProperty<String> triggerClass) {
        this.triggerClass = triggerClass;
    }
    public void setTriggerConditions (ObservableList<Condition> triggerConditions) {
        this.triggerConditions = triggerConditions;
    }
    public void setDestinationClass (ObservableProperty<Class<?>> destinationClass) {
        this.destinationClass = destinationClass;
    }
    public void setDestinationConditions (ObservableList<Condition> destinationConditions) {
        this.destinationConditions = destinationConditions;
    }
    public void setDestinationMethod (ObservableProperty<Method> destinationMethod) {
        this.destinationMethod = destinationMethod;
    }
    public void setValue (ObservableProperty<Object> value) {
        this.value = value;
    }
    
//    private Class<?> triggerClass;
//    private List<Condition> triggerConditions;
//    private Class<?> destinationClass;
//    private List<Condition> destinationConditions;
//    private Method destinationMethod;
//    private Object value;
    
}
