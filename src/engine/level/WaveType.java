package engine.level;

public class WaveType {
	private int enemyID;
	private int pathID;
	private int enemyCount;
	private double startTime;
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
		return startTime;
	}
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	public double getFrequency() {
		return frequency;
	}
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	
}
