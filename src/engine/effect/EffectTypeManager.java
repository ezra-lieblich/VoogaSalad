package engine.effect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import engine.AbstractTypeManager;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public class EffectTypeManager extends AbstractTypeManager<Effect> implements EffectManager {
    private Map<Class<?>, List<Method>> annotatedClassMethods; //Return type : methods of that type
    private List<Field> effectAccessibleData;
    private ObservableProperty<Class<?>> activeClass;
    
    EffectTypeManager(Map<Class<?>, List<Method>> annotatedClassMethods, List<Field> effectAccessibleData) {
        this.annotatedClassMethods = annotatedClassMethods;
        this.effectAccessibleData = effectAccessibleData;
        this.activeClass = new ObservableObjectProperty<Class<?>>(null);
    }
    
    @Override
    public void setActiveClass(Class<?> activeClass) {
        this.activeClass.setProperty(activeClass);
    }
    
    @Override
    public void addActiveClassListener (BiConsumer<Class<?>, Class<?>> listener) {
        activeClass.addListener(listener);
    }
    
    @Override
    public Collection<Class<?>> getAnnotatedClasses() {
        return annotatedClassMethods.keySet();
    }
    
    @Override
    public List<Method> getAnnotatedClassMethods(Class<?> className) {
        return annotatedClassMethods.get(className);
    }

    @Override
    public List<Field> getAnnotatedDataObjects () {
        return effectAccessibleData;
    }

}
