package gameauthoringenvironment.view.tower;


public class TowerViewFactory {
	
	public static ITowerView build () {
        return new TowerView();
    }

}
