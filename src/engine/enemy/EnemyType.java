package engine.enemy;

import java.util.ResourceBundle;
import engine.AbstractType;
import engine.TypeInitializer;

public class EnemyType extends AbstractType implements Enemy {

    private double speed;
	private double health;
	private double damage;
	private double points;
	private double money;
	private String collisionEffect;

	
    public EnemyType (TypeInitializer typeBuilder) {
        super(typeBuilder);
        // TODO Auto-generated constructor stub
    }
	
	
//	public EnemyType() {
//		//possible hold a resource file that has default values for an enemy
//        super.setName(super.getResources("EnemyTypeName"));
//		super.setImagePath(super.getResources("EnemyTypeImage"));
//		speed = Double.parseDouble(super.getResources("EnemyTypeSpeed"));
//        health = Double.parseDouble(super.getResources("EnemyTypeHealth"));
//		damage = Double.parseDouble(super.getResources("EnemyTypeDamage"));
//        points = Double.parseDouble(super.getResources("EnemyTypePoints"));
//        money = Double.parseDouble(super.getResources("EnemyTypeMoney"));
//        collisionEffect = super.getResources("EnemyTypeCollisionEffect");
////		speed = 5;
////		health = 10;
////		points = 50;
////		money = 50;
////        collisionEffect = "normal";
//
//	}
//	
//	public EnemyType(String name, String imageLocation, double speed, 
//			double health, double points, double money, String collisionEffect){
//		
//		super.setName(name);
//		super.setImagePath(imageLocation);
//		this.speed = speed; 
//		this.health = health; 
//		this.points = points; 
//		this.money = money; 
//		this.collisionEffect = collisionEffect; 
//		
//	}
	

	
	@Override
    public double getSpeed() {
		return speed;
	}
	@Override
    public void setSpeed(double speed) {
		this.speed = speed;
	}
	@Override
    public double getHealth() {
		return health;
	}
	@Override
    public void setHealth(double health) {
		this.health = health;
	}
	@Override
    public double getDamage(){
		return damage;
	}
	@Override
    public void setDamage(double damage) {
		this.damage = damage;
	}
	@Override
    public double getPoints() {
		return points;
	}
	@Override
    public void setPoints(double points) {
		this.points = points;
	}
	@Override
    public double getMoney() {
		return money;
	}
	@Override
    public void setMoney(double money) {
		this.money = money;
	}
	@Override
    public String getCollisionEffect() {
		return collisionEffect;
	}
	@Override
    public void setCollisionEffect(String collisionEffect) {
		this.collisionEffect = collisionEffect;
	}
	
}
