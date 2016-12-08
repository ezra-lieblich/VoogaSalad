package engine.effect;

import java.lang.reflect.Method;
import java.util.List;

public class EffectTypeFunction implements EffectFunction {
    private Class<?> effectMethodClass;
    private Method effectMethod;
    private List<EffectFunction> parameters;
    private List<Class<?>> parameterTypes;
    private Class<?> returnType;
    
    EffectTypeFunction(String methodName) {
    }
}
