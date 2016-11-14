package gameplayer.model;

public class Enemy {
	
	private double movingSpeed;  //grid per iteration
	private double health;
	
	public Enemy(double movingSpeed, int health){
		this.movingSpeed = movingSpeed;
		this.health = health;		
	}

	double getMovingSpeed() {
		return movingSpeed;
	}

	void setMovingSpeed(double movingSpeed) {
		this.movingSpeed = movingSpeed;
	}

	double getHealth() {
		return health;
	}

	void setHealth(double d) {
		this.health = d;
	}

}
