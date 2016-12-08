package engine.effect;

import engine.Type;

public interface Effect extends Type{
    
    EffectParticipant getTrigger();
    
    EffectParticipant getDestination();

}
