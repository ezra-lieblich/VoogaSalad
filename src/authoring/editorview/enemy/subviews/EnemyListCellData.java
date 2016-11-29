package authoring.editorview.enemy.subviews;

import javafx.scene.image.Image;

public class EnemyListCellData {
	private String name;
	private String imagePath;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imageFilePath) {
		this.imagePath = imageFilePath;
	}
}
