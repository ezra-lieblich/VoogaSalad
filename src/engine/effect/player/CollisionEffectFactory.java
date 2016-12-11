package engine.effect.player;

import java.util.function.BiConsumer;

public class CollisionEffectFactory extends AbstractEffectFactory {
    public static final String TRIGGER_NAME = "collider";
    public static final String ENCOMPASSING_CLASS_NAME = "this";
    
    CollisionEffectFactory () {
        super(TRIGGER_NAME, ENCOMPASSING_CLASS_NAME);
    }



}
