package gameplayer.model;

import java.util.ArrayList;

public class Tower {
	
	private double cost;
	private ArrayList<Integer> weaponType;
	private String image;
	private int ID;  // towerType
	private double[] coordinates;
	
	
	public Tower (int ID, double cost, ArrayList<Integer> weaponTypes, String image, String name) {
		this.cost = cost;
		this.weaponType = weaponTypes;
		this.image = image;
		this.ID = ID;
	}
	
	void setCoordinates(double x, double y){
		coordinates[0] = x;
		coordinates[1] = y;
	}
	
	double[] getCoordinate(){
		return this.coordinates;
	}
	
	
	int getType(){
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
