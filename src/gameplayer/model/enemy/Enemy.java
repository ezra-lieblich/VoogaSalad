package gameplayer.model.enemy;

import java.util.Observable;

import gameplayer.model.Cell;
import gameplayer.model.IDrawable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Enemy extends Observable implements IDrawable {

	private String name;
	private double movingSpeed;
	private double health;
	private String image;
	private double xCoordinate;
	private double yCoordinate;
	private Cell currentCell;
	private int xDirection; // -1 if moving left, 1 if moving right
	private int yDirection; // -1 if moving down, 1 if moving up
	private double width, height;
	private int uniqueID;
	private Label enemyInfo;
	private boolean showInfo;

	public Enemy(int ID, String name, double movingSpeed, int health, String image, double width, double height) {
		this.uniqueID = ID;
		this.name = name;
		this.movingSpeed = movingSpeed;
		this.health = health;
		this.image = image;
		this.width = width;
		this.height = height;
		this.showInfo = false;
		this.enemyInfo = new Label("Name: " + name + "\nHealth: " + health);
		initLabel();
	}

	private void initLabel(){
		this.enemyInfo.setLayoutX(getX());
		this.enemyInfo.setLayoutY(getY() + new ImageView(getImage()).getFitHeight());
		this.enemyInfo.setVisible(showInfo);
	}
	/*
	 * public double[] getWidthAndHeight(){ double[] weidthAndHeight =
	 * {this.width, this.height}; return weidthAndHeight; }
	 */

	public void setUniqueID(int id) {
		this.uniqueID = id;
	}

	public int getUniqueID() {
		return this.uniqueID;
	}

	public double getWidth() {
		return this.width;
	}

	public double getHeight() {
		return this.height;
	}

	public String getName() {
		return name;
	}

	public int getxDirection() { // heading
		return xDirection;
	}

	public void setxDirection(int xDirection) { // heading
		this.xDirection = xDirection;
		setChanged();
		notifyObservers();
	}

	public int getyDirection() {
		return yDirection;
	}

	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
		setChanged();
		notifyObservers();
	}

	public void setCurrentCell(Cell c) { // don't think we need to notify
											// observers of this change
		this.currentCell = c;
		//this.xDirection = c.getNext().getX() - c.getX();
		//this.yDirection = c.getNext().getY() - c.getY();
	}

	public Cell getCurrentCell() {
		return this.currentCell;
	}

	public double getX() {
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

	public void setY(double yCoordinate) {
		this.yCoordinate = yCoordinate;
		setChanged();
		notifyObservers();
	}

	public void setImage(String image) { // might not need to notify observers
											// here
		this.image = image;
		setChanged();
		notifyObservers();
	}

	public String getImage() {
		return this.image;
	}

	public double getMovingSpeed() {
		return movingSpeed;
	}

	public void setMovingSpeed(double movingSpeed) {
		this.movingSpeed = movingSpeed;
		setChanged();
		notifyObservers();
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double d) {
		this.health = d;
		setChanged();
		notifyObservers();
	}

	public Label getEnemyInfo() {
		return enemyInfo;
	}

	public void toggleInfoVisibility() {
		this.showInfo = !showInfo;
		this.enemyInfo.setVisible(showInfo);
	}

}
