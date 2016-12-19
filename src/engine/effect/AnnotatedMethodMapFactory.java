package engine.effect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public class AnnotatedMethodMapFactory extends AbstractAnnotatedFactory<Method>{
    public static final Class<? extends Annotation> ANNOTATION_TYPE = EffectMethod.class;
    

    @Override
    protected Collection<Method> applySearch (Reflections reflections) {
        return reflections.getMethodsAnnotatedWith(ANNOTATION_TYPE);
    }
    
    @Override
    public Map<Class<?>, List<Method>> create (String packageName) {
        return create(ANNOTATION_TYPE, packageName, new MethodAnnotationsScanner());
    }

}
