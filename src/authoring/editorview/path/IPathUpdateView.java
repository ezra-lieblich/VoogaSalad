package authoring.editorview.path;

import java.util.List;

import authoring.editorview.IUpdateView;
import engine.path.Coordinate;

public interface IPathUpdateView extends IPathEditorView, IUpdateView{

	public void updatePathImage(String pathImage);
	
	public void updateNumColumns(int numColumns);
	
	public void updateNumRows(int numRows);
	
	public void updatePathName(String pathName);
	
	public void updatePathCoordinates(List<Coordinate<Integer>> pathCoordinates);
	
	public void updateType (String pathType);
	
	public void updateActiveID (int pathID);
	
	public void createNewPath ();

}
