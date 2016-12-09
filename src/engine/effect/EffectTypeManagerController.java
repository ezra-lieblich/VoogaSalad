package engine.effect;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import authoring.editorview.enemy.IEnemyEditorView;
import engine.AbstractTypeManagerController;
import engine.ManagerMediator;
import engine.effect.player.GameEffect;
import engine.effect.player.GroovyExecutor;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;
import engine.tower.TowerTypeBuilder;
import engine.tower.TowerTypeManager;


public class EffectTypeManagerController extends
        AbstractTypeManagerController<EffectTypeManager, EffectBuilder, Effect, EffectView>
        implements EffectManagerController {

    EffectTypeManagerController (ManagerMediator managerMediator) {
        super(new EffectTypeManager(), new EffectTypeBuilder(), managerMediator);
        EffectBuilder efb = new EffectTypeBuilder();
        Effect effectType = efb.buildTriggerConditionGroovy("trigger.getHealth() == 50 && trigger.getName() == 'Sean'").buildEffectGroovy("trigger.setHealth(100)").build();
        GameEffect test = new GameEffect(effectType, new GroovyExecutor());
        Enemy enemy = new Enemy();
        test.addTrigger((ITestEnemy)enemy);
        test.addEncompassingClass(this);
        test.execute();
        System.out.println(enemy.getHealth());
    }

    /*
     * (non-Javadoc)
     * 
     * @see engine.effect.EffectManagerController#getTriggers()
     */
    @Override
    public List<String> getTriggers () {
        return getTypeManager().getAnnotatedClasses();
    }

    /*
     * (non-Javadoc)
     * 
     * @see engine.effect.EffectManagerController#getTriggerMethods(java.lang.String)
     */
    @Override
    public List<String> getTriggerMethods (String trigger) {
        return getTypeManager().getAnnotatedClassMethods(trigger).stream().map(a -> a.toGenericString())
                .collect(Collectors.toList());
    }

    /*
     * (non-Javadoc)
     * 
     * @see engine.effect.EffectManagerController#setTrigger(int, java.lang.String)
     */
    @Override
    public boolean setTrigger (int EffectID, String trigger) {
//        try {
//            getTypeManager().getEntity(EffectID).getTrigger()
//                    .setParticipantClass(Class.forName(trigger));
//            return true;
//        }
//        catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            // Create null class object, Extend Duvall's Class
//
//            e.printStackTrace();
//            return false;
        return true;
        }

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


}
