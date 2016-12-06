package authoring.editorview.path;


import authoring.editorview.EditorViewController;
import engine.path.PathManagerController;


public class PathEditorViewController extends EditorViewController implements PathEditorViewDelegate {
	private IPathUpdateView pathView;
	private PathManagerController pathDataSource;
	private int activeID;
	
	public PathEditorViewController(int editorWidth, int editorHeight){
		this.pathView = PathEditorViewFactory.build(editorWidth, editorHeight);
		pathView.setDelegate(this);
		this.view = pathView;
		

	}

		
	public void setPathDataSource(PathManagerController source){
		this.pathDataSource = source;
		this.pathDataSource.addTypeBankListener(this.pathView);
		onUserEnteredCreatePath();
		onUserEnteredEditPath(activeID);
		
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
		activeID = pathDataSource.createType(pathView);
		pathView.updateActiveID(activeID);
		pathView.createNewPath();
			
	}



	@Override
	public void onUserEnteredEditPath(int pathID) {
		activeID = pathID;
		pathView.updateActiveID(activeID);
		pathView.updateNumColumns(pathDataSource.getNumberofColumns(activeID));
		pathView.updateNumRows(pathDataSource.getNumberofRows(activeID));
		pathView.updatePathCoordinates(pathDataSource.getPathCoordinates(activeID));
		pathView.updateImagePathDisplay(pathDataSource.getImagePath(activeID));
		pathView.updateNameDisplay(pathDataSource.getName(activeID));
		pathView.updatePath();
	}


	@Override
	public boolean onUserEnteredAddPathCoordinate(int pathID, int x, int y) {
		boolean validCoordinate = pathDataSource.setNewPathCoordinate(pathID, x, y);
		return validCoordinate;
		
	}
	
	@Override
	public boolean onUserEnteredRemovePathCoordinate(int pathID, int x, int y) {
		boolean validCoordinate = pathDataSource.setNewPathCoordinate(pathID, x, y);
		return validCoordinate;
	}


	@Override
	public void onUserEnteredDeletePath() {
		
		
	}

	

}
