package engine.effect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import engine.Manager;


public interface EffectManager extends Manager<Effect> {

    void add (Class<?> annotatedClass);

    <T extends Annotation> List<Method> generateAnnotatedMethods (Class<?> annotatedClass,
                                                                  Class<T> annotationType);

    List<Method> getAnnotatedClassMethods (String className);

    List<String> getAnnotatedClasses ();

}
