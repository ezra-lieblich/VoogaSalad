package gameplayer.model;

import java.util.Observable;

public class Weapon extends Observable{
	
	private int ID;
	private double demage;
	private double speedX;
	private double speedY;

	private String image;
	private double xCoordinate;
	private double yCoordinate;
	private Tower shootingAgent;
	
	
	public Weapon(int ID, double demage, double speedX, double speedY, String image) {
		this.ID = ID;
		this.demage = demage;
		this.speedX = speedX;
		this.speedY  = speedY;
		this.image = image;
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
