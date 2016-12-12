package engine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.google.common.io.Files;

import authoring.utilityfactories.DialogueBoxFactory;
import javafx.scene.control.Alert;

public class FileAggregator {
	private final String IMAGES_DIRECTORY_NAME = "images";
	private static FileAggregator defaultInstance;
	//Map images used to the number of places used in the program. Remove on count=0
	private HashMap<String, Integer> originalImagePaths;

	private FileAggregator(){
		this.originalImagePaths = new HashMap<String, Integer>();
	}
	
	public static FileAggregator defaultInstance(){
		if (defaultInstance==null){
			defaultInstance = new FileAggregator();
		}
		return defaultInstance;
	}
	
	/**
	 * Adds the image path to the game assets if it is not already included. Updates counts to track number of uses of a given image in order to know whether it should be removed from the assets.
	 * @param oldImagePath – This may be null
	 * @param newImagePath
	 */
	public void addImageToAssets(String oldImagePath, String newImagePath){
		decrementImageCount(oldImagePath);
		incrementImageCount(newImagePath);
		System.out.println("IMAGES & COUNTS: ");
		for (String s : originalImagePaths.keySet()){
			System.out.println("Image: "+s+", count: "+originalImagePaths.get(s));
		}
	}
	
	private void decrementImageCount(String path){
		Integer count = this.originalImagePaths.get(path);
		if (count==null){
			return;
		}
		if (count <= 1){
			this.originalImagePaths.remove(path);
		} else{
			this.originalImagePaths.put(path, count-1);
		}
	}
	
	private void incrementImageCount(String path){
		Integer count = this.originalImagePaths.get(path);
		if (count == null){
			this.originalImagePaths.put(path, 1);
		}
		else{
			this.originalImagePaths.put(path, count+1);
		}
	}
	
	public File createGameFolder(File rootDirectory, String xmlContent){
		rootDirectory.mkdirs();
		//Game folder name and xml file name will match
		String xmlFileName = this.getFileNameFromPath(rootDirectory.getAbsolutePath()+".xml");
		File xmlFile = new File(rootDirectory, xmlFileName);
		try {
			FileWriter fileWriter = new FileWriter(xmlFile);
			fileWriter.write(xmlContent);
			fileWriter.close();
			generateImagesFolder(rootDirectory);
			return rootDirectory;
		}
		catch (IOException e) {
			Alert fileError =
					DialogueBoxFactory.createErrorDialogueBox("Error with file. Can't be saved",
							"File Error");
			fileError.show();
			return null;
		}
	}
	
	private File generateImagesFolder(File gameDirectory){
		File images = new File(gameDirectory, IMAGES_DIRECTORY_NAME);
		images.mkdirs();
		for (String s : this.originalImagePaths.keySet()){
			File sourceFile = new File(s);
			File copiedFile = new File(images, getFileNameFromPath(s));
			try {
				Files.copy(sourceFile, copiedFile);
			} catch (IOException e) {
				System.out.println("FAILED TO COPY IMAGE FILE: "+s);
				e.printStackTrace();
			}
		}
		return images;
	}
	
	private String getFileNameFromPath(String filePath){
		String[] pathComponents = filePath.split("/");
		String name = pathComponents[pathComponents.length-1];
		return name;
	}
	
}
