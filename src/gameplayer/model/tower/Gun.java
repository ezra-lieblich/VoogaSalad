package gameplayer.model.tower;

import gameplayer.model.weapon.Weapon;

public class Gun {

	private int fireCounter = 0;
	private double firingRate, attackingRange;  // need to figure out the firing rate int or double!!!
	private engine.weapon.Weapon weaponType;
	private double xcoor, ycoor;
	
	public Gun(double firingRate, engine.weapon.Weapon weaponType, double attackingRange, int x, int y) {
		this.firingRate = firingRate;
		this.weaponType = weaponType; 
		this.attackingRange = attackingRange;
		this.xcoor = x;
		this.ycoor = y; 

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
		 return new Weapon (name, ID, demage, speedX, speedY, image, this.attackingRange);
	}

}
