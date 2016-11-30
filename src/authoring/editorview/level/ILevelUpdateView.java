package authoring.editorview.level;



import java.util.Map;

import authoring.editorview.IUpdateView;


public interface ILevelUpdateView  extends ILevelEditorView, IUpdateView {
	

	//UpdateEnemy should take in the map of enemy counts
	public void updateEnemy (Map<Integer, Integer> enemyCounts);
	
	public void updateRewardPoints (double winPoints);
	
	public void updateRewardHealth (double winHealth);
	
	public void updateRewardMoney (double winMoney);
	
	public void updatePath (int pathID);
	
	public void updateTransitionTime (double time);
	
	public void updateEnemyFrequency (double enemyFrequency);


}
