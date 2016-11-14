package gameplayer.model;

public class Enemy {
	
	private double movingSpeed;  
	private double health;
	private String image;
	private double xCoordinate;
	private double yCoordinate;
	private Cell currentCell;
	private int xDirection; //-1 if moving left, 1 if moving right
	private int yDirection; //-1 if moving down, 1 if moving up	

	public Enemy(double movingSpeed, int health, String image){
		this.movingSpeed = movingSpeed;
		this.health = health;	
		this.image = image;
		
	}
	
	public int getxDirection() {
		return xDirection;
	}

	public void setxDirection(int xDirection) {
		this.xDirection = xDirection;
	}

	public int getyDirection() {
		return yDirection;
	}

	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
	}


	void setCurrentCell(Cell c){
		this.currentCell = c;
		this.xDirection = c.getNext().getX() - c.getX();
		this.yDirection = c.getNext().getY() - c.getY();
	}
	
	Cell getCurrentCell(){
		return this.currentCell;
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
