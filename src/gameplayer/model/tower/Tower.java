package gameplayer.model.tower;

import java.util.ArrayList;
import javafx.scene.control.Label;
import engine.tower.*;
import gameplayer.model.IDrawable;
import gameplayer.model.weapon.Gun;

public class Tower implements IDrawable {

	private double cost;
	private ArrayList<Gun> guns;
	private String image, name;
	private int ID, type; // towerType
	private double xCoordinate;
	private double yCoordinate;	
	private Label towerInfo;
	private boolean showInfo;
	
	
	public Tower (TowerType tt, ArrayList<Gun> guns){
		this.cost = tt.getCost();
		this.guns = guns;
		this.image = tt.getImagePath();
		this.ID = ID;
		this.showInfo = true;
		this.towerInfo = new Label("Type: " + this.type + "\n ID: " + ID + "\n Cost: " + 
				this.cost + "\n Image: " + this.image + "\n Name: " + this.name);
		this.towerInfo.setVisible(showInfo);
	}

 
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
