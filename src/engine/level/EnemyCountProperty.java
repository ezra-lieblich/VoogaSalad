package engine.level;

public class EnemyCountProperty implements EnemyCount {
	private int enemyCount;
	private double enemyFrequency;
	
	public EnemyCountProperty(int enemyCount, double enemyFrequency) {
		this.enemyCount = enemyCount;
		this.enemyFrequency = enemyFrequency;
	}
	
	@Override
	public int getEnemyCount() {
		return enemyCount;
	}

	@Override
	public void setEnemyCount(int count) {
		this.enemyCount = count;
	}

	@Override
	public double getEnemyFrequency() {
		return enemyFrequency;
	}

	@Override
	public void setEnemyFrequency(double frequency) {
		this.enemyFrequency = frequency;
	}

}
