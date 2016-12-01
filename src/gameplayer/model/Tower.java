package gameplayer.model;

import java.util.ArrayList;

import javafx.scene.control.Label;

public class Tower implements IDrawable {

	private double cost;
	private ArrayList<Gun> guns;
	private String image, name;
	private int ID, type; // towerType
	private double xCoordinate;
	private double yCoordinate;	
	private Label towerInfo;
	private boolean showInfo;
	
	
	public Tower (int type, int ID, double cost, ArrayList<Gun> guns, String image, String name){
		this.cost = cost;
		this.guns = guns;
		this.image = image;
		this.ID = ID;
		this.showInfo = true;
		this.towerInfo = new Label("Type: " + type + "\n ID: " + ID + "\n Cost: " + 
				cost + "\n Image: " + image + "\n Name: " + name);
		this.towerInfo.setVisible(showInfo);
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
	
	public void toggleInfoVisibility(){
		this.showInfo = !showInfo;
		this.towerInfo.setVisible(showInfo);
	}

	public Label getTowerInfo() {
		return towerInfo;
	}

}
