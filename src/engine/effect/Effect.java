package engine.effect;

import java.lang.reflect.Method;
import java.util.List;
import engine.observer.ObservableList;
import engine.observer.ObservableProperty;

public class Effect {
//    private ObservableProperty<Class<?>> triggerClass;
//    private ObservableList<Condition> triggerConditions;
//    private ObservableProperty<Class<?>> destinationClass;
//  private ObservableList<Condition> destinationConditions;
//    private ObservableProperty<Method> destinationMethod;
//    private ObservableProperty<Object> value;
    
    private Class<?> triggerClass;
    private List<Condition> triggerConditions;
    private Class<?> destinationClass;
    private List<Condition> destinationConditions;
    private Method destinationMethod;
    private Object value;
    
}
