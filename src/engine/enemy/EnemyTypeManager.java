package engine.enemy;

import engine.AbstractTypeManager;

public class EnemyTypeManager extends AbstractTypeManager<Enemy> implements EnemyManager {

    @Override
    protected EnemyType createInstance () {
        return new EnemyType();
    }

	@Override
	public double getSpeed() {
		return getActiveEntity().getSpeed();
	}
	@Override
	public void setSpeed(double speed) {
		getActiveEntity().setSpeed(speed);
	}
	@Override
	public double getHealth() {
        return getActiveEntity().getHealth();
	}
	@Override
	public void setHealth(double health) {
		getActiveEntity().setHealth(health);
	}
	@Override
	public double getPoints() {
        return getActiveEntity().getPoints();
	}
	@Override
	public void setPoints(double points) {
		getActiveEntity().setPoints(points);
	}

	@Override
	public double getDamage() {
		return getActiveEntity().getDamage();
	}

	@Override
	public void setDamage(double damage) {
		getActiveEntity().setDamage(damage);
	}

	@Override
	public double getMoney() {
		return getActiveEntity().getMoney();
	}
	@Override
	public void setMoney(double money) {
		getActiveEntity().setMoney(money);
	}
	@Override
	public String getCollisionEffect() {
		return getActiveEntity().getCollisionEffect();
	}
	@Override
	public void setCollisionEffect(String colisionEffect) {
		getActiveEntity().setCollisionEffect(colisionEffect);
	}

	@Override
	public String getName() {
		return getActiveEntity().getName();
	}

	@Override
	public void setName(String name) {
		getActiveEntity().setName(name);
	}

	@Override
	public String getImagePath() {
		return getActiveEntity().getImagePath();
	}

	@Override
	public void setImagePath(String imagePath) {
		getActiveEntity().setImagePath(imagePath);
	}

	@Override
	public double getSize() {
		return getActiveEntity().getSize();
	}

	@Override
	public void setSize(double size) {
		getActiveEntity().setSize(size);
	}
}
