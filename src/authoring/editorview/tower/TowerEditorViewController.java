package authoring.editorview.tower;

import authoring.editorview.EditorViewController;


public class TowerEditorViewController extends EditorViewController
        implements TowerEditorViewDelegate {
	
	private TowerDataSource towerDataSource;

    public TowerEditorViewController (int editorWidth, int editorHeight) {
        ITowerEditorView myView = TowerEditorViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        this.view = myView;
    }


    public void setTowerDataSource(TowerDataSource source){
    	this.towerDataSource = source;
    }


	@Override
	public int onUserPressedCreateNewTower() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void onUserEnteredName(String name) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onUserEnteredTowerImage(String imageID) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onUserEnteredBuyPrice(String price) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onUserEnteredSellPrice(String price) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onUserEnteredUnlockLevel(String level) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onUserEnteredFireRate(String fireRate) {
		// TODO Auto-generated method stub
		
	}

}
