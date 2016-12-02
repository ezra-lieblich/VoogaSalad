package authoring.editorview.level;

import javafx.beans.property.SimpleStringProperty;


public class Enemy {

    private final SimpleStringProperty enemyName;
    private final SimpleStringProperty enemyFrequency;
    private final SimpleStringProperty numOfEnemies;

    public Enemy (String enemyName, String enemyFrequency, String numOfEnemies) {
        this.enemyName = new SimpleStringProperty(enemyName);
        this.enemyFrequency = new SimpleStringProperty(enemyFrequency);
        this.numOfEnemies = new SimpleStringProperty(numOfEnemies);
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
}
