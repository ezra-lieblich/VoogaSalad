package authoring.editorview.path;


import authoring.editorview.path.subviews.BackgroundImageView;
import authoring.editorview.path.subviews.PathBank;
import authoring.editorview.path.subviews.PathBuilderView;
import authoring.editorview.path.subviews.PathImageView;
import authoring.editorview.path.subviews.PathNameView;
import authoring.editorview.path.subviews.PathSizeView;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PathEditorView implements IPathEditorView {
   

	private static final int BOX_SPACING = 10;
    
    private BorderPane pathView;
    
    private PathBank pathBank;
    private BackgroundImageView backgroundImageView;
    private PathImageView pathImageView;
    private PathSizeView pathSizeView;
    private PathBuilderView pathBuilderView;
    private PathNameView pathNameView;
    
   

    public PathEditorView (int aWidth, int aHeight) {
        this.pathView = new BorderPane();
        pathBank = new PathBank();       
    	backgroundImageView = new BackgroundImageView();
    	pathSizeView = new PathSizeView();
    	
    	pathImageView = new PathImageView();
    	pathBuilderView = new PathBuilderView();
    	formatPathGrid();
    	
    	pathNameView = new PathNameView();
        setPathView();
     
    }

	private void formatPathGrid() {
		pathBuilderView.setGridSize(pathSizeView.getNumberOfColumns(), pathSizeView.getNumberOfRows());	
    	pathBuilderView.setBackgroundImage(backgroundImageView.getBackgroundImage());
	}

    @Override
    public Node getInstanceAsNode () {
        return pathView;
    }

    @Override
    public void setDelegate (PathEditorViewDelegate delegate) {
        backgroundImageView.setDelegate(delegate);
    }
    
    
    private void setPathView(){
    	     
        BorderPane editor = new BorderPane();
        editor.setCenter(pathBuilderView.getInstanceAsNode());
        
        VBox imageSettings = new VBox(10);
        imageSettings.getChildren().addAll(backgroundImageView.getInstanceAsNode(),
        		pathImageView.getInstanceAsNode());
        
        VBox textFieldSettings = new VBox(BOX_SPACING);
        textFieldSettings.getChildren().addAll(pathSizeView.getInstanceAsNode(), 
        		pathNameView.getInstanceAsNode());
        
        HBox pathSettings = new HBox(20);
        pathSettings.getChildren().addAll(imageSettings, textFieldSettings);
        
        editor.setTop(pathSettings);
        
        pathView.setCenter(editor);
        pathView.setLeft(pathBank.getInstanceAsNode());
            
    }
   

}
