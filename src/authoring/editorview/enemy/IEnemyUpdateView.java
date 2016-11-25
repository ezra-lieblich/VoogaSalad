package authoring.editorview.enemy;

import java.util.List;


public interface IEnemyUpdateView extends IEnemyEditorView {

    public void updateFrequencyDisplay (int frequency);

    public void updateEnemyImagePath (String imagePath);

    public void updateEnemyName (String enemyName);

    public void updateEnemyReactions (String enemyReactions);

    public void updateEnemySpeed (int speed);

    public void updateEnemyBank (List<Integer> activeEnemies);

    public void createNewEnemy ();

}
