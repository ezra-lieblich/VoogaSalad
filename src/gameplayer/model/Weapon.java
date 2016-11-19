package gameplayer.model;

import java.util.Observable;

public class Weapon extends Observable{
	
	private int ID;
	private double demage;
	private double speedX;
	private double speedY;

	private String name;
	private String image;
	private double xCoordinate;
	private double yCoordinate;
	private Tower shootingAgent;
	private double firingRate;
	private double attackingRange;
	private int fireCounter;
	private double distanceTravelled;
	
	
	public Weapon(String name, int ID, double firingRate, double attackingRange, double demage, double speedX, double speedY, String image) {
		this.name = name;
		this.ID = ID;
		this.firingRate = firingRate;
		this.attackingRange = attackingRange;
		this.demage = demage;
		this.speedX = speedX;
		this.speedY  = speedY;
		this.image = image;
		this.fireCounter = 0;
	}
	
	public String getName(){
		return this.name;
	}
	
	Boolean isFiring(){
		if(fireCounter % this.firingRate == 0){
			fireCounter++;
			return true;
		}
		fireCounter++;
		return false;
	}
	
	
	void incrementDistanceTravelled(double x, double y) {
		this.distanceTravelled += Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	Boolean outOfRange(){
		return distanceTravelled > this.attackingRange;
	}
	
	public void setShootingAgent(Tower t){
		this.shootingAgent = t;
	}
	
	public Tower getShootingAgent(){
		return this.shootingAgent;
	}
	
	double getSpeedX(){
		return this.speedX;
	}
	
	double getSpeedY(){
		return this.speedY;
	}
	
	/*
	 * can factor out to a moving object class with enemy class
	 */
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
	
	String getImage(){
		return this.image;
	}

	int getID() {
		return ID;
	}

	void setID(int iD) {
		ID = iD;
	}

	double getDemage() {
		return demage;
	}

	void setDemage(double demage) {
		this.demage = demage;
	}



	
	
}
