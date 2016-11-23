package authoring.editorview.tower;

import java.io.IOException;
import authoring.editorview.tower.subviews.TowerEffectView;
import authoring.editorview.tower.subviews.TowerImageBank;
import authoring.editorview.tower.subviews.editorfields.TowerFrequencyField;
import authoring.editorview.tower.subviews.editorfields.TowerImageView;
import authoring.editorview.tower.subviews.editorfields.TowerNameField;
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
    private TowerImageView towerImage;

    public TowerEditorView () throws IOException {
        towerEditorView = new BorderPane();
        towerBank = new TowerImageBank();
        towerName = new TowerNameField();
        towerFrequency = new TowerFrequencyField();
        towerImage = new TowerImageView();
        towerEffectView = new TowerEffectView(towerName, towerFrequency, towerImage);
    }

    @Override
    public Node getInstanceAsNode () {
        return towerEditorView;
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
