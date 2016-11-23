package authoring.editorview.tower;

import authoring.editorview.tower.subviews.TowerImageBank;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


/**
 * 
 * @author Diane Hadley
 *
 */
public class TowerEditorView implements ITowerEditorView {
    private TowerEditorViewDelegate delegate;
    private BorderPane towerEditorView;
    private TowerImageBank towerBank;

    public TowerEditorView () {
        towerEditorView = new BorderPane();
        towerBank = new TowerImageBank();
    }

    @Override
    public Node getInstanceAsNode () {
        return towerEditorView;
    }

    public void getTowerSetter () {
        Group designTower = new Group();
        towerEditorView.setCenter(designTower);
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
        towerBank.setDelegate(delegate);
    }
}
