package engine;

public class EnemyTypeManager extends EntityManager<EnemyType>{

    @Override
    protected EnemyType createInstance () {
        return new EnemyType();
    }

	public double getSpeed(int id) {
		return data.get(id).getSpeed();
	}
	public void setSpeed(int id, double speed) {
		data.get(id).setSpeed(speed);
	}
	public double getHealth(int id) {
        return data.get(id).getHealth();
	}
	public void setHealth(int id, double health) {
        data.get(id).setHealth(health);
	}
	public double getPoints(int id ) {
        return data.get(id).getPoints();
	}
	public void setPoints(int id, double points) {
        data.get(id).setPoints(points);
	}
	public double getMoney(int id) {
		return data.get(id).getMoney();
	}
	public void setMoney(int id, double money) {
        data.get(id).setMoney(money);
	}
	public String getCollissionEffect(int id) {
		return data.get(id).getCollisionEffect();
	}
	public void setColissionEffect(int id, String colisionEffect) {
        data.get(id).setCollisionEffect(colisionEffect);
	}
}
