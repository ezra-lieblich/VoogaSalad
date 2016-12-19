// This entire file is part of my masterpiece.
// Sean Hudson
package gameplayer.model.effect.factory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import engine.effect.Effect;
import engine.effect.EffectData;
import engine.effect.ReflectionException;
import gameplayer.model.effect.GameEffect;
import gameplayer.model.effect.GroovyExecutor;

/**
 * This class is part of my masterpiece since it provides an extensible way for creating different GameEffects,
 * which was part of the Best Design Idea award.
 * 
 * Abstract factory Pattern - This class Makes use of the abstract factory pattern to handle the creation of effects.
 * Each subclass can customize the input that is added to the GameEffect
 * 
 * Steams - This class provides a good example of Steams, where I am able to accomplish complex iterations in one line of code.
 * 
 * 
 * This class provides a flexible and extensible way of handling GameEffect creation
 * that allows the subclasses to customize the creation process.
 * 
 * See CollisionEffectFactory for an example on how to extend this class.
 * 
 * @author seanhudson
 *
 */
public abstract class AbstractEffectFactory {
    public static final Class<? extends Annotation> EFFECT_DATA = EffectData.class;
    private static final String INVALID_FIELD = "The effect factory does not contain the specified field.";
    
    private String triggerVariableName;
    private String encompasingClassVariableName;
    private Map<String, Object> effectAccessibleData;
    
    AbstractEffectFactory(String triggerVariableName, String encompasingClassVariableName) {
        this.effectAccessibleData = new HashMap<String, Object>();
        this.triggerVariableName = triggerVariableName;
        this.encompasingClassVariableName = encompasingClassVariableName;
        loadEffectParameters(triggerVariableName, encompasingClassVariableName);
    }
    
    private void loadEffectParameters(String... parameterNames) {
        Stream.of(parameterNames).forEach(a -> effectAccessibleData.put(a, new Object()));
    }
    
    public GameEffect create(Effect effect) {
        GroovyExecutor groovyExecutor = new GroovyExecutor();
        addEffectAccessibleData(groovyExecutor);
        return new GameEffect(effect, groovyExecutor, triggerVariableName, encompasingClassVariableName);
    }
    
    public Collection<String> getVariableNames() {
        return effectAccessibleData.keySet();
    }
    
    private void addEffectAccessibleData(GroovyExecutor groovyExecutor) {
        effectAccessibleData.entrySet().forEach(a -> groovyExecutor.addVariable(a.getKey(), a.getValue()));
    }
    
    protected void loadInSpecificValues() {
        Stream.of(getClass().getDeclaredFields()).filter(a -> a.isAnnotationPresent(EFFECT_DATA)).forEach(this::loadSpecificDataIntoMap);
    }    
    
    protected void loadSpecificDataIntoMap(Field variableField) {
        try {
            effectAccessibleData.put(variableField.getName(), variableField.get(this));
        }
        catch (IllegalArgumentException | IllegalAccessException e) {
            throw new ReflectionException(e, INVALID_FIELD);
        }

    }
        
}
