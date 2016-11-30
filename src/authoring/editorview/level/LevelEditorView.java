package authoring.editorview.level;

import java.util.Map;

import authoring.editorview.level.subviews.LevelChooserView;
import authoring.editorview.level.subviews.LevelDesign;
import authoring.editorview.level.subviews.LevelNameView;
import authoring.editorview.level.subviews.LevelRewardsView;
import javafx.scene.Node;
import javafx.scene.layout.VBox;


public class LevelEditorView implements ILevelUpdateView {
    
    private VBox root;
    private LevelChooserView levelChooser;
    private LevelDesign levelDesign;
    private LevelRewardsView levelRewardsView;
    private LevelNameView levelNameView;

    LevelEditorView (int width, int height) {
        this.root = new VBox();
        this.levelChooser = new LevelChooserView();
        this.levelDesign = new LevelDesign();
        this.levelRewardsView = new LevelRewardsView();
        this.levelNameView = new LevelNameView();
        setLevelView();
       
    }

    @Override
    public Node getInstanceAsNode () {
        return root;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        levelNameView.setDelegate(delegate);
    }
    
    
    
    private void setLevelView(){
	       
        root.getChildren().addAll(levelChooser.getInstanceAsNode(), levelRewardsView.getInstanceAsNode(),
        		levelDesign.getInstanceAsNode());
       
            
    }

	@Override
	public void updateNameDisplay(String name) {
		levelNameView.setLevelName(name);
		//also level chooser
		
	}

	@Override
	public void updateImagePathDisplay(String imagePath) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSizeDisplay(double size) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEnemy(Map<Integer, Integer> enemyCounts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRewardPoints(double winPoints) {
		levelRewardsView.setRewardPoints(winPoints);
		
	}

	@Override
	public void updateRewardHealth(double winHealth) {
		levelRewardsView.setRewardHealth(winHealth);
		
	}

	@Override
	public void updateRewardMoney(double winMoney) {
		levelRewardsView.setRewardMoney(winMoney);
		
	}

	@Override
	public void updatePath(int pathID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTransitionTime(double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEnemyFrequency(double enemyFrequency) {
		// TODO Auto-generated method stub
		
	}

}
