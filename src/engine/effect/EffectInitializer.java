package engine.effect;

import engine.TypeInitializer;

public interface EffectInitializer extends TypeInitializer{

    EffectParticipant getTrigger ();

    EffectParticipant getDestination ();

}
