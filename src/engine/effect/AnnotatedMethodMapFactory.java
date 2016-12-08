package engine.effect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnotatedMethodMapFactory {
    private Map<String, List<Method>> annotatedClassMethods;
    
    public AnnotatedMethodMapFactory() {
        annotatedClassMethods = new HashMap<String, List<Method>>();
    }
    
//    public Map<String, List<Method>> create() {
//        //Reflections reflections = new Reflections();
//    }
}
