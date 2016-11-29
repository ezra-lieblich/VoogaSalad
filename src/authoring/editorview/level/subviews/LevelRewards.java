package authoring.editorview.level.subviews;

import java.util.ResourceBundle;

import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LevelRewards {
	
	private VBox root;
	
	private TextField rewardHealthTextField;
	private TextField rewardMoneyTextField;
	private TextField rewardPointsTextField;
	private int rewardHealth;
	private int rewardMoney;
	private int rewardPoints;
	
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringLevels";	
	private ResourceBundle levelResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public LevelRewards(){
		root = new VBox();
		makeHealthRewardTextField();
		makeMoneyRewardTextField();
		makePointsRewardTextField();
	}
	
	
	public Node getInstanceAsNode(){
		return root;
	}
	
	
	private void makeHealthRewardTextField(){
		rewardHealthTextField = TextFieldFactory.makeTextField("0", 
				e -> setRewardHealth(rewardHealthTextField.getText()));
		rewardHealthTextField.setMaxWidth(75);
		HBox rewardHealthBox = BoxFactory.createHBoxWithLabelandNode(levelResource.getString("RewardHealthTextField"), rewardHealthTextField);
		
		root.getChildren().add(rewardHealthBox);
		
	}
	
	private void makeMoneyRewardTextField(){
		rewardMoneyTextField = TextFieldFactory.makeTextField("0", 
				e -> setRewardMoney(rewardMoneyTextField.getText()));
		rewardMoneyTextField.setMaxWidth(75);
		HBox rewardMoneyBox = BoxFactory.createHBoxWithLabelandNode(levelResource.getString("RewardMoneyTextField"), rewardMoneyTextField);
		
		root.getChildren().add(rewardMoneyBox);
		
	}
	
	private void makePointsRewardTextField(){
		rewardPointsTextField = TextFieldFactory.makeTextField("0", 
				e -> setRewardPoints(rewardPointsTextField.getText()));
		rewardPointsTextField.setMaxWidth(75);
		HBox rewardPointsBox = BoxFactory.createHBoxWithLabelandNode(levelResource.getString("RewardPointsTextField"), rewardPointsTextField);
		
		root.getChildren().add(rewardPointsBox);
		
	}
	
	//TODO: error check
	private void setRewardHealth(String rewardHealth){
		this.rewardHealth = Integer.parseInt(rewardHealth);
	}
	
	private void setRewardMoney(String rewardMoney){
		this.rewardMoney = Integer.parseInt(rewardMoney);
	}

	private void setRewardPoints(String rewardPoints){
		this.rewardPoints = Integer.parseInt(rewardPoints);
	}
}
