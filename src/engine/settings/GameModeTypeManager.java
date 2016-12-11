package engine.settings;

import engine.AbstractTypeManager;
import engine.MethodObjectData;

public class GameModeTypeManager extends AbstractTypeManager<GameMode> implements GameModeManager{
	@Override
	public void removeEntry (int id) {
       super.removeEntry(id);
       notifyObservers(new MethodObjectData<Integer>("RemoveEntry", id));
    }
}
