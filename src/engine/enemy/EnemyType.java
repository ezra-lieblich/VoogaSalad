package engine.enemy;

import engine.AbstractType;
import engine.observer.ObservableProperty;

/**
 * EnemyType class implements the Enemy interface and holds the basic attributes of an Enemy.
 * Contains basic getters and setters. Refer to the Enemy Interface to see what each method performs
 * @author ezra
 *
 */
public class EnemyType extends AbstractType implements Enemy {

    private ObservableProperty<Double> speed;
	private ObservableProperty<Double> health;
	private ObservableProperty<Double> damage;
	private ObservableProperty<Double> score;
	private ObservableProperty<Double> money;
	private ObservableProperty<String> collisionEffect;

	/**
	 * Accesses the getters from the initializer to get the proper observables
	 * @param enemyInitializer
	 */
    protected EnemyType (EnemyInitializer enemyInitializer) {
        super(enemyInitializer);
        this.speed = enemyInitializer.getSpeed();
        this.health = enemyInitializer.getHealth();
        this.damage = enemyInitializer.getDamage();
        this.score = enemyInitializer.getScore();
        this.money = enemyInitializer.getMoney();
        this.collisionEffect = enemyInitializer.getCollisionEffect();
    }
	
	/*
	 * (non-Javadoc)
	 * @see engine.enemy.Enemy#getSpeed()
	 */
	@Override
    public double getSpeed() {
		return speed.getProperty();
	}
	/*
	 * (non-Javadoc)
	 * @see engine.enemy.Enemy#setSpeed(double)
	 */
	@Override
    public void setSpeed(double speed) {
		this.speed.setProperty(speed);
	}
	
	/*
	 * (non-Javadoc)
	 * @see engine.enemy.Enemy#getHealth()
	 */
	@Override
    public double getHealth() {
		return health.getProperty();
	}
	
	/*
	 * (non-Javadoc)
	 * @see engine.enemy.Enemy#setHealth(double)
	 */
	@Override
    public void setHealth(double health) {
		this.health.setProperty(health);
	}
	
	/*
	 * (non-Javadoc)
	 * @see engine.enemy.Enemy#getDamage()
	 */
	@Override
    public double getDamage(){
		return damage.getProperty();
	}
	
	/*
	 * (non-Javadoc)
	 * @see engine.enemy.Enemy#setDamage(double)
	 */
	@Override
    public void setDamage(double damage) {
		this.damage.setProperty(damage);
	}
	
	/*
	 * (non-Javadoc)
	 * @see engine.enemy.Enemy#getScore()
	 */
	@Override
    public double getScore() {
		return score.getProperty();
	}
	
	/*
	 * (non-Javadoc)
	 * @see engine.enemy.Enemy#setScore(double)
	 */
	@Override
    public void setScore(double score) {
		this.score.setProperty(score); 
	}
	
	/*
	 * (non-Javadoc)
	 * @see engine.enemy.Enemy#getMoney()
	 */
	@Override
    public double getMoney() {
		return money.getProperty();
	}
	
	/*
	 * (non-Javadoc)
	 * @see engine.enemy.Enemy#setMoney(double)
	 */
	@Override
    public void setMoney(double money) {
		this.money.setProperty(money);
	}
	
	/*
	 * (non-Javadoc)
	 * @see engine.enemy.Enemy#getCollisionEffect()
	 */
	@Override
    public String getCollisionEffect() {
		return collisionEffect.getProperty();
	}
	
	/*
	 * (non-Javadoc)
	 * @see engine.enemy.Enemy#setCollisionEffect(java.lang.String)
	 */
	@Override
    public void setCollisionEffect(String collisionEffect) {
		this.collisionEffect.setProperty(collisionEffect);
	}
	
}
