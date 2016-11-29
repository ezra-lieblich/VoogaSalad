package authoring.editorview.path;


import authoring.editorview.path.subviews.PathChooser;

import java.util.List;

import authoring.editorview.path.subviews.NewPathView;
import authoring.editorview.path.subviews.PathBuilderView;
import authoring.editorview.path.subviews.PathImageView;
import authoring.editorview.path.subviews.PathNameView;
import authoring.editorview.path.subviews.PathSizeView;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PathEditorView implements IPathEditorView {
   

	private static final int BOX_SPACING = 10;
    
    private VBox pathView;
    
    private PathChooser pathChooser;
    private PathImageView pathImageView;
    private PathSizeView pathSizeView;
    private PathBuilderView pathBuilderView;
    private PathNameView pathNameView;
    private NewPathView newPathView;
    
   

    public PathEditorView (int aWidth, int aHeight) {
        this.pathView = new VBox();
        this.newPathView = new NewPathView();
        this.pathChooser = new PathChooser();       
    	this.pathSizeView = new PathSizeView();
    	
    	this.pathImageView = new PathImageView();
    	this.pathBuilderView = new PathBuilderView();
    	formatPathGrid();
    	
    	this.pathNameView = new PathNameView();
        setPathView();
     
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
    }
    
    public void setPathImage(String imagePath){
    	
    }
    
    public void setNumColumns(int numColumns){
    	
    }
    
    public void setNumRows(int numRows){
    	
    }
    
    public void setPathName(String pathName){
    	
    }
    
    public void setPathCoordinates(List<Coordinate> pathCoordinates){
    	
    }
    
    public void setActiveId(int pathID){
    	pathImageView.setActivePathId(pathID);
    	
    }
    
    private void setPathView(){
    	         
        VBox textFieldSettings = new VBox(BOX_SPACING);
        textFieldSettings.getChildren().addAll(pathSizeView.getInstanceAsNode(), 
        		pathNameView.getInstanceAsNode());
        
        VBox pathGetter = new VBox(BOX_SPACING);
        pathGetter.getChildren().addAll(newPathView.getInstanceAsNode(), pathChooser.getInstanceAsNode());
        
        HBox pathSettings = new HBox(BOX_SPACING*2);
        pathSettings.getChildren().addAll(pathGetter, pathImageView.getInstanceAsNode(), textFieldSettings);
        
        pathView.getChildren().addAll(pathSettings, pathBuilderView.getInstanceAsNode());
        
            
    }
   

}
