package authoring.editorview.tower;


public class TowerEditorViewFactory {
	
	public static ITowerEditorView build () {
        return new TowerEditorView();
    }

}
