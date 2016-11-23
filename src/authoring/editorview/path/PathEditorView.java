package authoring.editorview.path;

import java.util.ResourceBundle;

import authoring.editorview.path.subviews.BackgroundImageView;
import authoring.editorview.path.subviews.PathBank;
import authoring.editorview.path.subviews.PathBuilderView;
import authoring.editorview.path.subviews.PathImageView;
import authoring.editorview.path.subviews.PathSizeView;
import gameplayer.view.GridGUI;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class PathEditorView implements IPathEditorView {
   
	private PathEditorViewDelegate delegate;
    
    private BorderPane pathView;
    
    private PathBank pathBank;
    private BackgroundImageView backgroundImageView;
    private PathImageView pathImageView;
    private PathSizeView pathSizeView;
    private PathBuilderView pathBuilderView;
    
    private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);

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
    	pathBank = new PathBank(pathResource);       
    	backgroundImageView = new BackgroundImageView();
    	pathSizeView = new PathSizeView();
    	pathImageView = new PathImageView();
    	pathBuilderView = new PathBuilderView();
    	
        pathView.setLeft(pathBank.getInstanceAsNode());
        
        BorderPane editor = new BorderPane();
        editor.setCenter(pathBuilderView.getInstanceAsNode());
        
        HBox pathSettings = new HBox();
        pathSettings.getChildren().addAll(pathImageView.getInstanceAsNode(),
        		pathSizeView.getInstanceAsNode(),
        		backgroundImageView.getInstanceAsNode());
        
        editor.setLeft(pathSettings);
        
        pathView.setCenter(editor);
        
        
        
    }
    

}
