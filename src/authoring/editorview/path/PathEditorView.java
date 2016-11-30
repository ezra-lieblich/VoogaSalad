package authoring.editorview.path;


import authoring.editorview.path.subviews.PathChooser;
import authoring.editorview.path.subviews.PathGrid;

import java.io.File;
import java.util.List;

import authoring.editorview.path.subviews.NewPathView;
import authoring.editorview.path.subviews.PathInstructionsView;
import authoring.editorview.path.subviews.PathImageView;
import authoring.editorview.path.subviews.PathNameView;
import authoring.editorview.path.subviews.PathSizeView;
import engine.path.Coordinate;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PathEditorView implements IPathUpdateView {
   

	private static final int BOX_SPACING = 10;
    
	private Group root;
    private HBox pathSettings;
    
    private PathChooser pathChooser;
    private PathImageView pathImageView;
    private PathSizeView pathSizeView;
    private PathInstructionsView pathInstructionsView;
    private PathNameView pathNameView;
    private NewPathView newPathView;
    private PathGrid pathGrid;
    
   

    public PathEditorView (int aWidth, int aHeight) {
    	this.root = new Group();       
    	
    	this.newPathView = new NewPathView();
        this.pathChooser = new PathChooser();       
    	this.pathSizeView = new PathSizeView();
    	this.pathNameView = new PathNameView();
    	this.pathImageView = new PathImageView();
    	this.pathInstructionsView = new PathInstructionsView();
    	
    	
    	//System.out.println(f.toURI().toString());
    	
    	
    	
    	this.pathGrid = new PathGrid(400, 400);   	
    	
    	formatPathGrid(); 	
        setViewForDefaultPath();
     
    }

	private void formatPathGrid() {
		pathGrid.setNumColumns(pathSizeView.getNumberOfColumns());	
		pathGrid.setNumRows(pathSizeView.getNumberOfRows());
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
        pathSizeView.setDelegate(delegate);
        pathNameView.setDelegate(delegate);
        pathImageView.setDelegate(delegate);
    }

    
    @Override
	public void updateActiveID(int pathID) {
    	pathChooser.setActivePathId(pathID);
    	pathGrid.setActivePathId(pathID);
    	pathImageView.setActivePathId(pathID); 	
    	pathSizeView.setActivePathId(pathID);   	
    	pathNameView.setActivePathId(pathID);
		
	}
    

    private void setViewForDefaultPath(){  	 
    	
    	pathSettings = new HBox(20);
    	 	
        VBox pathGetter = new VBox(BOX_SPACING);
        pathGetter.getChildren().addAll(newPathView.getInstanceAsNode(), pathChooser.getInstanceAsNode());   
        pathSettings.getChildren().add(pathGetter);
         
        VBox textFieldSettings = new VBox(BOX_SPACING);
        textFieldSettings.getChildren().addAll(pathSizeView.getInstanceAsNode(), 
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
	public void updatePathImage(String pathImage) {
		pathImageView.setPathImagePath(pathImage);
	//	pathGrid.setCellImage();
		
	}

	@Override
	public void updateNumColumns(int numColumns) {
		pathSizeView.setNumberOfColumns(numColumns);
		pathGrid.setNumColumns(numColumns);
		
	}

	@Override
	public void updateNumRows(int numRows) {
		pathSizeView.setNumberOfRows(numRows);
		pathGrid.setNumRows(numRows);
		
	}

	@Override
	public void updatePathCoordinates(List<Coordinate<Integer>> pathCoordinates) {
		pathGrid.setPathCoordinates(pathCoordinates);
		
	}

	@Override
	public void updateNameDisplay(String name) {
		pathNameView.setName(name);
		pathChooser.updatePathComboBox(name);
		
	}

	@Override
	public void updateImagePathDisplay(String imagePath) {
		pathImageView.setPathImagePath(imagePath);
		
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
	public void createNewPath() {
		
		
	}

	

	
   

}
