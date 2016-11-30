package authoring.editorview.path;


public interface PathEditorViewDelegate {
	
	public void onUserEnteredNumberColumns(int pathID, int numColumns);
	
	public void onUserEnteredNumberRows(int pathID, int numRows);
	
	public void onUserEnteredPathImage(int pathID, String pathImagePath);
	
	public void onUserEnteredPathName(int pathID, String pathName);
	
	public int onUserEnteredCreatePath();
	
	public void onUserEnteredDeletePath();
	
	public void onUserEnteredEditPath(int pathID);
	
	public void onUserEnteredPathCoordinate(int pathID, int x, int y);
	
	
	
	


	

}
