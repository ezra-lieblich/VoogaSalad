package authoring.editorview.tower.subviews;

import authoring.editorview.tower.TowerEditorViewDelegate;
import javafx.scene.control.ScrollPane;


public class TowerImageBank {

    private TowerEditorViewDelegate delegate;
    private ScrollPane towerBank;

    public TowerImageBank () {
        towerBank = new ScrollPane();
    }

    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

}
