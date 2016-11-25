package authoring.editorview.enemy;

import java.util.List;


/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public interface IEnemyUpdateView extends IEnemyEditorView {

    public void updateFrequencyDisplay (int frequency);

    public void updateEnemyImagePath (String imagePath);

    public void updateEnemyName (String enemyName);

    public void updateEnemyReactions (String enemyReactions);

    public void updateEnemySpeed (int speed);

    public void updateEnemyBank (List<Integer> activeEnemies);

    public void createNewEnemy ();

    public void updateEnemyHealthDisplay (int enemyHealth);

    public void updateEnemyDamage (int damage);

    public void updateEnemyRewardMoney (int rewardMoney);

    public void updateEnemyRewardPoints (int rewardPoints);

    public void updateEnemyCollisionEffect (String collisionEffect);

}
