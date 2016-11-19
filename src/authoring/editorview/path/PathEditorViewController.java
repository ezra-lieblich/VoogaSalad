package authoring.editorview.path;

import authoring.editorview.EditorViewController;

public class PathEditorViewController extends EditorViewController {

	public PathEditorViewController(int editorWidth, int editorHeight){
		view = PathEditorViewFactory.build(editorWidth, editorHeight);
	}
}
