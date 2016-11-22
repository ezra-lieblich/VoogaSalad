package authoring.editorview.path;

import authoring.editorview.EditorViewController;

public class PathEditorViewController extends EditorViewController implements PathEditorViewDelegate{

	public PathEditorViewController(int editorWidth, int editorHeight){
		IPathEditorView pathView = PathEditorViewFactory.build(editorWidth, editorHeight);
		pathView.setDelegate(this);
		this.view = pathView;
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
