package engine.effect.player;

import java.lang.reflect.Method;
import engine.effect.Effect;

public class EffectFactory {

    
    public Object create(Effect effect) {
        Class<?> clazz = effect.getTrigger().getClass();
        Method method = effect.getTrigger().getParticipantMethod();
        method.invoke(obj, args)
    }
}
