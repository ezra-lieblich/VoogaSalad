package authoring.editorview.level;

import java.util.List;
import authoring.editorview.IUpdateView;
import authoring.editorview.ListDataSource;
import authoring.editorview.path.NameIdPair;


public interface ILevelUpdateView extends ILevelSetView, IUpdateView {

    public void updateRewardScore (double winPoints);

    public void updateRewardHealth (double winHealth);

    public void updateRewardMoney (double winMoney);

    public void updateTransitionTime (double time);

    public void updateLevelOptions (List<Integer> levelOptions);

    public void setLevelListDataSource (ListDataSource source);

    // Wave Object Updates

    public void updateWaveNumber (int waveNumber);

    public void updateEnemyNames (List<NameIdPair> list);

    public void updateNumberOfEnemies (int numEnemies);

    public void updateEnemyFrequency (double enemyFrequency);

    public void updateWavePath (int pathID);

    public void updateWaveTimeDelay (double timeDelay);

    public void updateWaves (List<WaveObject> waves);

}
