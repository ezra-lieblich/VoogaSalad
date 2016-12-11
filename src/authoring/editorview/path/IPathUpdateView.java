package authoring.editorview.path;

import java.util.List;

import authoring.editorview.IUpdateView;
import authoring.editorview.ListDataSource;
import engine.path.Coordinate;

public interface IPathUpdateView extends IPathSetView, IUpdateView{
	
	public void updateGridDimensions(int dimensions);
	
	public void updatePathCoordinates(List<Coordinate<Integer>> pathCoordinates);
	
	public void updateType (String pathType);
	
	public void updateActiveID (int pathID);
	
	public void updatePath ();

	public void setPathListDataSource (ListDataSource source);

}
