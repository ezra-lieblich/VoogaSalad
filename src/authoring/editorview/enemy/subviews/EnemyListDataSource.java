package authoring.editorview.enemy.subviews;

import authoring.editorview.ListCellData;

public interface EnemyListDataSource {
	public ListCellData getCellDataForEnemy(int enemyID);
}
