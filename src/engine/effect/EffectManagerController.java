package engine.effect;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;

public class EffectManagerController {
    private EffectManager effectManager;
    private Enemy enemy;
    
    EffectManagerController() {
        this.effectManager = new EffectManager();
        this.enemy = new Enemy();
    }
    
    public List<String> getTriggers() {
        return effectManager.getAnnotatedClasses();
    }
    
    public int setTrigger(EffectView effectView, String trigger) {
        Effect newEffect = new Effect();
        ObservableProperty<String> observableTrigger = new ObservableObjectProperty<String>(trigger);
        observableTrigger.addListener((oldValue, newValue) -> effectView.updateTriggerConditions(effectManager.getAnnotatedClassMethods(newValue).stream().map(Method::getName).collect(Collectors.toList()) ));
        newEffect.setTriggerClass(new ObservableObjectProperty<String>(trigger));
        enemy.addEffect(newEffect);
        return enemy.getEffectsSize() - 1;
        //effectManager.getAnnotatedClassMethods(trigger)
    }
}
