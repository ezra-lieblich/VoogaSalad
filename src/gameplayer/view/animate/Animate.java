package gameplayer.view.animate;

import javafx.animation.Timeline;
import javafx.scene.image.ImageView;

public class Animate {
	
	public Animate(){
		
	}
	
	public void updateEnemy(ImageView enemy, double x, double y){
		enemy.setX(x);
		enemy.setY(y);
	}
	
	public void throwWeapon(ImageView weapon, double x, double y){
		weapon.setX(x);
		weapon.setY(y);
	}

}
