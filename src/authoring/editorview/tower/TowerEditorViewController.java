package authoring.editorview.tower;

import authoring.editorview.EditorViewController;


public class TowerEditorViewController extends EditorViewController
        implements TowerEditorViewDelegate {

    public TowerEditorViewController (int editorWidth, int editorHeight) {
        ITowerEditorView myView = TowerEditorViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        this.view = myView;
    }

    @Override
    public void setTowerCost (double cost) {
        // TODO Auto-generated method stub
        
    }
}
