package engine.effect.player;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import engine.observer.ObservableProperty;

public class GameEffect {

    private ObservableProperty<String> name;
    private ObservableProperty<String> imagePath;
    private ObservableProperty<Double> size;
    private ObservableProperty<String> triggerClass;
    private ObservableProperty<String> triggerConditionGroovy;
    private ObservableProperty<String> effectGroovy;
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");

    
    
    
    public void execute() {
        
    }
}
