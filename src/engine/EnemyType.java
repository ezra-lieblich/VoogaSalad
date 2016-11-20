package engine;

import java.util.ResourceBundle;

public class EnemyType extends Entity{
	private String name;
	private String imageLocation;
	private double speed;
	private double health;
	private double points;
	private double money;
	private String collisionEffect;
	
    private static final String DEFAULTVALUESPATH = "resources/DefaultEntityValues/";
	private static ResourceBundle resources;

	
	public EnemyType() {
		//possible hold a resource file that has default values for an enemy
		this.resources =  ResourceBundle.getBundle(DEFAULTVALUESPATH);
		this.imageLocation = resources.getString("EnemyImage");
		this.speed = Double.parseDouble(resources.getString("Default"));
	}
	
	public EnemyType(String name, String imageLocation, double speed, 
			double health, double points, double money, String collisionEffect){
		
		this.name = name; 
		this.imageLocation = imageLocation; 
		this.speed = speed; 
		this.health = health; 
		this.points = points; 
		this.money = money; 
		this.collisionEffect = collisionEffect; 
		
	}
	
	public String getName(){
		return name; 
	}
	
	public String getImageLocation(){
		return imageLocation; 
	}
	
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getCollisionEffect() {
		return collisionEffect;
	}
	public void setColissionEffect(String collisionEffect) {
		this.collisionEffect = collisionEffect;
	}
	
}
