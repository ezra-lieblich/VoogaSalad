package engine.effect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import engine.Manager;


public interface EffectManager extends Manager<Effect> {

    List<Method> getAnnotatedClassMethods (String className);

    Collection<Class<?>> getAnnotatedClasses ();
    
    List<Field> getAnnotatedDataObjects ();
    
    void addActiveClassListener (BiConsumer<String, String> listener);
    
    void setActiveClass(String activeClass);

}
