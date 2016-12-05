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

@interface EffectClass {
}

@Retention(RetentionPolicy.RUNTIME) //.RUNTIME)
@interface EffectMethod {
    
}

public class EffectManager {
    //private Map<String, Class<?>> annotatedClasses;
    private Map<String, List<Method>> annotatedClassMethods; //Return type : methods of that type
    
    EffectManager() {
        annotatedClassMethods = new HashMap<String, List<Method>>();
        add(Enemy.class);
    }
    
    public void add(Class<?> annotatedClass) {
        annotatedClassMethods.put(annotatedClass.getName(), getAnnotatedMethods(annotatedClass, EffectMethod.class));
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
    
    public <T extends Annotation> List<Method> getAnnotatedMethods(Class<?> annotatedClass, Class<T> annotationType) {
        return Stream.of(annotatedClass.getMethods()).filter(a -> a.isAnnotationPresent(annotationType)).collect(Collectors.toList());
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
