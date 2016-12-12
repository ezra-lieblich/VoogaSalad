package authoring.editorview.path;


import authoring.editorview.path.subviews.PathDesignView;
import authoring.editorview.path.subviews.PathEditorView;

import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.ListDataSource;
import engine.path.Coordinate;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


public class PathAuthoringView implements PathUpdateView {

    private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";
    private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);

   
    private static final int EDITOR_SIZE = 300;
    private static final int AUTHORING_HEIGHT = 700;

    private PathEditorView pathEditor;
    private PathDesignView pathDesign;
    private GridPane pathView;
    
    
   
    public PathAuthoringView (int aWidth, int aHeight) {
        
    	pathView = new GridPane();
    	
    	pathEditor = new PathEditorView(EDITOR_SIZE, pathResource);
    	pathDesign = new PathDesignView();
    	buildView();
        
        
  
    }

    @Override
    public Node getInstanceAsNode () {
        return pathView;
    }

    @Override
    public void setDelegate (PathAuthoringViewDelegate delegate) {
    	pathEditor.setDelegate(delegate);
    	pathDesign.setDelegate(delegate);     
    }

    @Override
    public void updateActiveID (int pathID) {
        pathEditor.updateActiveID(pathID);
    }

    
    private void buildView () {

        ColumnConstraints editorColumn = new ColumnConstraints();
        editorColumn.setMinWidth(EDITOR_SIZE);
       
        ColumnConstraints previewColumn = new ColumnConstraints();
        previewColumn.setMinWidth(700);
        
        RowConstraints fullRow = new RowConstraints();
        
        fullRow.setMinHeight(AUTHORING_HEIGHT);
        
        pathView.getColumnConstraints().addAll(editorColumn, previewColumn);
        pathView.getRowConstraints().add(fullRow);
        
        pathView.add(pathEditor.getInstanceAsNode(), 0, 0);
        pathView.add(pathDesign.getInstanceAsNode(), 1, 0);
    }
    

    @Override
    public void updateGridDimensions (int dimensions) {
        pathEditor.updateGridDimensions(dimensions);
        pathDesign.updateGridDimensions(dimensions);

    }

    @Override
    public void updatePathCoordinates (List<Coordinate<Integer>> pathCoordinates) {
    	pathDesign.updatePathCoordinates(pathCoordinates);
    }

    @Override
    public void updateNameDisplay (String name) {
        pathEditor.updatePathName(name);
    }

    @Override
    public void updateImagePathDisplay (String imagePath) {
       pathEditor.updatePathImagePath(imagePath);
       pathDesign.updateImagePathDisplay(imagePath);
    }

   

    @Override
    public void updateType (String pathType) {
        pathEditor.updataPathType(pathType);

    }

    @Override
    public void updatePath () {
        pathDesign.redrawPath();
    }
    
    @Override
    public void updateDeleteEntity (String entityID) {
        // TODO Auto-generated method stub        
    }

    @Override
    public void updateBank (List<Integer> ids) {
        
    }

    @Override
    public void setPathListDataSource (ListDataSource source) {
        // TODO Auto-generated method stub
        System.out.println("There is no path bank implemented");
    }

   
    
    @Override
    public void updateSizeDisplay (double size) {
    }

	@Override
	public Integer getNearestAvailableItemID(int id) {
		// TODO Auto-generated method stub
		return null;
	}




}
