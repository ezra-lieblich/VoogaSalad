package authoring.editorview.path;

import java.util.List;

import authoring.editorview.IEditorView;
import engine.path.Coordinate;

/**
 * 
 * This interface details the components of the path tab. The interface defines our internal API
 * and the public methods defining what components the path view should contain.
 *
 */
public interface IPathEditorView extends IEditorView {

	public void setDelegate(PathEditorViewDelegate delegate);
	
	public void setPathImage(String pathImage);
	
	public void setNumColumns(int numColumns);
	
	public void setNumRows(int numRows);
	
	public void setPathName(String pathName);
	
	public void setPathCoordinates(List<Coordinate<Integer>> pathCoordinates);

}
