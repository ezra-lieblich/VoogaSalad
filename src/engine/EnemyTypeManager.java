package engine;

public class EnemyTypeManager extends EntityManager<EnemyType>{

    @Override
    protected EnemyType createInstance () {
        return new EnemyType();
    }

//	public double getSpeed(int id) {
//		return speed;
//	}
//	public void setSpeed(double speed) {
//		this.speed = speed;
//	}
//	public double getHealth() {
//		return health;
//	}
//	public void setHealth(double health) {
//		this.health = health;
//	}
//	public double getPoints() {
//		return points;
//	}
//	public void setPoints(double points) {
//		this.points = points;
//	}
//	public double getMoney() {
//		return money;
//	}
//	public void setMoney(double money) {
//		this.money = money;
//	}
//	public String getColissionEffect() {
//		return colissionEffect;
//	}
//	public void setColissionEffect(String colissionEffect) {
//		this.colissionEffect = colissionEffect;
//	}
}
