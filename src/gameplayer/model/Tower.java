package gameplayer.model;

import java.util.ArrayList;

public class Tower implements IDrawable {
	
	private double cost;
	private ArrayList<Integer> weaponType;
	private String image,name;
	private int ID;  // towerType
	private double xCoordinate;
	private double yCoordinate;	
	
	//TODO: need to implement weapon types. Refer to constructor below for the working tower
	public Tower (int ID, double cost, ArrayList<Integer> weaponTypes, String image, String name){
		this.cost = cost;
		this.weaponType = weaponTypes;
		this.image = image;
		this.ID = ID;
	}
	
	//Current Using and needs updating 
	public Tower(int ID, String image, String name, double xCoordinate, double yCoordinate){
		this.ID = ID; 
		this.image = image; 
		this.name = name; 
		this.xCoordinate = xCoordinate; 
		this.yCoordinate = yCoordinate; 
	}
		
	public void setCoordinates(double x, double y){
		this.xCoordinate = x;
		this.yCoordinate = y;
	}
	
	public double getX() {
		return this.xCoordinate;
	}
	
	public double getY() {
		return yCoordinate;
	}
	
	public String getName(){
		return this.name; 
	}
	
	public int getType(){
		return this.ID;
	}
	
	public String getImage(){
		return this.image;
	}

	double getCost() {
		return cost;
	}

	void setCost(double cost) {
		this.cost = cost;
	}

	ArrayList<Integer> getWeaponType() {
		return this.weaponType;
	}




	

}
