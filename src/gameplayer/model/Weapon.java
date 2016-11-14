package gameplayer.model;

public class Weapon {
	
	private int ID;
	private double demage;
	private double speed;

	public Weapon(int ID, double demage, double speed) {
		this.ID = ID;
		this.demage = demage;
		this.speed = speed;
	}

	int getID() {
		return ID;
	}

	void setID(int iD) {
		ID = iD;
	}

	double getDemage() {
		return demage;
	}

	void setDemage(double demage) {
		this.demage = demage;
	}

	double getSpeed() {
		return speed;
	}

	void setSpeed(double speed) {
		this.speed = speed;
	}

	
	
}
