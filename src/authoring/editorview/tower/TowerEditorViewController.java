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
    public int createNewTower () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setTowerName (String name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTowerImage (int imageID) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setBuyPrice (int price) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setSellPrice (int price) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setUnlockLevel (int level) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setFireRate (int fireRate) {
        // TODO Auto-generated method stub
        
    }

}
