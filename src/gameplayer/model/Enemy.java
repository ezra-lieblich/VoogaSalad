package gameplayer.model;

import java.util.Observable;

public class Enemy extends Observable{
	
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
	
	public int getxDirection() { //heading
		return xDirection;
	}

	public void setxDirection(int xDirection) { //heading
		this.xDirection = xDirection;
		setChanged();
		notifyObservers();
	}

	public int getyDirection() {
		return yDirection;
	}

	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
		setChanged();
		notifyObservers();
	}


	void setCurrentCell(Cell c){ //don't think we need to notify observers of this change
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
		setChanged();
		notifyObservers();
	}

	double getY() {
		return yCoordinate;
	}

	void setY(double yCoordinate) {
		this.yCoordinate = yCoordinate;
		setChanged();
		notifyObservers();
	}

	void setImage(String image) { //might not need to notify observers here
		this.image = image;
		setChanged();
		notifyObservers();
	}

	
	public String getImage(){
		return this.image;
	}

	double getMovingSpeed() {
		return movingSpeed;
	}

	void setMovingSpeed(double movingSpeed) {
		this.movingSpeed = movingSpeed;
		setChanged();
		notifyObservers();
	}

	double getHealth() {
		return health;
	}

	void setHealth(double d) {
		this.health = d;
		setChanged();
		notifyObservers();
	}

}
