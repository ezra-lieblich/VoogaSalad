package gameplayer.loader;


public class SavedSettings {
	private String gameType;

	private double score;
	private double gold;
	private int level;
	private int lives;
	
	public SavedSettings(String xmlFileName) {
		this.gameType = xmlFileName;
	}
	
	public void setLives(int numLives) {
		this.lives = numLives;
	}
	
	public void setGold(double money) {
		this.gold = money;
	}
	
	public void setScore(double points) {
		this.score = points;
	}
	
	public void setLevel(int lev) {
		this.level = lev;
	}

	public String getGameType() {
		return gameType;
	}
	
	public double getScore() {
		return score;
	}

	public double getGold() {
		return gold;
	}

	public int getLevel() {
		return level;
	}

	public int getLives() {
		return lives;
	}
}
