package gameplayer.controller;

import java.util.Observable;
import java.util.Observer;

import gameplayer.model.GamePlayModel;
import gameplayer.view.helper.dragdrop.DragDrop;
import gameplayer.view.helper.dragdrop.DragDropView;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class DragDropController implements Observer{
	private DragDrop dragDrop;
	private GamePlayModel model;
	public DragDropController(DragDrop dragDrop, GamePlayModel model){
		this.dragDrop = dragDrop;
		this.model = model;
		this.dragDrop.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof DragDrop){
			boolean okToPlace = this.model.placeTower(0, (int)dragDrop.getSource().getX(), (int)dragDrop.getSource().getY()); //TODO: what is they tower type, how to get it? Using 0 for now as dummy
			if (!okToPlace){
				System.out.println("Not ok to place here!");
				((Pane) dragDrop.getTarget()).getParent().getChildrenUnmodifiable().remove(dragDrop.getSource());// remove((Node) dragDrop.getSource());
			}
		}
		
	}

}
