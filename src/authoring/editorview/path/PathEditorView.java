package authoring.editorview.path;


import authoring.editorview.path.subviews.BackgroundImageView;
import authoring.editorview.path.subviews.PathBank;
import authoring.editorview.path.subviews.PathBuilderView;
import authoring.editorview.path.subviews.PathImageView;
import authoring.editorview.path.subviews.PathSizeView;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class PathEditorView implements IPathEditorView {
   
	private PathEditorViewDelegate delegate;
	private static final int BOX_SPACING = 10;
    
    private BorderPane pathView;
    
    private PathBank pathBank;
    private BackgroundImageView backgroundImageView;
    private PathImageView pathImageView;
    private PathSizeView pathSizeView;
    private PathBuilderView pathBuilderView;
    
   

    public PathEditorView (int aWidth, int aHeight) {
        this.pathView = new BorderPane();
        setPathView();
     
    }

    @Override
    public Node getInstanceAsNode () {
        return pathView;
    }

    @Override
    public void setDelegate (PathEditorViewDelegate delegate) {
        this.delegate = delegate;
    }
    
    private void setPathView(){
    	pathBank = new PathBank();       
    	backgroundImageView = new BackgroundImageView();
    	pathSizeView = new PathSizeView();
    	pathImageView = new PathImageView();
    	pathBuilderView = new PathBuilderView();
    	
        pathView.setLeft(pathBank.getInstanceAsNode());
        
        BorderPane editor = new BorderPane();
        editor.setCenter(pathBuilderView.getInstanceAsNode());
        
        VBox pathSettings = new VBox(BOX_SPACING);
        pathSettings.getChildren().addAll(pathSizeView.getInstanceAsNode(),
        		backgroundImageView.getInstanceAsNode(),
        		pathImageView.getInstanceAsNode()      		
        );
        
        editor.setLeft(pathSettings);
        
        pathView.setCenter(editor);
        
        
        
    }
    

}
