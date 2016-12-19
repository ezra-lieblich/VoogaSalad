package gameplayer.model.effect;

import engine.effect.Effect;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public class GameEffect {
    
    private final String triggerName;
    private final String encompassingClassName;
    private String triggerClass;
    private String triggerConditionGroovy;
    private String effectGroovy; 
    private GroovyExecutor groovyExecutor;
    
    public GameEffect(Effect effect, GroovyExecutor groovyExecutor, String triggerName, String encompassingClassName) {
        this.groovyExecutor = groovyExecutor;
        this.triggerClass = effect.getTriggerClass();
        this.triggerConditionGroovy = effect.getTriggerConditionGroovy();
        this.effectGroovy = effect.getEffectGroovy();
        this.triggerName = triggerName;
        this.encompassingClassName = encompassingClassName;
    }
    
    public void execute() {
        if(executeCondition()) {
            executeEffect();
        }
    }
    
    private boolean executeCondition() {
        return groovyExecutor.execute(triggerConditionGroovy, Boolean.class);
    }
    
    private void executeEffect() {
        groovyExecutor.execute(effectGroovy);
    }
    
    public void addTrigger(Object value) {
        groovyExecutor.addVariable(triggerName, value);
    }
    
    public void addEncompassingClass(Object value) {
        groovyExecutor.addVariable(encompassingClassName, value);
    }
    
    public String getTriggerClass(){
    	return this.triggerClass;
    }
    
}
