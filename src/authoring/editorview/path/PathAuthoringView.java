package authoring.editorview.path;

import authoring.editorview.path.subviews.NewPathView;
import authoring.editorview.path.subviews.PathChooser;
import authoring.editorview.path.subviews.PathDesignView;
import authoring.editorview.path.subviews.PathEditorView;

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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;


public class PathAuthoringView implements IPathUpdateView {

    private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";
    private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);

    private static final int BOX_SPACING = 10;
    private static final int GRID_SIZE = 400;
    private static final int EDITOR_SIZE = 250;
    private static final int AUTHORING_HEIGHT = 700;

    private Group root;
    private HBox pathSettings;

    private PathEditorView pathEditor;
    private PathDesignView pathDesign;
    private GridPane pathView;
    
    
    
    
    private PathChooser pathChooser;
    
    private PathDimensionsView pathDimensionsView;
    private PathInstructionsView pathInstructionsView;
    private PathNameView pathNameView;
    private NewPathView newPathView;
    private PathGrid pathGrid;

    public PathAuthoringView (int aWidth, int aHeight) {
        
    	pathView = new GridPane();
    	
    	pathEditor = new PathEditorView(EDITOR_SIZE);
    	pathDesign = new PathDesignView();
    	buildView();
    	
    	
    	this.root = new Group();
        this.newPathView = new NewPathView();
        this.pathChooser = new PathChooser();
        this.pathDimensionsView = new PathDimensionsView();
        this.pathNameView = new PathNameView(pathResource);
        
        this.pathInstructionsView = new PathInstructionsView();
        this.pathGrid = new PathGrid(GRID_SIZE);
  //      setViewForDefaultPath();
    }

    @Override
    public Node getInstanceAsNode () {
        return root;
    }

    @Override
    public void setDelegate (PathAuthoringViewDelegate delegate) {
        pathChooser.setDelegate(delegate);
        pathGrid.setDelegate(delegate);
        newPathView.setDelegate(delegate);
        pathDimensionsView.setDelegate(delegate);
        pathNameView.setDelegate(delegate);
        
    }

    @Override
    public void updateActiveID (int pathID) {
        pathChooser.setActivePathId(pathID);
    }

    
    private void buildView () {

        ColumnConstraints editorColumn = new ColumnConstraints();
        editorColumn.setMinWidth(EDITOR_SIZE);
       
        ColumnConstraints previewColumn = new ColumnConstraints();
        RowConstraints fullRow = new RowConstraints();
        
        fullRow.setMinHeight(AUTHORING_HEIGHT);
        
        pathView.getColumnConstraints().addAll(editorColumn, previewColumn);
        pathView.getRowConstraints().add(fullRow);
        
        pathView.add(pathEditor.getInstanceAsNode(), 0, 0);
        //pathView.add(pathDesign.getInstanceAsNode(), 1, 0);
    }
    
    
//    private void setViewForDefaultPath () {
//
//        pathSettings = new HBox(20);
//
//        VBox pathGetter = new VBox(BOX_SPACING);
//        pathGetter.getChildren().addAll(newPathView.getInstanceAsNode(),
//                                        pathChooser.getInstanceAsNode());
//        pathSettings.getChildren().add(pathGetter);
//
//        VBox textFieldSettings = new VBox(BOX_SPACING);
//        textFieldSettings.getChildren().addAll(pathDimensionsView.getInstanceAsNode(),
//                                               pathNameView.getInstanceAsNode());
//        pathSettings.getChildren().addAll(textFieldSettings, pathImageView.getInstanceAsNode());
//
//        Node instructions = pathInstructionsView.getInstanceAsNode();
//        instructions.setLayoutX(20);
//        instructions.setLayoutY(150);
//
//        Node grid = pathGrid.getInstanceAsNode();
//        grid.setLayoutX(100);
//        grid.setLayoutY(200);
//
//        root.getChildren().addAll(pathSettings, instructions,
//                                  grid);
//    }

    @Override
    public void updateGridDimensions (int dimensions) {
        pathDimensionsView.setGridDimensions(dimensions);
        pathGrid.setGridDimensions(dimensions);

    }

    @Override
    public void updatePathCoordinates (List<Coordinate<Integer>> pathCoordinates) {
        pathGrid.setPathCoordinates(pathCoordinates);

    }

    @Override
    public void updateNameDisplay (String name) {
        pathNameView.updateName(name);
        pathChooser.updatePathComboBox(name);

    }

    @Override
    public void updateImagePathDisplay (String imagePath) {
 //       pathImageView.setPathImagePath(imagePath);
        pathGrid.setCellImage(imagePath);
    }

   

    @Override
    public void updateType (String pathType) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updatePath () {
        pathGrid.redrawPath();

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
    public void updateDeleteEntity (String entityID) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void updateSizeDisplay (double size) {
    }




}
