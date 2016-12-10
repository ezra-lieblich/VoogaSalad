package engine.effect.player;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import engine.effect.Effect;
import engine.observer.ObservableProperty;

public class GameEffect {
//
//    private ObservableProperty<String> name;
//    private ObservableProperty<String> imagePath;
//    private ObservableProperty<Double> size;
//    private ObservableProperty<String> triggerClass;
//    private ObservableProperty<String> triggerConditionGroovy;
//    private ObservableProperty<String> effectGroovy;
    
    private String name;
    private String imagePath;
    private Double size;
    private String triggerClass;
    private String triggerConditionGroovy;
    private String effectGroovy; 
    private GroovyExecutor groovyExecutor;
    
    public GameEffect(Effect effect, GroovyExecutor groovyExecutor) {
        this.groovyExecutor = groovyExecutor;
        this.name = effect.getName();
        this.imagePath = effect.getImagePath();
        this.size = effect.getSize();
        this.triggerClass = effect.getTriggerClass();
        this.triggerConditionGroovy = effect.getTriggerConditionGroovy();
        this.effectGroovy = effect.getEffectGroovy();
    }
    
    public void execute() {
        try {
            if(executeCondition()) {
                executeEffect();
            }
        } catch (GroovyException e) {
            System.out.println("ERRORS lolz");
        }

    }
    
    private boolean executeCondition() {
        return groovyExecutor.execute(triggerConditionGroovy, Boolean.class);
    }
    
    private void executeEffect() {
        groovyExecutor.execute(effectGroovy);
    }
    
    public void addTrigger(Object value) {
        groovyExecutor.addVariable(CollisionEffectFactory.TRIGGER_NAME, value);
    }
    
    public void addEncompassingClass(Object value) {
        groovyExecutor.addVariable(CollisionEffectFactory.ENCOMPASSING_CLASS_NAME, value);
    }
    
}
