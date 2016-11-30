package authoring.editorview.path;


import authoring.editorview.EditorViewController;
import engine.path.PathManagerController;


public class PathEditorViewController extends EditorViewController implements PathEditorViewDelegate {
	private IPathUpdateView pathView;
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
		pathDataSource.setImagePath(pathID, pathImagePath);
		
	}

	@Override
	public void onUserEnteredPathName(int pathID, String pathName) {
		pathDataSource.setName(pathID, pathName);
		
	}
	

	@Override
	public void onUserEnteredCreatePath() {
		int pathID = pathDataSource.createType(pathView);
		pathView.updateActiveID(pathID);
		pathView.createNewPath();	
	}



	@Override
	public void onUserEnteredEditPath(int pathID) {
		pathView.updateActiveID(pathID);
		pathView.updateNumColumns(pathDataSource.getNumberofColumns(pathID));
		pathView.updateNumRows(pathDataSource.getNumberofRows(pathID));
		pathView.updatePathCoordinates(pathDataSource.getPathCoordinates(pathID));
		pathView.updatePathImage(pathDataSource.getImagePath(pathID));
		pathView.updatePathName(pathDataSource.getName(pathID));
		
	}


	@Override
	public void onUserEnteredAddPathCoordinate(int pathID, int x, int y) {
		pathDataSource.setNewPathCoordinate(pathID, x, y);
		
	}
	
	@Override
	public void onUserEnteredRemovePathCoordinate(int pathID, int x, int y) {
		pathDataSource.setNewPathCoordinate(pathID, x, y);
		
	}


	@Override
	public void onUserEnteredDeletePath() {
		// TODO Auto-generated method stub
		
	}

	

}
