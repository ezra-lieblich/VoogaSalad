package engine.effect;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import engine.AbstractTypeManager;

@interface EffectClass {}

@Retention(RetentionPolicy.RUNTIME)
@interface EffectMethod {}

public class EffectTypeManager extends AbstractTypeManager<Effect> implements EffectManager {
    //private Map<String, Class<?>> annotatedClasses;
    private Map<String, List<Method>> annotatedClassMethods; //Return type : methods of that type
    
    EffectTypeManager() {
        annotatedClassMethods = new HashMap<String, List<Method>>();
        add(Enemy.class);
        add(SuperEnemy.class);
    }
    
    /* (non-Javadoc)
     * @see engine.effect.EffectManager#add(java.lang.Class)
     */
    @Override
    public void add(Class<?> annotatedClass) {
        annotatedClassMethods.put(annotatedClass.getName(), generateAnnotatedMethods(annotatedClass, EffectMethod.class));
    }
    
    //TODO - Stream this
//    public List<Method> getAnnotatedMethods(Class<?> annotatedClass) {
//        List<Method> annotatedMethods = new ArrayList<Method>();
//        annotatedClass.getAnnotationsByType(annotationClass)
//        for (Method m : annotatedClass.getMethods()) {   //.getAnnotationsByType(EffectMethod.class)) {
//            if (m.isAnnotationPresent(EffectMethod.class)) {
//               System.out.println(m.toString());
//               annotatedMethods.add(m);
//               //Method testM = new Method("engine.effect.Enemy.setyDirection(int)");
//            }
//         }
//        return annotatedMethods;
//    }
    
    /* (non-Javadoc)
     * @see engine.effect.EffectManager#generateAnnotatedMethods(java.lang.Class, java.lang.Class)
     */
    @Override
    public <T extends Annotation> List<Method> generateAnnotatedMethods(Class<?> annotatedClass, Class<T> annotationType) {
        return Stream.of(annotatedClass.getMethods()).filter(a -> a.isAnnotationPresent(annotationType)).collect(Collectors.toList());
    }
    
    /* (non-Javadoc)
     * @see engine.effect.EffectManager#getAnnotatedClassMethods(java.lang.String)
     */
    @Override
    public List<Method> getAnnotatedClassMethods(String className) {
        return annotatedClassMethods.get(className);
    }
    
//    private <T extends Annotation> List<Method> getAnnotatedMethods(Class<?> annotatedClass, Class<T> annotationType, List<Method> annotatedMethods) {
//        annotatedMethods.addAll(Stream.of(annotatedClass.getMethods()).filter(a -> a.isAnnotationPresent(annotationType)).collect(Collectors.toList()));
//        Class<?> superclass = annotatedClass.getSuperclass();
//        if (superclass != null) {
//            return getAnnotatedMethods(superclass, annotationType, annotatedMethods);
//        } else {
//            return annotatedMethods;
//        }
//    }
    
    /* (non-Javadoc)
     * @see engine.effect.EffectManager#getAnnotatedClasses()
     */
    @Override
    public List<String> getAnnotatedClasses() {
        return new ArrayList<String>(annotatedClassMethods.keySet());
    }
    
    public void printTest() {
        annotatedClassMethods.values().forEach(a -> a.forEach(b -> System.out.println(b.getName())));
    }
    
//    public static void main (String[] args) {
//        EffectManager test = new EffectManager();
//        test.add(Enemy.class);
//        test.printTest();
//    }
}
