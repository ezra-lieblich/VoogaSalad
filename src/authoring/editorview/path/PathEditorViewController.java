package authoring.editorview.path;

import authoring.editorview.EditorViewController;


public class PathEditorViewController extends EditorViewController implements PathEditorViewDelegate {

	public PathEditorViewController(int editorWidth, int editorHeight){
		IPathEditorView myView = PathEditorViewFactory.build(editorWidth, editorHeight);
		myView.setDelegate(this);
		this.view = myView;

	}

	@Override
	public void createNewPath() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPathImage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPathBackgroundImage() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
