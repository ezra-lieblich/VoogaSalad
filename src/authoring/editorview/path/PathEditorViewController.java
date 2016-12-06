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
	public void onUserEnteredNumberColumns(int numColumns) {
		this.pathDataSource.setNumberofColumns(activeID, numColumns);
		
	}

	@Override
	public void onUserEnteredNumberRows(int numRows) {
		pathDataSource.setNumberofRows(activeID, numRows);
		
	}

	@Override
	public void onUserEnteredPathImage(String pathImagePath) {
		pathDataSource.setImagePath(activeID, pathImagePath);
		
	}

	@Override
	public void onUserEnteredPathName(String pathName) {
		pathDataSource.setName(activeID, pathName);
		
	}
	

	@Override
	public int onUserEnteredCreatePath() {
		pathView.createNewPath();	
		return pathDataSource.createType(pathView);		
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
	public boolean onUserEnteredAddPathCoordinate(int x, int y) {
		return pathDataSource.setNewPathCoordinate(activeID, x, y);
		
	}
	
	@Override
	public boolean onUserEnteredRemovePathCoordinate(int x, int y) {
		return pathDataSource.setNewPathCoordinate(activeID, x, y);
	}


	@Override
	public void onUserEnteredDeletePath() {
		
		
	}

	

}
