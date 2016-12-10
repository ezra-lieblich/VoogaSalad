package engine.effect.player;

import java.util.function.BiConsumer;
import engine.effect.EffectData;
import engine.effect.Enemy;

public class CollisionEffectFactory extends AbstractEffectFactory {
    public static final String TRIGGER_NAME = "collider";
    public static final String ENCOMPASSING_CLASS_NAME = "myself";

    @EffectData
    private Object collider;
    @EffectData
    private Object myself;
    @EffectData
    private Enemy foe = new Enemy();
    
    public CollisionEffectFactory () {
        super(TRIGGER_NAME, ENCOMPASSING_CLASS_NAME);
    }



}
