package engine.effect.depreciated;

import engine.effect.EffectMethod;

public class SuperEnemy {
    String testSuperMethods;
    
    @EffectMethod
    public String getEnemy() {
        return testSuperMethods;
    }
}
