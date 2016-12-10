package engine.effect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

public class AnnotatedMethodsFactory {

    
    
    public Map<Class<?>, List<Field>> create(Class<? extends Annotation> annotation, String packageName) {
       Reflections reflections = new Reflections(packageName, new MethodAnnotationsScanner());
       return reflections.getFieldsAnnotatedWith(annotation).stream().collect(Collectors.groupingBy(a -> a.getDeclaringClass()));

    }
    
    
    

    
}
