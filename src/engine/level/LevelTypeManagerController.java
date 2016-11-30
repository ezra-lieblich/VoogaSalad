package engine.level;

import java.util.Map;

import authoring.editorview.level.ILevelUpdateView;
import engine.AbstractTypeManagerController;


public class LevelTypeManagerController 
	extends AbstractTypeManagerController<LevelManager, LevelBuilder, Level, ILevelUpdateView> implements LevelManagerController{

	protected LevelTypeManagerController(LevelManager typeManager) {
		super(typeManager, new LevelTypeBuilder());
	}

	@Override
	public void setEnemy(int levelID, int enemyID, int numEnemies) {
		getTypeManager().getEntity(levelID).setEnemyCounts(enemyID, numEnemies);
	}

	@Override
	public void setRewardScore(int levelID, double winScore) {
		getTypeManager().getEntity(levelID).setRewardScore(winScore);
	}

	@Override
	public void setRewardMoney(int levelID, double winMoney) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRewardHealth(int levelID, double winHealth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPath(int levelID, int pathID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTransitionTime(int levelID, double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Integer, Integer> getEnemies(int levelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getRewardScore(int levelID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getRewardMoney(int levelID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getRewardHealth(int levelID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPath(int levelID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTransitionTime(int levelID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setEnemyFrequency(int levelID, int enemyID, double enemyFrequency) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getEnemyFrequency(int levelID, int enemyID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected LevelBuilder constructTypeProperties(ILevelUpdateView updateView, LevelBuilder typeBuilder) {
		// TODO Auto-generated method stub
		return null;
	}

}
