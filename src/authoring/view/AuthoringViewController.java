package authoring.view;

import java.util.HashMap;
import java.util.ResourceBundle;

import authoring.editortabpane.EditorTabPaneDelegate;
import authoring.editorview.EditorViewController;
import authoring.editorview.enemy.EnemyEditorViewController;
import authoring.editorview.gamesettings.GameSettingsEditorViewController;
import authoring.editorview.level.LevelEditorViewController;
import authoring.editorview.path.PathEditorViewController;
import authoring.editorview.tower.TowerEditorViewController;
import authoring.editorview.weapon.WeaponEditorViewController;

public class AuthoringViewController implements EditorTabPaneDelegate {
	private IAuthoringView scene;
	private HashMap<String, EditorViewController> editors;
	private ResourceBundle settingsResource;
	private final String SETTINGS_RESOURCE_PATH = "resources/ViewSettings";
	
	public AuthoringViewController(int width, int height){
		settingsResource = ResourceBundle.getBundle(SETTINGS_RESOURCE_PATH);
		createEditors();
		createScene(width, height);
	}
	
	private void createScene(int width, int height){
		scene = AuthoringViewFactory.build(width, height);
		scene.setEditorView(editors.get("path").getView());
		scene.setEditorTabPaneDelegate(this);
	}
	
	private void createEditors(){
		int width = Integer.parseInt(settingsResource.getString("editorPrefWidth"));
		int height = Integer.parseInt(settingsResource.getString("editorPrefHeight"));
		editors.put("path", new PathEditorViewController(width, height));
		editors.put("weapon", new WeaponEditorViewController(width, height));
		editors.put("enemy", new EnemyEditorViewController(width, height));
		editors.put("tower", new TowerEditorViewController(width, height));
		editors.put("gameSettings", new GameSettingsEditorViewController(width, height));
		editors.put("level", new LevelEditorViewController(width, height));
	}

	@Override
	public void userSelectedTab(String tabName) {
		EditorViewController editor = this.editors.get(tabName);
		this.scene.setEditorView(editor.getView());
	}
	
}
