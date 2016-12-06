package authoring.editorview.path;


public interface PathEditorViewDelegate {
	
	public void onUserEnteredNumberColumns(int numColumns);
	
	public void onUserEnteredNumberRows(int numRows);
	
	public void onUserEnteredPathImage(String pathImagePath);
	
	public void onUserEnteredPathName(String pathName);
	
	public int onUserEnteredCreatePath();
	
	public void onUserEnteredDeletePath();
	
	public void onUserEnteredEditPath(int pathID);
	
	public boolean onUserEnteredAddPathCoordinate(int x, int y);
	
	public boolean onUserEnteredRemovePathCoordinate(int x, int y);
	
	
	
	


	

}
