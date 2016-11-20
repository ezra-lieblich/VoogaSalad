package authoring.editorview.weapon;

import authoring.editorview.EditorViewController;

public class WeaponEditorViewController extends EditorViewController {
	
	public WeaponEditorViewController(int editorWidth, int editorHeight){
		view = WeaponEditorViewFactory.build(editorWidth, editorHeight);
	}
}
