package authoring.editorview.level;



import java.util.Map;

import authoring.editorview.IUpdateView;


public interface ILevelUpdateView  extends ILevelEditorView, IUpdateView {
	

	public void updateEnemy (Map<Integer, Integer> enemyCounts);
	
	public void updateRewardPoints (double winPoints);
	
	public void updateRewardHealth (double winHealth);
	
	public void updateRewardMoney (double winMoney);
	
	public void updatePath (int pathID);
	
	public void updateTransitionTime (double time);
	
	public void updateEnemyFrequency (double enemyFrequency);


}
