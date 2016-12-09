package authoring.editorview.path;


import authoring.editorview.EditorViewController;
import engine.path.PathManagerController;


public class PathEditorViewController extends EditorViewController implements PathEditorViewDelegate {
	private IPathEditorView pathView;
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
	public void onUserEnteredGridDimensions(int dimensions) {
		pathDataSource.setSquareGridDimensions(activeID, dimensions);
		
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
		activeID = pathDataSource.createType(pathView);	
		pathView.updateActiveID(activeID);
		return activeID;
	}

	@Override
	public void onUserEnteredEditPath(int pathID) {
		activeID = pathID;
		pathView.updateActiveID(activeID);
		pathView.updateGridDimensions(pathDataSource.getNumberofRows(activeID));	
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
		return pathDataSource.removePathCoordinate(activeID, x, y);
	}


	@Override
	public void onUserEnteredDeletePath() {
		
		
	}



}
