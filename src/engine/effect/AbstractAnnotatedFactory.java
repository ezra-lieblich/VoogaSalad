package engine.effect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

public class AbstractAnnotatedFactory<E extends Executable, U extends Annotation> {
    private Function<Class<U>, Collection<E>> grabber;
    private grabber2
    
    AbstractAnnotatedFactory(Function<Class<U>, Collection<E>> grabber) {
        this.grabber = grabber;
    }
    
    public Map<Class<?>, List<Method>> create (Class<? extends Annotation> annotation) {
        return create(annotation, "engine.effect");
    }
    
    public Map<Class<?>, List<E>> create(Class<U> methodAnnotation, String packageName) {
        Reflections reflections = new Reflections(packageName, new MethodAnnotationsScanner());
        Consumer<? extends Reflections> test = Reflections::getMethodsAnnotatedWith;
        Function<? extends Annotation, Collection<U>> tesinaf = Reflections::getMethodsAnnotatedWith;
        //reflections.getMethodsAnnotatedWith(annotation).stream().collect(Collectors.toMap( a -> a.toString(), a -> a));
        return grabber.apply(methodAnnotation).stream().collect(Collectors.groupingBy( a -> a.getDeclaringClass()));
    }
}
