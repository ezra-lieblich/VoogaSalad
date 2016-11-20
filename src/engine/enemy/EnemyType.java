package engine.enemy;

import java.util.ResourceBundle;
import engine.AbstractType;

public class EnemyType extends AbstractType{

	private double speed;
	private double health;
	private double points;
	private double money;
	private String collisionEffect;

	
	public EnemyType() {
		//possible hold a resource file that has default values for an enemy
        super.setName(super.getResources().getString("EnemyTypeName"));
		super.setImagePath(super.getResources().getString("EnemyTypeImage"));
		speed = Double.parseDouble(super.getResources().getString("EnemyTypeSpeed"));
        health = Double.parseDouble(super.getResources().getString("EnemyTypeHealth"));
        points = Double.parseDouble(super.getResources().getString("EnemyTypePoints"));
        money = Double.parseDouble(super.getResources().getString("EnemyTypeMoney"));
        collisionEffect = super.getResources().getString("EnemyTypeCollisionEffect");
//		speed = 5;
//		health = 10;
//		points = 50;
//		money = 50;
//        collisionEffect = "normal";

	}
	
	public EnemyType(String name, String imageLocation, double speed, 
			double health, double points, double money, String collisionEffect){
		
		super.setName(name);
		super.setImagePath(imageLocation);
		this.speed = speed; 
		this.health = health; 
		this.points = points; 
		this.money = money; 
		this.collisionEffect = collisionEffect; 
		
	}
	
	public String getName(){
		return super.getName();
	}
	
	public String getImageLocation(){
		return super.getImagePath() ;
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
	public void setCollisionEffect(String collisionEffect) {
		this.collisionEffect = collisionEffect;
	}
	
}
