package gameplayer.model;

public class Tower {
	
	private double attackingRange;
	private double fireRate;
	private double cost;
	private int weaponType;
	
	public Tower (double attackingRange,double fireRate, double cost, int weapon ){
		this.attackingRange = attackingRange;
		this.fireRate = fireRate;
		this.cost = cost;
		this.weaponType = weapon;
		
	}

	double getAttackingRange() {
		return attackingRange;
	}

	void setAttackingRange(double attackingRange) {
		this.attackingRange = attackingRange;
	}

	double getFireRate() {
		return fireRate;
	}

	void setFireRate(double fireRate) {
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
