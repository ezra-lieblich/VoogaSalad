package authoring.editorview.tower;


public class TowerEditorViewFactory {
	
	public static ITowerEditorView build (int width, int height) {
        return new TowerEditorView();
    }

}
