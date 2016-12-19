//This entire file is my masterpiece
//Ezra Lieblich
package engine.enemy;

import java.util.function.BiConsumer;
import engine.AbstractTypeBuilder;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;
/**
 * I chose this is my masterpiece because it incorporates a lot of design principles we have learned throughout the year.
 * First, it contains ObservableProperties that are not JavaFX so as to provide more flexibility should we not chose not
 * to use JavaFX. It uses observables listeners that are incorporated by the Listener Methods. These methods
 * incorporate functional programming as it takes in a functional interface where the controller passes in the corresponding
 * front end method that listens to these observable properties. Also it incorporates the builder pattern as seen
 * by the build methods and also the copyType uses the builder method. The builder pattern allows the user
 * to create complex objects while also being readable as they can call .build multiple times to create an object which
 * is seen in the copyType method. In addition the user can choose to not fill in parameters as their are optional parameters for everything as you
 * can see by the default values. Finally, there is a hierarchal design as you can see the interface it implements
 * and the classes it extends. This builders are also open and extensible as we use generics for all our builder, making
 * it easy to add new types that follow this similar design
 * 
 * 
 * 
 * Builder class that implements EnemyBuilder and EnemyInitializer. Builds enemies and sets up the listeners for them
 * and then builds them. See the EnemyInitializer and EnemyBuilder to see what the methods do. This class is referenced
 * in the EnemyManagerController and is called when the createType() method is called. It returns a newly built
 * Enemy with default values. It also is called by EnemyController when we need to copy the Enemy and rebuild/attach
 * listeners to the Enemies created. 
 * @author ezra
 *
 */
public class EnemyTypeBuilder extends AbstractTypeBuilder<Enemy, EnemyBuilder> implements EnemyBuilder, EnemyInitializer{

	//Default values that the all types have
    public static final String DEFAULT_NAME = "New Enemy";
    public static final String DEFAULT_IMAGE_PATH = "Images/butterfly.png";
    public static final double DEFAULT_SIZE = 1;
    public static final String DEFAULT_SOUND_PATH = "Music/DopeBeats.mp3";

    //Default values for the enemy attributes
    public static final double DEFAULT_SPEED = 1;
    public static final double DEFAULT_HEALTH = 10;
    public static final double DEFAULT_DAMAGE = 2;
    public static final double DEFAULT_SCORE = 10;
    public static final double DEFAULT_MONEY = 20;
    public static final String DEFAULT_COLLISION_EFFECT = "";

	//Observable properties that will have listeners added to them and then passed to the EnemyType	  
    private ObservableProperty<Double> speed;
	private ObservableProperty<Double> health;
	private ObservableProperty<Double> damage;
	private ObservableProperty<Double> score;
	private ObservableProperty<Double> money;
	private ObservableProperty<String> collisionEffect;
    
	/**
	 * Sets the default Type attributes
	 */
	public EnemyTypeBuilder() {
		super(DEFAULT_NAME, DEFAULT_IMAGE_PATH, DEFAULT_SIZE, DEFAULT_SOUND_PATH);
	}

	//All these methods are extended from the BindableEnemy interface. See the BindableEnemy interface for more information
	
	/**
	 * Adds a listener to the enemies speed attribute.
	 * @param listener A consumer that takes in two parameters and calls the method in the 
	 * front end
	 * @return returns the EnemyBuilder to adhere to the builder pattern so they can continue to build their enemy
	 */
	@Override
	public EnemyBuilder addSpeedListener(BiConsumer<Double, Double> listener) {
		speed.addListener(listener);
		return this;
	}

	/**
	 * Adds a listener to the enemies health attribute.
	 * @param listener A consumer that takes in two parameters and calls the method in the 
	 * front end
	 * @return returns the EnemyBuilder to adhere to the builder pattern so they can continue to build their enemy
	 */
	@Override
	public EnemyBuilder addHealthListener(BiConsumer<Double, Double> listener) {
		health.addListener(listener);
		return this;
	}

	/**
	 * Adds a listener to the enemies damage attribute.
	 * @param listener A consumer that takes in two parameters and calls the method in the 
	 * front end
	 * @return returns the EnemyBuilder to adhere to the builder pattern so they can continue to build their enemy
	 */
	@Override
	public EnemyBuilder addDamageListener(BiConsumer<Double, Double> listener) {
		damage.addListener(listener);
		return this;
	}

	/**
	 * Adds a listener to the enemies score attribute.
	 * @param listener A consumer that takes in two parameters and calls the method in the 
	 * front end
	 * @return returns the EnemyBuilder to adhere to the builder pattern so they can continue to build their enemy
	 */
	@Override
	public EnemyBuilder addScoreListener(BiConsumer<Double, Double> listener) {
		score.addListener(listener);
		return this;
	}

	/**
	 * Adds a listener to the enemies collision effect attribute.
	 * @param listener A consumer that takes in two parameters and calls the method in the 
	 * front
	 * @return returns the EnemyBuilder to adhere to the builder pattern so they can continue to build their enemy
	 */
	@Override
	public EnemyBuilder addMoneyListener(BiConsumer<Double, Double> listener) {
		money.addListener(listener);
		return this;
	}

	/**
	 * Adds a listener to the enemies collision effect attribute.
	 * @param listener A consumer that takes in two parameters and calls the method in the 
	 * front
	 * @return returns the EnemyBuilder to adhere to the builder pattern so they can continue to build their enemy
	 */
	@Override
	public EnemyBuilder addCollisionEffectListener(BiConsumer<String, String> listener) {
		collisionEffect.addListener(listener);
		return this;
	}

	//All these methods are the implementation of the EnemyInitializer interface. See the interface for more information
	
	/**
	 * 
	 * @return The speed property of the Enemy
	 */
	@Override
	public ObservableProperty<Double> getSpeed() {
		return speed;
	}

	 /**
     * 
     * @return The health property of the Enemy
     */
	@Override
	public ObservableProperty<Double> getHealth() {
		return health;
	}

	/**
     * 
     * @return The damage property of the Enemy
     */
	@Override
	public ObservableProperty<Double> getDamage() {
		return damage;
	}

	 /**
     * 
     * @return The score property of the Enemy
     */
	@Override
	public ObservableProperty<Double> getScore() {
		return score;
	}

	/**
     * 
     * @return The money property of the Enemy
     */
	@Override
	public ObservableProperty<Double> getMoney() {
		return money;
	}

	 /**
     * 
     * @return The collision property of the Enemy
     */
	@Override
	public ObservableProperty<String> getCollisionEffect() {
		return collisionEffect;
	}
	
	//All these methods are the implementation of the EnemyBuilder interface. See the interface for more information

	/**
	 * Builds the enemies speed attribute
	 * @param speed
	 * @return the EnemyBuilder so the user has the ability to build multiple attribute at once
	 */
	@Override
	public EnemyBuilder buildSpeed(double speed) {
		this.speed.setProperty(speed);
		return this;
	}

	/**
	 * Builds the enemies health attribute
	 * @param health
	 * @return the EnemyBuilder so the user has the ability to build multiple attribute at once
	 */
	@Override
	public EnemyBuilder buildHealth(double health) {
		this.health.setProperty(health);
		return this;
	}

	/**
	 * Builds the enemies damage attribute
	 * @param damage
	 * @return the EnemyBuilder so the user has the ability to build multiple attribute at once
	 */
	@Override
	public EnemyBuilder buildDamage(double damage) {
		this.damage.setProperty(damage);
		return this;
	}

	/**
	 * Builds the enemies score attribute
	 * @param score
	 * @return the EnemyBuilder so the user has the ability to build multiple attribute at once
	 */
	@Override
	public EnemyBuilder buildScore(double points) {
		this.score.setProperty(points);
		return this;
	}

	/**
	 * Builds the enemies money attribute
	 * @param money
	 * @return the EnemyBuilder so the user has the ability to build multiple attribute at once
	 */
	@Override
	public EnemyBuilder buildMoney(double money) {
		this.money.setProperty(money);
		return this;
	}

	/**
	 * Builds the enemies collision effect attribute
	 * @param collisionEffect
	 * @return the EnemyBuilder so the user has the ability to build multiple attribute at once
	 */
	@Override
	public EnemyBuilder buildCollisionEffect(String collisionEffect) {
		this.collisionEffect.setProperty(collisionEffect);
		return this;
	}

	/**
	 * Called by the EnemyManager. Called when the front end wants to create a new enemy. Makes an new EnemyType
	 * which takes in this builder and uses the EnemyInitializer interface to get the properties associated
	 * with the builder. At creation, the EnemyType will just be getting the default values.
	 * @return the Enemy interface that was created
	 */
	@Override
	protected Enemy create() {
		return new EnemyType(this);
	}

	/**
	 * Called immediately after the create method from the controller after the Enemy is built and restores the 
	 * attributes to the default values.
	 * 
	 */
	@Override
	protected void restoreTypeDefaults() {
		this.speed = new ObservableObjectProperty<Double>(DEFAULT_SPEED);
		this.health = new ObservableObjectProperty<Double>(DEFAULT_HEALTH);
		this.damage = new ObservableObjectProperty<Double>(DEFAULT_DAMAGE);
		this.score = new ObservableObjectProperty<Double>(DEFAULT_SCORE);
		this.money = new ObservableObjectProperty<Double>(DEFAULT_MONEY);
		this.collisionEffect = new ObservableObjectProperty<String>(DEFAULT_COLLISION_EFFECT);
	}

	/**
	 * 
	 * @return The enemy builder
	 */
	@Override
	protected EnemyBuilder getThis() {
		return this;
	}

	/**
	 * Called when loading an xml file with all the values. Copies the values from the old
	 * Enemy and build the new values and resets up the listeners. Uses the builder interface methods
	 */
	@Override
	protected EnemyBuilder copyType(Enemy type) {
		return this
		.buildCollisionEffect(type.getCollisionEffect())
		.buildDamage(type.getDamage())
		.buildHealth(type.getHealth())
		.buildMoney(type.getMoney())
		.buildScore(type.getScore())
		.buildSpeed(type.getSpeed());
	}
}
