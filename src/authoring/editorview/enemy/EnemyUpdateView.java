package authoring.editorview.enemy;

import java.util.List;
import authoring.editorview.IUpdateView;


/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public interface EnemyUpdateView extends IUpdateView {

    public void updateEnemySpeed (double speed);

    public void updateEnemyBank (List<Integer> activeEnemies);

    public void updateEnemyHealthDisplay (double enemyHealth);

    public void updateEnemyDamage (double damage);

    public void updateEnemyRewardMoney (double rewardMoney);

    public void updateEnemyRewardPoints (double rewardPoints);

}
