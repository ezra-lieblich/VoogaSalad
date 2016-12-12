package gameplayer.model.tower;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import engine.tower.*;
import engine.weapon.WeaponType;
import gameplayer.model.IDrawable;
import gameplayer.view.helper.GraphicsLibrary;

public class Tower implements IDrawable {

	private double cost, sellAmount;
	private ArrayList<Gun> weaponTypes;
	private String image, name;
	private int uniqueID, type; // towerType
	private double xCoordinate;
	private double yCoordinate;	
	private Label towerInfo;
	private VBox infoBox;
	private Button sellButton;
	private Button upgradeButton;
	private GraphicsLibrary graphics;
	private boolean showInfo, upgradable;
	private Queue<Integer> upgradeList;
	
	
	public Tower (engine.tower.Tower tt, ArrayList<Gun> weaponTypes, int uniqueID){
		this.cost = tt.getCost();
		this.weaponTypes = weaponTypes;
		this.image = tt.getImagePath();
		this.uniqueID = uniqueID;
		this.sellAmount = tt.getSellAmount();
		this.upgradeList = new LinkedList<Integer>();
		this.upgradeList.addAll(tt.getUpgrades());
		//System.out.println("upgradable: " + upgradeList.size());
		this.upgradable = this.upgradeList.isEmpty();
		this.showInfo = false;
		this.towerInfo = new Label("Type: " + this.type + "\n ID: " + this.uniqueID + "\n Cost: " + 
				this.cost + "\n Image: " + this.image + "\n Name: " + this.name);
		this.graphics = new GraphicsLibrary();
		initVBox();
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
	
	public Boolean upgradable(){
		return this.upgradable();
	}
	
	public int getUpgradeType(){
		int type = this.upgradeList.poll();
		if (this.upgradeList.isEmpty()){
			this.upgradable = false;
		}
		return type;
	}
	

	
	double sellTower(){
		return this.sellAmount;
	}
	
	int getType(){
		return this.type;
	}
	

	void setGuns(ArrayList<Gun> guns){
		this.weaponTypes = guns;
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
	
	void setImage(String image) {
		this.image = image;
	}


	
	public void toggleInfoVisibility(){
		this.showInfo = !showInfo;
		this.infoBox.setVisible(showInfo);
	}
	
	public void initVBox(){
		this.infoBox = new VBox();
		HBox buttons = new HBox();
		buttons.getChildren().addAll(createSellButton(), createUpgradeButton());
		this.infoBox.getChildren().addAll(towerInfo, buttons);
		this.infoBox.setVisible(showInfo);
	}
	
	public Button createSellButton(){
		this.sellButton = graphics.createButton("Sell");
		return sellButton;
	}
	
	public Button createUpgradeButton(){
		this.upgradeButton = graphics.createButton("Upgrade");
		return upgradeButton;
	}
	
	public Button getSellButton(){
		return sellButton;
	}
	
	public Button getUpgradeButton(){
		return upgradeButton;
	}

	public Label getTowerInfo() {
		return towerInfo;
	}

	public VBox getInfoBox() {
		return infoBox;
	}

	public int getUniqueID() {
		return uniqueID;
	}

}
