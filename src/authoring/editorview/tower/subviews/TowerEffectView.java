package authoring.editorview.tower.subviews;

import java.io.IOException;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.editorview.tower.subviews.editorfields.TowerFrequencyField;
import authoring.editorview.tower.subviews.editorfields.TowerNameField;
import javafx.stage.FileChooser;


public class TowerEffectView extends PhotoFileChooser {

    private TowerEditorViewDelegate delegate;
    private TowerNameField towerName;
    private TowerFrequencyField towerFrequency;

    public TowerEffectView (TowerNameField towerName, TowerFrequencyField towerFrequency) {
        this.towerName = towerName;
        this.towerFrequency = towerFrequency;
    }

    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void openFileChooser (FileChooser chooseFile) throws IOException {
        // TODO Auto-generated method stub

    }

}
