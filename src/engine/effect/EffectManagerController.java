package engine.effect;

import java.util.List;
import engine.ManagerController;


public interface EffectManagerController extends ManagerController<EffectTypeManager, EffectBuilder, Effect, EffectView> {

    List<String> getTriggers ();

    List<String> getTriggerMethods (String trigger);

    boolean setTrigger (int EffectID, String trigger);

}
