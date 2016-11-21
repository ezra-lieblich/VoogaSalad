package authoring.editorview.path;

import authoring.editorview.EditorViewController;

public class PathEditorViewController extends EditorViewController implements PathEditorViewDelegate{

	public PathEditorViewController(int editorWidth, int editorHeight){
		IPathEditorView pathView = PathEditorViewFactory.build(editorWidth, editorHeight);
		pathView.setDelegate(this);
		this.view = pathView;
	}
	
	
	
}
