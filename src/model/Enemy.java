package model;

public class Enemy {
	
	private double movingSpeed;  
	private double health;
	private String image;
	private double xCoordinate;
	private double yCoordinate;
	
	

	public Enemy(double movingSpeed, int health, String image){
		this.movingSpeed = movingSpeed;
		this.health = health;	
		this.image = image;
		
	}
	
	
	double getX() {
		return xCoordinate;
	}

	void setX(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	double getY() {
		return yCoordinate;
	}

	void setY(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	void setImage(String image) {
		this.image = image;
	}

	
	String getImage(){
		return this.image;
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
