package authoring.editorview.level.subviews;

import java.util.List;

import authoring.editorview.ImageBank;
import authoring.editorview.enemy.EnemyAuthoringViewDelegate;
import authoring.editorview.level.LevelAuthoringViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.control.Button;


public class LevelBank extends ImageBank {
	private LevelAuthoringViewDelegate delegate;
	
    public LevelBank () {
        super();
        Button newEnemyButton = ButtonFactory.makeButton("New Level", e -> {
            delegate.onUserEnteredCreateLevel();
        });
        this.items.add(newEnemyButton);
        this.CONTENT_OFFSET = 1;
    }

    public void setDelegate (LevelAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    public void updateEnemyBank (List<Integer> activeEnemies) {
        super.updateBank(activeEnemies);
    }

    @Override
    protected void userSelectedRow (int index) {
        int selectedLevel = this.itemIDs.get(index);
        if (selectedLevel != -1)
            this.delegate.onUserSelectedLevel(selectedLevel);
    }
}
