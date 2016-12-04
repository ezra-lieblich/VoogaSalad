package authoring.editorview.level;

import javafx.beans.property.SimpleStringProperty;


public class WaveObject {

    private final SimpleStringProperty enemyName;
    private final SimpleStringProperty enemyFrequency;
    private final SimpleStringProperty numOfEnemies;
    private final SimpleStringProperty waveNumber;
    private final SimpleStringProperty path;
    private final SimpleStringProperty timeDelay;

    public WaveObject (String waveNumber,
                       String enemyName,
                       String enemyFrequency,
                       String numOfEnemies,
                       String path,
                       String timeDelay) {
        this.enemyName = new SimpleStringProperty(enemyName);
        this.enemyFrequency = new SimpleStringProperty(enemyFrequency);
        this.numOfEnemies = new SimpleStringProperty(numOfEnemies);
        this.waveNumber = new SimpleStringProperty(waveNumber);
        this.path = new SimpleStringProperty(path);
        this.timeDelay = new SimpleStringProperty(timeDelay);
    }

    public String getEnemyName () {
        return enemyName.get();
    }

    public void setEnemyName (String enemyName) {
        this.enemyName.set(enemyName);
    }

    public String getEnemyFrequency () {
        return enemyFrequency.get();
    }

    public void setEnemyFrequency (String enemyFrequency) {
        this.enemyFrequency.set(enemyFrequency);
    }

    public String getNumOfEnemies () {
        return numOfEnemies.get();
    }

    public void setNumOfEnemies (String numOfEnemies) {
        this.numOfEnemies.set(numOfEnemies);
    }

    public String getWaveNumber () {
        return waveNumber.get();
    }

    public void setWaveNumber (String waveNumber) {
        this.waveNumber.set(waveNumber);
    }

    public String getPath () {
        return path.get();
    }

    public void setPath (String path) {
        this.path.set(path);
    }

    public String getTimeDelay () {
        return timeDelay.get();
    }

    public void setTimeDelay (String timeDelay) {
        this.timeDelay.set(timeDelay);
    }
}
