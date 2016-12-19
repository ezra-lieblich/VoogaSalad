package engine.effect;

import java.lang.reflect.Member;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.reflections.Reflections;
import org.reflections.scanners.Scanner;

/**
 * 
 * 
 * @author seanhudson
 *
 * @param <E>
 */
public abstract class AbstractAnnotatedFactory<E extends Member> {
    
    protected Map<Class<?>, List<E>> create(Class<?> methodAnnotation, String packageName, Scanner scanner) {
        Reflections reflections = new Reflections(packageName, scanner);
        return applySearch(reflections).stream().collect(Collectors.groupingBy( a -> a.getDeclaringClass()));
    }
    
    public abstract Map<Class<?>, List<E>> create (String packageName);
    
    protected abstract Collection<E> applySearch(Reflections reflections);
}