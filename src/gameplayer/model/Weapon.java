package gameplayer.model;

import java.util.Observable;

public class Weapon extends Observable{
	
	private int ID;
	private double damage;
	private double speedX;
	private double speedY;
	private String name;
	private String image;
	private double xCoordinate;
	private double yCoordinate;
	private Tower shootingAgent;
	private int fireCounter;
	private double distanceTravelled;
	
	
	public Weapon(String name, int ID, double demage, double speedX, double speedY, String image) {
		this.name = name;
		this.ID = ID;
		this.damage = demage;

		this.speedX = speedX;
		this.speedY  = speedY;
		this.image = image;
		//this.fireCounter = 0;
	}
	
	public String getName(){
		return this.name;
	}
	

	
	
	public void incrementDistanceTravelled(double x, double y) {
		this.distanceTravelled += Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
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

	public void setX(double xCoordinate) {
		this.xCoordinate = xCoordinate;
		setChanged();
		notifyObservers();
	}

	public double getY() {
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

	double getDamage() {
		return damage;
	}

	void setDamage(double damage) {
		this.damage = damage;
	}



	
	
}
