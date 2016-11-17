package gameplayer.model;

public class Tower {
	
	private double attackingRange;
	private int fireRate; // number of interation or update
	private double cost;
	private int weaponType;
	private String image;
	private int ID;  // towerType
	private int counter;
	private double[] coordinates;
	
	
	public Tower (int ID, double attackingRange,int fireRate, double cost, int weapon, String image){
		this.attackingRange = attackingRange;
		this.fireRate = fireRate;
		this.cost = cost;
		this.weaponType = weapon;
		this.image = image;
		this.ID = ID;
		this.counter = 0;
	}
	
	Boolean isFiring(){
		if(counter % fireRate == 0){
			counter++;
			return true;
		}
		counter++;
		return false;
	}
	
	void setCoordinates(double x, double y){
		coordinates[0] = x;
		coordinates[1] = y;
	}
	
	double[] getCoordinate(){
		return this.coordinates;
	}
	
	
	int getType(){
		return this.ID;
	}
	
	public String getImage(){
		return this.image;
	}

	double getAttackingRange() {
		return attackingRange;
	}

	void setAttackingRange(double attackingRange) {
		this.attackingRange = attackingRange;
	}

	int getFireRate() {
		return fireRate;
	}

	void setFireRate(int fireRate) {
		this.fireRate = fireRate;
	}

	double getCost() {
		return cost;
	}

	void setCost(double cost) {
		this.cost = cost;
	}

	int getWeaponType() {
		return weaponType;
	}

	void setWeaponType(int weaponType) {
		this.weaponType = weaponType;
	}



	

}
