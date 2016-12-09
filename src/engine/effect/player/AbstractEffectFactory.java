package engine.effect.player;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import engine.effect.Effect;

public abstract class AbstractEffectFactory {
    
    private final String TRIGGER_NAME;
    private final String ENCOMPASSING_CLASS_NAME;
    
    private Map<String, Object> effectAccessibleData;
    
    AbstractEffectFactory(String triggerVariableName, String encompasssingClassName) {
        this.TRIGGER_NAME = triggerVariableName;
        this.ENCOMPASSING_CLASS_NAME = encompasssingClassName;
        this.effectAccessibleData = new HashMap<String, Object>();
        loadDataIntoMap();

    }
    
    public GameEffect create(Effect effect) {
        GroovyExecutor groovyExecutor = new GroovyExecutor();
        addEffectAccessibleData(groovyExecutor);
        return new GameEffect(effect, groovyExecutor);
    }
    
    private void loadDataIntoMap() {
        effectAccessibleData.put(TRIGGER_NAME, null);
        effectAccessibleData.put(ENCOMPASSING_CLASS_NAME, null);
    }
    
    private void addEffectAccessibleData(GroovyExecutor groovyExecutor) {
        effectAccessibleData.entrySet().forEach(a -> groovyExecutor.addVariable(a.getKey(), a.getValue()));
    }
    
    protected void loadSpecificDataIntoMap(String key, Object value) {
        effectAccessibleData.put(key, value);
    }
        
}
