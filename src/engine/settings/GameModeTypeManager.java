package engine.settings;

import engine.AbstractTypeManager;
import engine.effect.EffectManager;
import engine.effect.EffectManagerFactory;
import engine.path.PathManager;

public class GameModeTypeManager extends AbstractTypeManager<GameMode> implements GameModeManager{
	private EffectManager gameModeEffectManager;
	
	GameModeTypeManager() {
		this.gameModeEffectManager = new EffectManagerFactory().create();
	}
	
	@Override
	public EffectManager getGameModeEffectManager() {
		return gameModeEffectManager;
	}

	@Override
	public void visitCreatePath(PathManager pathManager, int pathID) {
        applyToAllEntities(a -> a.addPath(pathID));
	}

}
