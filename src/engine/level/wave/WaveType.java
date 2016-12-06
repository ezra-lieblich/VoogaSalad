package engine.level.wave;

public class WaveType {
	//ID for type of enemy
	private int enemyID;
	//ID for path of wave
	private int pathID;
	//Number of enemies in wave
	private int enemyCount;
	//Time in seconds that wave starts to come out
	private double delay;
	//Time in seconds between each enemy spawned
	private double frequency;
	
	public int getEnemyID() {
		return enemyID;
	}
	public void setEnemyID(int enemyID) {
		this.enemyID = enemyID;
	}
	public int getPathID() {
		return pathID;
	}
	public void setPathID(int pathID) {
		this.pathID = pathID;
	}
	public int getEnemyCount() {
		return enemyCount;
	}
	public void setEnemyCount(int enemyCount) {
		this.enemyCount = enemyCount;
	}
	public double getStartTime() {
		return delay;
	}
	public void setStartTime(double startTime) {
		this.delay = startTime;
	}
	public double getFrequency() {
		return frequency;
	}
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	
}
