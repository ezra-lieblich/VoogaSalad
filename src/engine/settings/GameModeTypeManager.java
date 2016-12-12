package engine.settings;

import engine.AbstractTypeManager;
import engine.effect.EffectBuilder;
import engine.effect.EffectManager;
import engine.effect.EffectManagerFactory;
import engine.effect.EffectTypeBuilder;
import engine.effect.player.AbstractEffectFactory;
import engine.effect.player.WinEffectFactory;
import engine.path.PathManager;

public class GameModeTypeManager extends AbstractTypeManager<GameMode> implements GameModeManager{
    public static final Class<? extends AbstractEffectFactory> DEFAULT_EFFECT_FACTORY = WinEffectFactory.class;
	
	private EffectManager gameModeEffectManager;
	
	GameModeTypeManager() {
		this.gameModeEffectManager = new EffectManagerFactory().create(DEFAULT_EFFECT_FACTORY);
		 EffectBuilder effectFactory = new EffectTypeBuilder();
		 gameModeEffectManager.addEntry(effectFactory.buildTriggerConditionGroovy("getTotalLevel() + 1 == getCurrentLevel()")
				 									.buildEffectGroovy("setWin(true)")
				 									.build());
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
