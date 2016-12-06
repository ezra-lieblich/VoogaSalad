package engine.level;

import java.util.List;
import java.util.Map;
import authoring.editorview.level.ILevelEditorView;
import engine.AbstractTypeManagerController;
import engine.ManagerMediator;
import engine.level.wave.WaveType;


public class LevelTypeManagerController
        extends AbstractTypeManagerController<LevelManager, LevelBuilder, Level, ILevelEditorView>
        implements LevelManagerController {

	
    public LevelTypeManagerController (ManagerMediator managerMediator) {
        super(new LevelTypeManager(), new LevelTypeBuilder(), managerMediator);
    }

    @Override
    public void setEnemy (int levelID, int enemyID, WaveType wave) {
        getTypeManager().getEntity(levelID).setEnemyCounts(enemyID, wave);
    }

    @Override
    public void setRewardScore (int levelID, double winScore) {
        getTypeManager().getEntity(levelID).setRewardScore(winScore);
    }

    @Override
    public void setRewardMoney (int levelID, double winMoney) {
        getTypeManager().getEntity(levelID).setRewardMoney(winMoney);
    }

    @Override
    public void setRewardHealth (int levelID, double winHealth) {
        getTypeManager().getEntity(levelID).setRewardHealth(winHealth);
    }

    @Override
    public void setPath (int levelID, int pathID) {
        // TODO Implement Path

    }

    @Override
    public void setTransitionTime (int levelID, double time) {
        getTypeManager().getEntity(levelID).setDurationInSeconds(time);
    }

    @Override
    public Map<Integer, WaveType> getEnemies (int levelID) {
        return getTypeManager().getEntity(levelID).getEnemyCounts();
    }

    @Override
    public double getRewardScore (int levelID) {
        return getTypeManager().getEntity(levelID).getRewardScore();
    }

    @Override
    public double getRewardMoney (int levelID) {
        return getTypeManager().getEntity(levelID).getRewardMoney();
    }

    @Override
    public double getRewardHealth (int levelID) {
        return getTypeManager().getEntity(levelID).getRewardHealth();
    }

    @Override
    public int getPath (int levelID) {
        // TODO Implement Path
        return 0;
    }

    @Override
    public double getTransitionTime (int levelID) {
        return getTypeManager().getEntity(levelID).getDurationInSeconds();
    }

    @Override
    public void setEnemyFrequency (int levelID, int enemyID, double enemyFrequency) {
        // TODO Need to implement

    }

    @Override
    public double getEnemyFrequency (int levelID, int enemyID) {
        // TODO Need to implement
        return 0;
    }

    @Override
    protected LevelBuilder constructTypeProperties (ILevelEditorView updateView,
                                                    LevelBuilder typeBuilder) {
        return typeBuilder.addDurationInSecondsListener( (oldValue, newValue) -> updateView
                .updateTransitionTime(newValue))
                //.addWaveListener( (oldValue, newValue) -> updateView.updateEnemy(newValue))
                .addRewardHealthListener( (oldValue, newValue) -> updateView
                        .updateRewardHealth(newValue))
                .addRewardScoreListener( (oldValue, newValue) -> updateView
                        .updateRewardPoints(newValue))
                .addRewardMoneyListener( (oldValue, newValue) -> updateView
                        .updateRewardMoney(newValue));
                //TODO add listener .addLevelTimeListener()
        		
        
    }

    @Override
    public void setLevelNumber (int levelID, int levelNumber) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getLevelNumber (int levelID) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Integer> getLevelOptions () {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public double getLevelTime(int levelID) {
		return getTypeManager().getEntity(levelID).getLevelTime();
	}

	@Override
	public int createWave(int levelID, ILevelEditorView updateView) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeWave(int levelID, int waveID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWaveEnemy(int levelID, int waveID, int enemyID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWaveEnemy(int levelID, int waveID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWaveCount(int levelID, int waveID, int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWaveCount(int levelID, int waveID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWaveFrequency(int levelID, int waveID, double frequency) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getWaveFrequency(int levelID, int waveID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWavePath(int levelID, int waveID, int pathID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWavePath(int levelID, int waveID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWaveDelay(int levelID, int waveID, double delay) {
		// TODO Auto-generated method stub
		
	}

}
