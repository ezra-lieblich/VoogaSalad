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

	public DragDrop() {
	}

	
	public void init(ImageView source, Node target){
		System.out.println("source: "+source+", target: "+target);
		detectDrag(source, target);
	}

	private void initDragDetectionIcon(ImageView source){
		Dragboard db = source.startDragAndDrop(TransferMode.MOVE);
		System.out.println(db.getImage());
		ClipboardContent content = new ClipboardContent();
		content.putString("blahy poo");
		db.setContent(content);	
	}
	
	private void addImagetoDroppedLoc(double xpos, double ypos, Node target, ImageView source){
		ImageView copy = new ImageView(source.getImage());
		((Pane) target).getChildren().add(copy);
		copy.setX(xpos);
		copy.setY(ypos);
	}
	
	private void detectDrag(ImageView source, Node target) {


		source.setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				/* drag was detected, start drag-and-drop gesture */
				System.out.println(source.getImage());
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
			System.out.println("on drag dropped!");
			// Dragboard db = event.getDragboard();
			// System.out.println("The db likely null: "+db.getImage());
			System.out.println("in db.hasImage()");
			double xcoord = event.getSceneX();
			double ycoord = event.getSceneY();
			// ImageView imageView = new ImageView(source/* db.getImage() */);
			// imageView.setFitHeight(30);
			// imageView.setFitWidth(30);
			// imageView.setPreserveRatio(true);

			addImagetoDroppedLoc(xcoord, ycoord, target, source);
			event.setDropCompleted(true);
			// }

		});

		target.setOnDragExited(e -> {

		});
	}

}
