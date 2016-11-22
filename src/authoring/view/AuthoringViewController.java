package authoring.view;

import java.util.ArrayList;
import java.util.Enumeration;
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
    private IAuthoringView view;
    private HashMap<String, EditorViewController> editors;
    private final String SETTINGS_RESOURCE_PATH = "resources/ViewSettings";
    private final String TABS_RESOURCE_PATH = "resources/GameAuthoringToolbar";
    private ArrayList<String> tabNames;

    public AuthoringViewController (int width, int height) {
        createEditors();
        createScene(width, height);
        view.setEditorView(editors.values().iterator().next().getView());
    }

    private void createScene (int width, int height) {
    	if (tabNames==null){
    		loadInTabNames();
    	}
        view = AuthoringViewFactory.build(width, height);
        view.createEditorTabPane(tabNames);
        view.setEditorTabPaneDelegate(this);
    }

    private void createEditors () {
    	if (tabNames==null){
    		loadInTabNames();
    	}
        ResourceBundle settingsResource = ResourceBundle.getBundle(SETTINGS_RESOURCE_PATH);
    	editors = new HashMap<String, EditorViewController>();
        int width = Integer.parseInt(settingsResource.getString("editorPrefWidth"));
        int height = Integer.parseInt(settingsResource.getString("editorPrefHeight"));
        editors.put("path", new PathEditorViewController(width, height));
        editors.put("weapon", new WeaponEditorViewController(width, height));
        editors.put("enemy", new EnemyEditorViewController(width, height));
        editors.put("tower", new TowerEditorViewController(width, height));
        editors.put("settings", new GameSettingsEditorViewController(width, height));
        editors.put("level", new LevelEditorViewController(width, height));
    }
    
    private void createEditorViewControllerForTab(String tabNames){
    	//TODO: Reflection
    }

    private void loadInTabNames(){
        ResourceBundle tabsResource = ResourceBundle.getBundle(TABS_RESOURCE_PATH);
        Enumeration<String> nextVal = tabsResource.getKeys();
        tabNames = new ArrayList<String>();
        while (nextVal.hasMoreElements()) {
            tabNames.add(nextVal.nextElement());
        }
    }
    
    @Override
    public void userSelectedTab (String tabName) {
    	System.out.println(tabName);
    	tabName = tabName.toLowerCase();
        EditorViewController editor = this.editors.get(tabName);
        this.view.setEditorView(editor.getView());
    }
    
    public IAuthoringView getView(){
    	return this.view;
    }

}
