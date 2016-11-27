package gameplayer.controller;

import java.util.Observable;
import java.util.Observer;

import gameplayer.model.GamePlayModel;
import gameplayer.view.helper.dragdrop.DragDrop;
import gameplayer.view.helper.dragdrop.DragDropView;

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
			this.model.placeTower(0, (int)dragDrop.getSource().getX(), (int)dragDrop.getSource().getY()); //TODO: what is they tower type, how to get it? Using 0 for now as dummy
		}
		
	}

}
