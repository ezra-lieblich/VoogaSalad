package engine.effect;

import java.util.List;

public class EffectManagerController {
    private EffectManager effectManager;
    
    EffectManagerController() {
        this.effectManager = new EffectManager();
    }
    
    public List<String> getTriggers() {
        return effectManager.getAnnotatedClasses();
    }
}
