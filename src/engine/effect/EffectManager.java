package engine.effect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import engine.Manager;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public interface EffectManager extends Manager<Effect> {

    List<Method> getAnnotatedClassMethods (Class<?> className);

    Collection<Class<?>> getAnnotatedClasses ();
    
    List<Field> getAnnotatedDataObjects ();
    
    void addActiveClassListener (BiConsumer<Class<?>, Class<?>> listener);
    
    void setActiveClass(Class<?> activeClass);

}
