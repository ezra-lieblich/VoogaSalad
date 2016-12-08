package gameplayer.model.tower;

import gameplayer.model.weapon.Weapon;

public class Gun {

	private int fireCounter = 0;
	private double firingRate, attackingRange;  // need to figure out the firing rate int or double!!!
	private engine.weapon.Weapon weaponType;
	private double xcoor, ycoor; // in pixel
	
	public Gun(int firingRate, engine.weapon.Weapon weaponType,  double x, double y) {
		this.firingRate = firingRate;
		this.weaponType = weaponType; 
		this.attackingRange = weaponType.getRange();
		this.xcoor = x;
		this.ycoor = y; 
	}
	
	double getx(){
		return this.xcoor;
	}
	
	double gety(){
		return this.ycoor;
	}
	
	double getRange(){
		return this.attackingRange;
	}
	
	boolean isFiring(){
		fireCounter++;
		if(fireCounter % firingRate == 0)
			return true;
		return false;
	}
	
	Weapon getWeapon(int targetID, double targetX, double targetY){
		 String name = weaponType.getName(); 
		 double demage = 50; // get from weapon type later
		 String image = weaponType.getImagePath();
		 return new Weapon (name,  demage, targetX, targetY, image, this.attackingRange,targetID, this.xcoor,this.ycoor);
	}

}
