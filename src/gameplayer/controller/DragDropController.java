package gameplayer.controller;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import engine.tower.Tower;

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
	private HashMap<Integer,Tower>towerTypes; 
	
	
	public DragDropController(GameGUI game, GamePlayModel model, HashMap<Integer,Tower>towerTypes){
		this.dragDrop = game.getDragDrop();
		this.model = model;
		this.dragDrop.addObserver(this);
		this.game = game;
		this.towerTypes = towerTypes; 
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof DragDrop){
			String towerId = dragDrop.getDroppedImage().getId();
			int x = (int)(dragDrop.getDroppedImage().getX() * (this.game.getGrid().getCellWidth()/GridGUI.GRID_WIDTH));
			int y = (int)(dragDrop.getDroppedImage().getY() * (this.game.getGrid().getCellHeight()/GridGUI.GRID_HEIGHT));
			boolean okToPlace = this.model.placeTower(Integer.parseInt(towerId), x, y); //TODO: what is they tower type, how to get it? Using 0 for now as dummy
			if (!okToPlace){
				System.out.println("Not ok to place here!");
				((Pane) dragDrop.getTarget()).getParent().getChildrenUnmodifiable().remove(dragDrop.getDroppedImage());// remove((Node) dragDrop.getDroppedImage());
			}
		}
		
	}

}
