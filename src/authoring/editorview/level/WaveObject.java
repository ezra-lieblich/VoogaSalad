package authoring.editorview.level;

import engine.level.wave.Wave;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class WaveObject implements Wave {

    private SimpleIntegerProperty waveNumber;
    private SimpleIntegerProperty enemyID;
    private SimpleIntegerProperty enemyCount;
    private SimpleDoubleProperty enemyFrequency;
    private SimpleIntegerProperty pathID;
    private SimpleDoubleProperty startTime;

    public WaveObject (int waveNumber,
                       int enemyID,
                       int enemyCount,
                       double enemyFrequency,
                       int pathID,
                       double startTime) {
        this.waveNumber = new SimpleIntegerProperty(waveNumber);
        this.enemyID = new SimpleIntegerProperty(enemyID);
        this.enemyCount = new SimpleIntegerProperty(enemyCount);
        this.enemyFrequency = new SimpleDoubleProperty(enemyFrequency);
        this.pathID = new SimpleIntegerProperty(pathID);
        this.startTime = new SimpleDoubleProperty(startTime);
    }

    @Override
    public int getId () {
        return waveNumber.get();
    }

    @Override
    public int getEnemyID () {
        return enemyID.get();
    }

    @Override
    public void setEnemyID (int enemyID) {
        this.enemyID.set(enemyID);
    }

    @Override
    public int getPathID () {
        return pathID.get();
    }

    @Override
    public void setPathID (int pathID) {
        this.pathID.set(pathID);
    }

    @Override
    public int getEnemyCount () {
        return enemyCount.get();
    }

    @Override
    public void setEnemyCount (int enemyCount) {
        this.enemyCount.set(enemyCount);

    }

    @Override
    public double getStartTime () {
        return startTime.get();
    }

    @Override
    public void setStartTime (double startTime) {
        this.startTime.set(startTime);

    }

    @Override
    public double getFrequency () {
        return enemyFrequency.get();
    }

    @Override
    public void setFrequency (double frequency) {
        this.enemyFrequency.set(frequency);
    }

    @Override
    public double calculateTime () {
        // TODO Auto-generated method stub
        return 0;
    }

    // Don't need
    @Override
    public String getName () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setName (String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getImagePath () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setImagePath (String imagePath) {
        // TODO Auto-generated method stub

    }

    @Override
    public double getSize () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setSize (double size) {
        // TODO Auto-generated method stub

    }
}
