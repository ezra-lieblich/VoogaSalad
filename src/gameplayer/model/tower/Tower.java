package gameplayer.model.tower;

import java.util.ArrayList;
import javafx.scene.control.Label;
import engine.tower.*;
import engine.weapon.WeaponType;
import gameplayer.model.IDrawable;

public class Tower implements IDrawable {

	private double cost, sellAmount;
	private ArrayList<Gun> weaponTypes;
	private String image, name;
	private int uniqueID, type; // towerType
	private double xCoordinate;
	private double yCoordinate;	
	private Label towerInfo;
	private boolean showInfo;
	
	
	
	public Tower (engine.tower.Tower tt, ArrayList<Gun> weaponTypes, int uniqueID){
		this.cost = tt.getCost();
		this.weaponTypes = weaponTypes;
		this.image = tt.getImagePath();
		this.uniqueID = uniqueID;
		this.sellAmount = tt.getSellAmount();
		this.showInfo = false;
		this.towerInfo = new Label("Type: " + this.type + "\n ID: " + this.uniqueID + "\n Cost: " + 
				this.cost + "\n Image: " + this.image + "\n Name: " + this.name);
		this.towerInfo.setVisible(showInfo);
	}

	/**
	 * important method for controller/front end
	 * getting all the weapon types for this tower
	 * each weaponType has the method called getFireRate
	 * @return
	 */
	public ArrayList<Gun> getAllWeaponTypes(){
		return this.weaponTypes;
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
	
	double sellTower(){
		return this.sellAmount;
	}
	
	int getType(){
		return this.type;
	}
	

	
	
	int getUnqueID(){
		return this.uniqueID;
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


	
	public void toggleInfoVisibility(){
		this.showInfo = !showInfo;
		this.towerInfo.setVisible(showInfo);
	}

	public Label getTowerInfo() {
		return towerInfo;
	}

}
