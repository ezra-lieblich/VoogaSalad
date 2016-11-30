package authoring.editorview.path;


import authoring.editorview.path.subviews.PathChooser;
import authoring.editorview.path.subviews.PathGrid;

import java.util.List;

import authoring.editorview.path.subviews.NewPathView;
import authoring.editorview.path.subviews.PathInstructionsView;
import authoring.editorview.path.subviews.PathImageView;
import authoring.editorview.path.subviews.PathNameView;
import authoring.editorview.path.subviews.PathSizeView;
import engine.path.Coordinate;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PathEditorView implements IPathUpdateView {
   

	private static final int BOX_SPACING = 10;
    
	private BorderPane root;
    private VBox pathEditView;
    private HBox pathSettings;
    
    private PathChooser pathChooser;
    private PathImageView pathImageView;
    private PathSizeView pathSizeView;
    private PathInstructionsView pathInstructionsView;
    private PathNameView pathNameView;
    private NewPathView newPathView;
    private PathGrid pathGrid;
    
   

    public PathEditorView (int aWidth, int aHeight) {
    	this.root = new BorderPane();       
    	this.pathEditView = new VBox(30);
       
    	this.newPathView = new NewPathView();
        newPathView.setPathEditorView(this);
        this.pathChooser = new PathChooser();       
    	this.pathSizeView = new PathSizeView();
    	this.pathNameView = new PathNameView();
    	this.pathImageView = new PathImageView();
    	this.pathInstructionsView = new PathInstructionsView();
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
    }

    public void setActiveId(int pathID){
    	pathImageView.setActivePathId(pathID);
    	pathGrid.setActivePathId(pathID);
    	
    }
    

    private void setViewForDefaultPath(){  	 
    	
        VBox pathGetter = new VBox(BOX_SPACING);
        pathGetter.getChildren().addAll(newPathView.getInstanceAsNode(), pathChooser.getInstanceAsNode());   
        root.setLeft(pathGetter);
        
        pathSettings = new HBox(BOX_SPACING*2);       
    
        VBox textFieldSettings = new VBox(BOX_SPACING);
        textFieldSettings.getChildren().addAll(pathSizeView.getInstanceAsNode(), 
        		pathNameView.getInstanceAsNode());
        pathSettings.getChildren().addAll(pathImageView.getInstanceAsNode(), textFieldSettings);  
        
		pathEditView.getChildren().addAll(pathSettings, pathInstructionsView.getInstanceAsNode(), 
				pathGrid.getInstanceAsNode());
		root.setRight(pathEditView);
    }

	@Override
	public void updatePathImage(String pathImage) {
		pathImageView.setPathImagePath(pathImage);
		
	}

	@Override
	public void updateNumColumns(int numColumns) {
		pathSizeView.setNumColumns(Integer.toString(numColumns));
		
	}

	@Override
	public void updateNumRows(int numRows) {
		pathSizeView.setNumRows(Integer.toString(numRows));
		
	}

	@Override
	public void updatePathName(String pathName) {
		pathNameView.setName(pathName);
		
	}

	@Override
	public void updatePathCoordinates(List<Coordinate<Integer>> pathCoordinates) {
		pathGrid.setPathCoordinates(pathCoordinates);
		
	}

	@Override
	public void updateNameDisplay(String name) {
		pathNameView.setName(name);
		
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

	

	
   

}
