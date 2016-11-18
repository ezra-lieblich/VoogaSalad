package authoring.view;

import java.util.HashMap;
import authoring.editorview.EditorViewController;
import authoring.editorview.enemy.EnemyEditorViewController;
import authoring.editorview.gamesettings.GameSettingsEditorViewController;
import authoring.editorview.level.LevelEditorViewController;
import authoring.editorview.path.PathEditorViewController;
import authoring.editorview.tower.TowerEditorViewController;
import authoring.editorview.weapon.WeaponEditorViewController;

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
