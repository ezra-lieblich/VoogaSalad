package engine.effect.player;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import engine.effect.Effect;

public class EffectFactory {

    private Map<String, Object> effectAccessibleData;
    
    EffectFactory() {
        effectAccessibleData = new HashMap<String, Object>();
    }
    
    public Object create(Effect effect) {
//        Class<?> clazz = effect.getTrigger().getClass();
//        Method method = effect.getTrigger().getParticipantMethod();
        //method.invoke(obj, args) Accessible
        
        return null;
    }
    
    
}
