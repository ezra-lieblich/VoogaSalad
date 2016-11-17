package engine;

import java.util.ResourceBundle;

public class EnemyType extends Entity{
	private String name;
	private String imagePath;
	private double speed;
	private double health;
	private double points;
	private double money;
	private String colissionEffect;
	
    private static final String DEFAULTVALUESPATH = "resources/DefaultEntityValues/";
	private static ResourceBundle resources;

	
	public EnemyType() {
		//possible hold a resource file that has default values for an enemy
		resources =  ResourceBundle.getBundle(DEFAULTVALUESPATH);
		imagePath = resources.getString("EnemyImage");
		speed = Double.parseDouble(resources.getString("Default"));
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
	public String getColissionEffect() {
		return colissionEffect;
	}
	public void setColissionEffect(String colissionEffect) {
		this.colissionEffect = colissionEffect;
	}
	
}
