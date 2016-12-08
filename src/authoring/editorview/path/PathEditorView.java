package authoring.editorview.path;


import authoring.editorview.path.subviews.NewPathView;
import authoring.editorview.path.subviews.PathChooser;

import java.util.List;
import java.util.ResourceBundle;

import authoring.editorview.ListDataSource;
import authoring.editorview.path.subviews.PathInstructionsView;
import authoring.editorview.path.subviews.editorfields.PathGrid;
import authoring.editorview.path.subviews.editorfields.PathImageView;
import authoring.editorview.path.subviews.editorfields.PathNameView;
import authoring.editorview.path.subviews.editorfields.PathDimensionsView;
import engine.path.Coordinate;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PathEditorView implements IPathEditorView {
   

	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	private static final int BOX_SPACING = 10;
    
	private Group root;
    private HBox pathSettings;
    
    private PathChooser pathChooser;
    private PathImageView pathImageView;
    private PathDimensionsView pathDimensionsView;
    private PathInstructionsView pathInstructionsView;
    private PathNameView pathNameView;
    private NewPathView newPathView;
    private PathGrid pathGrid;
    
   

    public PathEditorView (int aWidth, int aHeight) {
    	this.root = new Group();       
    	
    	this.newPathView = new NewPathView();
        this.pathChooser = new PathChooser();       
    	this.pathDimensionsView = new PathDimensionsView();
    	this.pathNameView = new PathNameView(pathResource);
    	this.pathImageView = new PathImageView();
    	this.pathInstructionsView = new PathInstructionsView();
    	this.pathGrid = new PathGrid(400);   	
   
        setViewForDefaultPath();
     
    }

    @Override
    public Node getInstanceAsNode () {
        return root;
    }

    @Override
    public void setDelegate (PathEditorViewDelegate delegate) {
        pathChooser.setDelegate(delegate);
        pathGrid.setDelegate(delegate);
        newPathView.setDelegate(delegate);
        pathDimensionsView.setDelegate(delegate);
        pathNameView.setDelegate(delegate);
        pathImageView.setDelegate(delegate);
    }

    
    @Override
	public void updateActiveID(int pathID) {
    	pathChooser.setActivePathId(pathID);
	}
    

    private void setViewForDefaultPath(){  	 
    	
    	pathSettings = new HBox(20);
    	 	
        VBox pathGetter = new VBox(BOX_SPACING);
        pathGetter.getChildren().addAll(newPathView.getInstanceAsNode(), pathChooser.getInstanceAsNode());   
        pathSettings.getChildren().add(pathGetter);
         
        VBox textFieldSettings = new VBox(BOX_SPACING);
        textFieldSettings.getChildren().addAll(pathDimensionsView.getInstanceAsNode(), 
        		pathNameView.getInstanceAsNode());
        pathSettings.getChildren().addAll(textFieldSettings, pathImageView.getInstanceAsNode());  
        
        Node instructions = pathInstructionsView.getInstanceAsNode();
        instructions.setLayoutX(20);
        instructions.setLayoutY(150);
        
        Node grid = pathGrid.getInstanceAsNode();
        grid.setLayoutX(100);
        grid.setLayoutY(200);
        
		root.getChildren().addAll(pathSettings, instructions, 
				grid);
    }
	
	@Override
	public void updateGridDimensions(int dimensions) {
		pathDimensionsView.setGridDimensions(dimensions);
		pathGrid.setGridDimensions(dimensions);
	
		
	}

	@Override
	public void updatePathCoordinates(List<Coordinate<Integer>> pathCoordinates) {
		pathGrid.setPathCoordinates(pathCoordinates);
		
	}

	@Override
	public void updateNameDisplay(String name) {
		pathNameView.updateName(name);
		pathChooser.updatePathComboBox(name);
		
	}

	@Override
	public void updateImagePathDisplay(String imagePath) {
		pathImageView.setPathImagePath(imagePath);
		pathGrid.setCellImage(imagePath);		
	}

	@Override
	public void updateSizeDisplay(double size) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateType(String pathType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePath() {
		pathGrid.redrawPath();		
	}

	@Override
	public void updateBank(List<Integer> ids) {
		// TODO Auto-generated method stub
		System.out.println("There is no path bank implemented");
	}

	@Override
	public void setPathListDataSource(ListDataSource source) {
		// TODO Auto-generated method stub
		System.out.println("There is no path bank implemented");
	}


	

}
