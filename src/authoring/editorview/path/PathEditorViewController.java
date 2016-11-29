package authoring.editorview.path;

import authoring.editorview.EditorViewController;
import engine.path.PathManagerController;


public class PathEditorViewController extends EditorViewController implements PathEditorViewDelegate {
	private IPathEditorView pathView;
	private PathManagerController pathDataSource;
	
	public PathEditorViewController(int editorWidth, int editorHeight){
		this.pathView = PathEditorViewFactory.build(editorWidth, editorHeight);
		pathView.setDelegate(this);
		this.view = pathView;

	}

		
	public void setPathDataSource(PathManagerController source){
		this.pathDataSource = source;
	}

	@Override
	public void onUserEnteredNumberColumns(int pathID, int numColumns) {
		this.pathDataSource.setNumberofColumns(pathID, numColumns);
		
	}

	@Override
	public void onUserEnteredNumberRows(int pathID, int numRows) {
		pathDataSource.setNumberofRows(pathID, numRows);
		
	}

	@Override
	public void onUserEnteredPathImage(int pathID, String pathImagePath) {
		pathDataSource.setPathImage(pathID, pathImagePath);
		
	}

	@Override
	public void onUserEnteredPathName(int pathID, String pathName) {
		pathDataSource.setPathName(pathID, pathName);
		
	}
	

	@Override
	public int onUserEnteredCreatePath() {
		int pathID = pathDataSource.createNewPath(pathView);
		return pathID;
		
	}



	@Override
	public void onUserEnteredEditPath(int pathID) {
		pathView.setNumColumns(pathDataSource.getNumberofColumns(pathID));
		pathView.setNumRows(pathDataSource.getNumberofRows(pathID));
		pathView.setPathCoordinates(pathDataSource.getPathCoordinates(pathID));
		pathView.setPathImage(pathDataSource.getPathImagePath(pathID));
		pathView.setPathName(pathDataSource.getPathName(pathID));
		
	}

	

}
