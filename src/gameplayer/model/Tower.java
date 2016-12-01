package gameplayer.model;

import java.util.ArrayList;

public class Tower implements IDrawable {

	private double cost;
	private ArrayList<Gun> guns;
	private String image, name;
	private int ID, type; // towerType
	private double xCoordinate;
	private double yCoordinate;	
	
	
	public Tower (int type, int ID, double cost, ArrayList<Gun> guns, String image, String name){
		this.cost = cost;
		this.guns = guns;
		this.image = image;
		this.ID = ID;
	}

	/*
// +++++++++++++get rid of this after fixing weapon Current Using and needs updating+++++++++++++
	public Tower(int ID, String image, String name, double xCoordinate, double yCoordinate) {
		this.ID = ID;
		this.image = image;
		this.name = name;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

*/ 
	public void setCoordinates(double x, double y) {
		this.xCoordinate = x;
		this.yCoordinate = y;
	}

	public double getX() {
		return this.xCoordinate;
	}

	public double getY() {
		return yCoordinate;
	}
	
	
	int getType(){
		return this.type;
	}
	
	
	int getID(){
		return this.ID;
	}
	
	
	public String getImage(){

		return this.image;
	}

	double getCost() {
		return cost;
	}
	
	String getName(){
		return this.name;
	}

	void setCost(double cost) {
		this.cost = cost;
	}

	ArrayList<Gun> getGuns() {
		return this.guns;
	}

}
