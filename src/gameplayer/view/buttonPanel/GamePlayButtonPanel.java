package gameplayer.view.buttonPanel;

import gameplayer.view.helper.GraphicsLibrary;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class GamePlayButtonPanel{
	
	private ButtonPanel panel;
	private GraphicsLibrary graphicsLib;
	
	public GamePlayButtonPanel(){
		this.panel = new ButtonPanel();
		this.graphicsLib = new GraphicsLibrary();
	}
	
	public HBox getPane(){
		return this.panel.getButtonPanel();
	}
	
	public void init(){
		panel.init(createButtons());
	}
	
	private Button[] createButtons(){
		Button[] buttonArr = {createPlayButton()};
		return buttonArr;
	}
	
	private Button createPlayButton(){
		Button play = graphicsLib.createButton("Play");
		play.setOnAction(e->{
			//TODO: initialize animation
		});
		return play;
	}
	

}
