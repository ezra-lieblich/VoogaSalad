package authoring.editorview.path;


import authoring.editorview.path.subviews.PathChooser;

import java.util.List;

import authoring.editorview.path.subviews.NewPathView;
import authoring.editorview.path.subviews.PathBuilderView;
import authoring.editorview.path.subviews.PathImageView;
import authoring.editorview.path.subviews.PathNameView;
import authoring.editorview.path.subviews.PathSizeView;
import engine.path.Coordinate;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PathEditorView implements IPathUpdateView {
   

	private static final int BOX_SPACING = 10;
    
    private VBox pathView;
    private HBox pathSettings;
    
    private PathChooser pathChooser;
    private PathImageView pathImageView;
    private PathSizeView pathSizeView;
    private PathBuilderView pathBuilderView;
    private PathNameView pathNameView;
    private NewPathView newPathView;
    
   

    public PathEditorView (int aWidth, int aHeight) {
        this.pathView = new VBox();
        this.newPathView = new NewPathView();
        newPathView.setPathEditorView(this);
        this.pathChooser = new PathChooser();       
    	this.pathSizeView = new PathSizeView();
    	
    	this.pathImageView = new PathImageView();
    	this.pathBuilderView = new PathBuilderView();
    	formatPathGrid();
    	
    	this.pathNameView = new PathNameView();
        setView();
     
    }

	private void formatPathGrid() {
		pathBuilderView.setGridSize(pathSizeView.getNumberOfColumns(), pathSizeView.getNumberOfRows());	
	}
	
	

    @Override
    public Node getInstanceAsNode () {
        return pathView;
    }

    @Override
    public void setDelegate (PathEditorViewDelegate delegate) {
        pathChooser.setDelegate(delegate);
        pathBuilderView.setDelegate(delegate);
    }

    public void setActiveId(int pathID){
    	pathImageView.setActivePathId(pathID);
    	pathBuilderView.setActivePathId(pathID);
    	
    }
    
    public void setViewToEdit(){
    	VBox textFieldSettings = new VBox(BOX_SPACING);
        textFieldSettings.getChildren().addAll(pathSizeView.getInstanceAsNode(), 
        		pathNameView.getInstanceAsNode());
        pathSettings.getChildren().addAll(pathImageView.getInstanceAsNode(), textFieldSettings);
        
    }
    
    public void updateViewToEdit(){
    	
    }
    
    private void setView(){  	            
        VBox pathGetter = new VBox(BOX_SPACING);
        pathGetter.getChildren().addAll(newPathView.getInstanceAsNode(), pathChooser.getInstanceAsNode());       
        pathSettings = new HBox(BOX_SPACING*2);
        pathSettings.getChildren().add(pathGetter);       
        pathView.getChildren().addAll(pathSettings, pathBuilderView.getInstanceAsNode());            
    }

	@Override
	public void updatePathImage(String pathImage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNumColumns(int numColumns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNumRows(int numRows) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePathName(String pathName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePathCoordinates(List<Coordinate<Integer>> pathCoordinates) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNameDisplay(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateImagePathDisplay(String imagePath) {
		// TODO Auto-generated method stub
		
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
