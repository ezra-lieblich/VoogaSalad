package engine.effect;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import authoring.editorview.enemy.IEnemyUpdateView;
import engine.AbstractTypeManagerController;
import engine.ManagerMediator;
import engine.effect.player.CollisionEffectFactory;
import engine.effect.player.GameEffect;
import engine.effect.player.GroovyExecutor;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;
import engine.tower.TowerTypeBuilder;
import engine.tower.TowerTypeManager;


public class EffectTypeManagerController extends
        AbstractTypeManagerController<EffectManager, EffectBuilder, Effect, EffectView>
        implements EffectManagerController {

    public EffectTypeManagerController (ManagerMediator managerMediator, EffectManager effectTypeManager) {
        super(effectTypeManager, new EffectTypeBuilder(), managerMediator);
        
        EffectBuilder efb = new EffectTypeBuilder();
        Effect effectType = efb.buildTriggerConditionGroovy("collider.getHealth() == 50 && myself.getName() == 'Sean'").buildEffectGroovy("collider.setHealth(100)").build();
        CollisionEffectFactory testFactory = new CollisionEffectFactory();
        GameEffect gameEffect = testFactory.create(effectType);
        
        Enemy collider = new Enemy();
        Enemy myself = new Enemy();
        System.out.println(collider.getHealth());
        gameEffect.addEncompassingClass(myself); //Enemy constructor gameEffect.addEncompassingClass(this)
        
        gameEffect.addTrigger(collider);
        
        gameEffect.execute();
        System.out.println(collider.getHealth());
        
    }
    
    EffectTypeManagerController (ManagerMediator managerMediator) {
        this(managerMediator, new EffectManagerFactory().create());
    }

    /*
     * (non-Javadoc)
     * 
     * @see engine.effect.EffectManagerController#getTriggers()
     */
    @Override
    public void addActiveClassListener(EffectView updateView) {
        getTypeManager().addActiveClassListener((oldValue, newValue) -> {
                updateView.updateTriggers(getAvailableClassMethods(newValue));
        });
    }
    
    @Override
    public List<String> getAvailableClasses () {
        return getTypeManager().getAnnotatedClasses().stream().map(Class::getName).collect(Collectors.toList());
    }

    /*
     * (non-Javadoc)
     * 
     * @see engine.effect.EffectManagerController#getTriggerMethods(java.lang.String)
     */
    @Override
    public List<String> getAvailableClassMethods (String trigger) {
        return getTypeManager().getAnnotatedClassMethods(trigger).stream().map(a -> a.toGenericString())
                .collect(Collectors.toList());
    }

    /*
     * (non-Javadoc)
     * 
     * @see engine.effect.EffectManagerController#setTrigger(int, java.lang.String)
     */
  

        // EffectType newEffect = new EffectType();
        // ObservableProperty<String> observableTrigger = new
        // ObservableObjectProperty<String>(trigger);
        // observableTrigger.addListener((oldValue, newValue) ->
        // effectView.updateTriggerConditions(effectManager.getAnnotatedClassMethods(newValue).stream().map(Method::getName).collect(Collectors.toList())
        // ));
        // newEffect.setTriggerClass(new ObservableObjectProperty<String>(trigger));
        // observableTrigger.setProperty(trigger);
        // enemy.addEffect(newEffect);
        // System.out.println(enemy.getEffectsSize());
        //
        //
        // return enemy.getEffectsSize() - 1;
        // effectManager.getAnnotatedClassMethods(trigger)
    

    @Override
    protected EffectBuilder constructTypeProperties (EffectView updateView,
                                                     EffectBuilder typeBuilder) {
        return typeBuilder;
//                .addTriggerClassListener( (oldValue, newValue) -> updateView
//                        .updateTriggerConditions(getTypeManager()
//                                .getAnnotatedClassMethods(newValue.getName()).stream()
//                                .map(a -> a.toString()).collect(Collectors.toList())));
    }

    @Override
    public void setAvailableClass (String selectedClass) {
        getTypeManager().setActiveClass(selectedClass);
    }

    @Override
    public String getTrigger (int effectID) {
        return getTypeManager().getEntity(effectID).getTriggerClass();
    }

    @Override
    public String getCondition (int effectID) {
        return getTypeManager().getEntity(effectID).getTriggerConditionGroovy();
    }

    @Override
    public String getEffect (int effectID) {
        return getTypeManager().getEntity(effectID).getEffectGroovy();
    }

    @Override
    public void setTrigger (int effectID, String trigger) {
         getTypeManager().getEntity(effectID).setTriggerClass(trigger);
    }

    @Override
    public void setCondition (int effectID, String trigger) {
        getTypeManager().getEntity(effectID).setTriggerConditionGroovy(trigger);
    }

    @Override
    public void setEffect (int effectID, String trigger) {
        getTypeManager().getEntity(effectID).setEffectGroovy(trigger);
    }

}
