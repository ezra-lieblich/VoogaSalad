package gameplayer.controller;

import java.util.Observable;
import java.util.Observer;

import gameplayer.model.GamePlayModel;
import gameplayer.view.GameGUI;
import gameplayer.view.GridGUI;
import gameplayer.view.helper.dragdrop.DragDrop;
import gameplayer.view.helper.dragdrop.DragDropView;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class DragDropController implements Observer{
	private DragDrop dragDrop;
	private GamePlayModel model;
	private GameGUI game;
	public DragDropController(GameGUI game, GamePlayModel model){
		this.dragDrop = game.getDragDrop();
		this.model = model;
		this.dragDrop.addObserver(this);
		this.game = game;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof DragDrop){
			int x = (int)(dragDrop.getDroppedImage().getX() * (this.game.getGrid().getCellWidth()/GridGUI.GRID_WIDTH));
			int y = (int)(dragDrop.getDroppedImage().getY() * (this.game.getGrid().getCellHeight()/GridGUI.GRID_HEIGHT));
			System.out.println("Cell width: "+this.game.getGrid().getCellWidth());
			System.out.println("Image source x: "+dragDrop.getDroppedImage().getX());
			System.out.println("Cell height: "+this.game.getGrid().getCellHeight());
			System.out.println("Image source y: "+dragDrop.getDroppedImage().getY());
			boolean okToPlace = this.model.placeTower(0, x, y); //TODO: what is they tower type, how to get it? Using 0 for now as dummy
			if (!okToPlace){
				System.out.println("Not ok to place here!");
				((Pane) dragDrop.getTarget()).getParent().getChildrenUnmodifiable().remove(dragDrop.getDroppedImage());// remove((Node) dragDrop.getDroppedImage());
			}
		}
		
	}

}