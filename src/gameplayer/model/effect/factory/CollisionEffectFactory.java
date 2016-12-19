// This entire file is part of my masterpiece.
// Sean Hudson
package gameplayer.model.effect.factory;

import engine.effect.EffectData;
import gameplayer.model.GamePlayData;

/**
 * This class provides a concrete implementation on how to extend the AbstractEffectFactory class. In order for the Authoring Environment to see what EffectData variables
 * there are the variables have to be made into instance variables or else the reflection search wont be able to find them.
 * 
 * I had to make the instance variables protect so as to allow access to them from reflection calls in the Abstract class. I could have moved the reflection
 * call down into the subclasses, but that would create a lot of code redundancy and it would be better to abstract that complex operation into the abstract class.
 * I don't like to make instance variables protected, but I did so to prevent redundant code. I moved the Effect factories into their own sub-package to limit access to
 * the protected variables. 
 * 
 * 
 * This class allows for the creation of GameEffects that contain collision effect data.
 * 
 * @author seanhudson
 *
 */
public class CollisionEffectFactory extends AbstractEffectFactory {
    public static final String TRIGGER_NAME = "collider";
    public static final String ENCOMPASSING_CLASS_NAME = "myself";

    @EffectData
    protected Object collider;
    
    @EffectData
    protected Object myself;
    
    @EffectData
    protected GamePlayData data;
    
    public CollisionEffectFactory (GamePlayData data) {
        super(TRIGGER_NAME, ENCOMPASSING_CLASS_NAME);
        this.data = data;
        loadInSpecificValues();
        
    }

}
