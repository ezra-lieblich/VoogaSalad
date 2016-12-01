package authoring.editorview.path;


public interface PathEditorViewDelegate {
	
	public void onUserEnteredNumberColumns(int pathID, int numColumns);
	
	public void onUserEnteredNumberRows(int pathID, int numRows);
	
	public void onUserEnteredPathImage(int pathID, String pathImagePath);
	
	public void onUserEnteredPathName(int pathID, String pathName);
	
	public void onUserEnteredCreatePath();
	
	public void onUserEnteredDeletePath();
	
	public void onUserEnteredEditPath(int pathID);
	
	public void onUserEnteredAddPathCoordinate(int pathID, int x, int y);
	
	public void onUserEnteredRemovePathCoordinate(int pathID, int x, int y);
	
	
	
	


	

}
