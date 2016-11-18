package authoringview;

import java.util.HashMap;

import authoringview.enemy.EnemyEditorViewController;
import authoringview.gamesettings.GameSettingsEditorViewController;
import authoringview.level.LevelEditorViewController;
import authoringview.path.PathEditorViewController;
import authoringview.tower.TowerEditorViewController;
import authoringview.weapon.WeaponEditorViewController;

public class AuthoringViewController {
	private IAuthoringView scene;
	private HashMap<String, EditorViewController> editors;
	
	public AuthoringViewController(int width, int height){
		scene = AuthoringViewFactory.build(width, height);
		createEditors();
	}
	
	private void createEditors(){
		editors.put("path", new PathEditorViewController());
		editors.put("weapon", new WeaponEditorViewController());
		editors.put("enemy", new EnemyEditorViewController());
		editors.put("tower", new TowerEditorViewController());
		editors.put("gameSettings", new GameSettingsEditorViewController());
		editors.put("level", new LevelEditorViewController());
	}
	
}
