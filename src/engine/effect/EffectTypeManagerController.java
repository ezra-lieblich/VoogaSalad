package engine.effect;

import java.util.List;
import java.util.stream.Collectors;
import authoring.editorview.collisioneffects.EffectUpdateView;
import engine.AbstractTypeManagerController;
import engine.ManagerMediator;
import gameplayer.model.effect.factory.AbstractEffectFactory;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public class EffectTypeManagerController extends
        AbstractTypeManagerController<EffectManager, EffectBuilder, Effect, EffectUpdateView>
        implements EffectManagerController {
    public static final Class<? extends AbstractEffectFactory> DEFAULT_EFFECT_FACTORY = AbstractEffectFactory.class;
    
    public EffectTypeManagerController (ManagerMediator managerMediator, EffectManager effectTypeManager) {
        super(effectTypeManager, new EffectTypeBuilder(), managerMediator);
    }
    
    EffectTypeManagerController (ManagerMediator managerMediator) {
        this(managerMediator, new EffectManagerFactory().create(DEFAULT_EFFECT_FACTORY));
    }

    @Override
    public void addActiveClassListener(EffectUpdateView updateView) throws ClassNotFoundException{
        getTypeManager().addActiveClassListener((oldValue, newValue) -> {
                    updateView.updateTriggers(getAvailableClassMethods(newValue.getName()));
        });
    }
    
    @Override
    public List<String> getAvailableClasses () {
        return getTypeManager().getAnnotatedClasses().stream().map(Class::getName).collect(Collectors.toList());
    }

    @Override
    public List<String> getAvailableClassMethods (String trigger) {
        try {
            return getTypeManager().getAnnotatedClassMethods(Class.forName(trigger)).stream().map(a -> a.toGenericString())
                    .collect(Collectors.toList());
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected EffectBuilder constructTypeProperties (EffectUpdateView updateView,
                                                     EffectBuilder typeBuilder) {
        return typeBuilder;
//                .addTriggerClassListener( (oldValue, newValue) -> updateView
//                        .updateTriggerConditions(getTypeManager()
//                                .getAnnotatedClassMethods(newValue.getName()).stream()
//                                .map(a -> a.toString()).collect(Collectors.toList())));
    }

    @Override
    public void setAvailableClass (String selectedClass) {
        try {
            getTypeManager().setActiveClass(Class.forName(selectedClass));
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    @Override
    public List<String> getAvailableDataObjects () {
        return getTypeManager().getAnnotatedDataObjects().stream().map( a -> a.getName()).collect(Collectors.toList());
    }

}
