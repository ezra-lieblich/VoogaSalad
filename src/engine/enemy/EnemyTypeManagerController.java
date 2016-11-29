package engine.enemy;

import authoring.editorview.enemy.EnemyDataSource;
import authoring.editorview.enemy.IEnemyUpdateView;
import authoring.editorview.path.IPathUpdateView;
import engine.AbstractTypeManagerController;
import engine.path.Path;
import engine.path.PathBuilder;
import engine.path.PathManager;
import engine.path.PathManagerController;

import java.util.List;

/**
 * Created by ezra on 11/29/16.
 */
public class EnemyTypeManagerController  
	extends AbstractTypeManagerController<EnemyManager, EnemyBuilder, Enemy, IEnemyUpdateView> implements EnemyManagerController {

	EnemyTypeManagerController(EnemyManager enemyManager) {
		super(enemyManager, new EnemyTypeBuilder());
	}

	@Override
	public void setEnemySpeed(int enemyID, double enemySpeed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnemyHealth(int enemyID, double enemyHealth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnemyDamage(int enemyID, double enemyDamage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnemyRewardMoney(int enemyID, double enemyRewardMoney) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnemyRewardPoints(int enemyID, double enemyRewardPoints) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnemyCollisionEffect(int enemyID, String enemyCollisionEffect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getEnemySpeed(int enemyID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getEnemyHealth(int enemyID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getEnemyDamage(int enemyID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getEnemyRewardMoney(int enemyID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getEnemyRewardPoints(int enemyID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getEnemyCollisionEffect(int enemyID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getCreatedEnemyIDs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected EnemyBuilder constructTypeProperties(IEnemyUpdateView updateView, EnemyBuilder typeBuilder) {
		// TODO Auto-generated method stub
		return null;
	}
   
}
