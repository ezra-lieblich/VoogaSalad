package authoring.editorview.level;

import engine.level.wave.Wave;


public class WaveObject implements Wave {

    private int waveNumber;
    private int enemyID;
    private int enemyCount;
    private double enemyFrequency;
    private int pathID;
    private double startTime;

    public WaveObject (int waveNumber,
                       int enemyID,
                       int enemyCount,
                       double enemyFrequency,
                       int pathID,
                       double startTime) {
    }

    @Override
    public int getId () {
        return waveNumber;
    }

    @Override
    public int getEnemyID () {
        return enemyID;
    }

    @Override
    public void setEnemyID (int enemyID) {
        this.enemyID = enemyID;
    }

    @Override
    public int getPathID () {
        return pathID;
    }

    @Override
    public void setPathID (int pathID) {
        this.pathID = pathID;
    }

    @Override
    public int getEnemyCount () {
        return enemyCount;
    }

    @Override
    public void setEnemyCount (int enemyCount) {
        this.enemyCount = enemyCount;

    }

    @Override
    public double getStartTime () {
        return startTime;
    }

    @Override
    public void setStartTime (double startTime) {
        this.startTime = startTime;

    }

    @Override
    public double getFrequency () {
        return enemyFrequency;
    }

    @Override
    public void setFrequency (double frequency) {
        this.enemyFrequency = frequency;
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
