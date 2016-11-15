package gameplayer.view.helper.dragdrop;

import com.sun.javafx.geom.Point2D;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

public class DragDrop {
	//private ImageView source;
	//private Node target;

	// get rid of this later
	private ImageView source;

	public DragDrop() {
	}

	
	public void init(ImageView source, Node target){
		//System.out.println("source: "+source+", target: "+target);
		detectDrag(source, target);
	}

	private void initDragDetectionIcon(ImageView source){
		//System.out.println("Current source: "+source.getImage());
		Dragboard db = source.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent content = new ClipboardContent();
		content.putString("blahy poo");
		db.setContent(content);	
	}
	
	private void addImagetoDroppedLoc(double xpos, double ypos, Node target, ImageView source){
		System.out.println("Original source: "+source.getImage());
		ImageView copy = new ImageView(source.getImage());
		((Pane) target).getChildren().add(copy);
		copy.setX(xpos);
		copy.setY(ypos);
	}
	
	private void setSource(ImageView source){
		this.source = source;
	}
	
	private void detectDrag(ImageView source, Node target) {
		System.out.println("Source in detectDrag: "+source.getImage());


		source.setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setSource(source);
				System.out.println("Currently clicking on: "+source.getImage());
				/* drag was detected, start drag-and-drop gesture */
				initDragDetectionIcon(source);
				event.consume();
			}
		});

		target.setOnDragOver(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {
				/* data is dragged over the target */
				// System.out.println("over target!");

				//System.out.println(source.getX() + "," + source.getY());
				/*
				 * accept it only if it is not dragged from the same node and if
				 * it has a string data
				 */
				double xcoord = event.getSceneX();
				double ycoord = event.getSceneY();
				
				if (event.getGestureSource() != target) {
					/* allow for moving */
					event.acceptTransferModes(TransferMode.MOVE);

				}

				event.consume();
			}
		});

		target.setOnDragDropped(event -> {
			//System.out.println("on drag dropped!");
			// Dragboard db = event.getDragboard();
			// System.out.println("The db likely null: "+db.getImage());
			//System.out.println("in db.hasImage()");
			System.out.println("Source in setOnDragDropped: "+source.getImage());
			double xcoord = event.getSceneX();
			double ycoord = event.getSceneY();
			ImageView copy = new ImageView(this.source.getImage());
			((Pane) target).getChildren().add(copy);
			copy.setX(xcoord);
			copy.setY(ycoord);
			event.setDropCompleted(true);
			// }

		});

		target.setOnDragExited(e -> {

		});
	}

}
