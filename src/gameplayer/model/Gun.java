package gameplayer.model;
import engine.weapon.*;

public class Gun {
	private int fireCounter = 0;
	private double firingRate, attackingRange;  // need to figure out the firing rate int or double!!!
	private engine.weapon.Weapon weaponType;
	private Tower shootingAgent;
	public Gun(double firingRate, engine.weapon.Weapon weaponType, double attackingRange, Tower shootingAgent) {
		this.firingRate = firingRate;
		this.weaponType = weaponType; 
		this.attackingRange = attackingRange;
		this.shootingAgent = shootingAgent;
	}
	
	boolean isFiring(){
		fireCounter++;
		if(fireCounter % firingRate == 0)
			return true;
		return false;
	}

	Weapon getWeapon(){
		 String name = weaponType.getName(); 
		 int ID = weaponType.getId(); 
		 double demage = 10; // get from weapon type later
		 double speedX = 10;  // how trajectory translates into x y speed???? talk to engine people
		 double speedY = 10;
		 String image = weaponType.getImagePath();
		 double[] initialCoordinates = {shootingAgent.getX(), shootingAgent.getY()};
		 return new Weapon (name, ID, demage, speedX, speedY, image, initialCoordinates, this.attackingRange);
	}
	
	
	
	
}
