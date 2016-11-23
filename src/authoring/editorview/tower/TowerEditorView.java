package authoring.editorview.tower;

import authoring.editorview.tower.subviews.TowerEffectView;
import authoring.editorview.tower.subviews.TowerFrequencyField;
import authoring.editorview.tower.subviews.TowerImageBank;
import authoring.editorview.tower.subviews.TowerNameField;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


/**
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */
public class TowerEditorView implements ITowerEditorView {
    private TowerEditorViewDelegate delegate;
    private BorderPane towerEditorView;
    private TowerImageBank towerBank;
    private TowerNameField towerName;
    private TowerEffectView towerEffectView;
    private TowerFrequencyField towerFrequency;

    public TowerEditorView () {
        towerEditorView = new BorderPane();
        towerBank = new TowerImageBank();
        towerName = new TowerNameField();
        towerFrequency = new TowerFrequencyField();
        towerEffectView = new TowerEffectView(towerName, towerFrequency);
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
        towerEffectView.setDelegate(delegate);
        towerName.setDelegate(delegate);
        towerFrequency.setDelegate(delegate);
    }
}
