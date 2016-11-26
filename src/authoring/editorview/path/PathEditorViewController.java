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



	@Override
	public void onUserEnteredNumberColumns(int numColumns) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onUserEnteredNumberRows(int numRows) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onUserEnteredBackgroundImage(String backgroundImagePath) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onUserEnteredPathImage(String pathImagePath) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onUserEnteredPathName(String pathName) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onUserEnteredCreatePath() {
		// TODO Auto-generated method stub
		
	}

}
