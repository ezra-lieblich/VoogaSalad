package authoring.view;

import java.util.HashMap;
import authoring.editortabpane.IEditorTabPane;
import authoring.editorview.EditorViewController;
import authoring.editorview.enemy.EnemyEditorViewController;
import authoring.editorview.gamesettings.GameSettingsEditorViewController;
import authoring.editorview.level.LevelEditorViewController;
import authoring.editorview.path.PathEditorViewController;
import authoring.editorview.tower.TowerEditorViewController;
import authoring.editorview.weapon.WeaponEditorViewController;
import javafx.scene.Scene;

public class AuthoringViewController {
	private IAuthoringView authoringView;
	private HashMap<String, EditorViewController> editors;
	private IEditorTabPane editorTabPane;
	
	public AuthoringViewController(int width, int height){
		authoringView = AuthoringViewFactory.build(width, height);
		editorTabPane = authoringView.getMySideTabbedToolbar();
		createEditors();
		checkTabPane();
	}
	
	private void checkTabPane () {
	    //This needs to be called consistently... It won't be doing that. Observer for this??
            editorTabPane.getViewToOpen();
        
    }

    private void createEditors(){
		editors.put("path", new PathEditorViewController());
		editors.put("weapon", new WeaponEditorViewController());
		editors.put("enemy", new EnemyEditorViewController());
		editors.put("tower", new TowerEditorViewController());
		editors.put("gameSettings", new GameSettingsEditorViewController());
		editors.put("level", new LevelEditorViewController());
	}
	
	public Scene getScene() {
	    return authoringView.getScene();
	}
	
}
