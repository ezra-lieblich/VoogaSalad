package gameauthoringenvironment.view.weapon;



public class WeaponViewFactory {
	
	public static IWeaponView build () {
        return new WeaponView();
    }

}
