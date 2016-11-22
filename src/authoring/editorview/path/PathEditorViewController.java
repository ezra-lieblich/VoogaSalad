package authoring.editorview.path;

import authoring.editorview.EditorViewController;

public class PathEditorViewController extends EditorViewController implements PathEditorViewDelegate {

	private PathDataSource pathDataSource;
	
	public PathEditorViewController(int editorWidth, int editorHeight){
		IPathEditorView myView = PathEditorViewFactory.build(editorWidth, editorHeight);
		myView.setDelegate(this);
		this.view = myView;
	}
	
	public void setPathDataSource(PathDataSource source){
		this.pathDataSource = source;
	}
}
