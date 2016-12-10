package engine.effect.player;

import java.util.function.BiConsumer;
import engine.effect.EffectData;

public class CollisionEffectFactory extends AbstractEffectFactory {
    @EffectData
    public static final String TRIGGER_NAME = "collider";
    @EffectData
    public static final String ENCOMPASSING_CLASS_NAME = "this";
    
    CollisionEffectFactory () {
        super(TRIGGER_NAME, ENCOMPASSING_CLASS_NAME);
    }



}
