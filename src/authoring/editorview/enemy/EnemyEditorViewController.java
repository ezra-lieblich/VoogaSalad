package authoring.editorview.enemy;

import java.io.IOException;
import authoring.editorview.EditorViewController;


public class EnemyEditorViewController extends EditorViewController
        implements EnemyEditorViewDelegate {

    private EnemyDataSource enemyDataSource;
    private int currentEnemyID;

    public EnemyEditorViewController (int editorWidth, int editorHeight) throws IOException {
        IEnemyEditorView myView = EnemyEditorViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        this.view = myView;
    }

    public void setEnemyDataSource (EnemyDataSource source) {
        this.enemyDataSource = source;
    }

	@Override
	public void onUserPressedCreateEnemy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredEnemySpeed(String speed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredEnemyHealth(String health) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredEnemyDamage(String damage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredEnemyPoints(String points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredEnemyMoney(String money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredEnemyCollisionEffect(String collisionEffect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredEnemyImagePath(String imagePath) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public void onUserEnteredEnemyName (String enemyName) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onUserEnteredEnemyFrequency (String frequency) {
        // TODO Auto-generated method stub
        
    }


}
