package authoringview;

import authoringview.editortabpane.EditorTabPaneFactory;
import authoringview.editortabpane.IEditorTabPane;
import authoringview.path.IPathEditorView;
import authoringview.path.PathEditorViewFactory;
import authoringview.toolbar.IToolbar;
import authoringview.toolbar.ToolbarFactory;
import authoringview.tower.ITowerEditorView;
import authoringview.tower.TowerEditorViewFactory;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class AuthoringView implements IAuthoringView {

    private Scene myScene;
    private Group myRoot;
    private IToolbar myToolbar;
    private IEditorTabPane mySideTabbedToolbar;
    private static final int SIZE = 700;
    private BorderPane authoringView;
    private ITowerEditorView towerView;
    private IPathEditorView pathView;
    
    public AuthoringView() {
        towerView = TowerEditorViewFactory.build();
        pathView = PathEditorViewFactory.build(SIZE, SIZE);
        myRoot = new Group();
        myScene = new Scene(myRoot, SIZE, SIZE);
        myToolbar = ToolbarFactory.build(SIZE, SIZE/20);
        mySideTabbedToolbar = EditorTabPaneFactory.build(SIZE, SIZE);
        authoringView = new BorderPane();
        myRoot.getChildren().add(authoringView);
        initScene();
    }
    
    private void initScene() {
        authoringView.setTop(myToolbar.getInstanceAsNode());
        authoringView.setRight(mySideTabbedToolbar.getInstanceAsNode());
        authoringView.setCenter(createTempMidScreen());
    }
    
    private Pane createTempMidScreen() {
        Pane tempmid = new Pane();
        //change back here for tower
        Node pathViewNode = pathView.getInstanceAsNode();
        tempmid.getChildren().add(pathViewNode);
        tempmid.setMaxSize(SIZE*9/10, SIZE);
        tempmid.setPrefSize(SIZE*7.9/10, SIZE*19/20);
        return tempmid;
    }
    
    @Override
    public Scene getScene () {
        return myScene;
    }

    @Override
    public Group getMyRoot () {
        return myRoot;
    }

}
