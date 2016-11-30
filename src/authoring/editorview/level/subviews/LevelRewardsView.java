package authoring.editorview.level.subviews;

import java.util.ResourceBundle;

import authoring.editorview.level.LevelEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.DialogueBoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LevelRewardsView {
	
	private VBox root;
	private LevelEditorViewDelegate delegate;
	private int activeLevelID;
	
	private TextField rewardHealthTextField;
	private TextField rewardMoneyTextField;
	private TextField rewardPointsTextField;
	private double rewardHealth;
	private double rewardMoney;
	private double rewardPoints;
	
	//TODO: reduce duplicated code
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringLevels";	
	private ResourceBundle levelResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public LevelRewardsView(){
		root = new VBox(10);
		makeHealthRewardTextField();
		makeMoneyRewardTextField();
		makePointsRewardTextField();
	}
	
	
	public Node getInstanceAsNode(){
		return root;
	}
	
	public void setDelegate(LevelEditorViewDelegate delegate){
		this.delegate = delegate;
	}
	
	public void setActiveLevelId(int levelID){
		this.activeLevelID = levelID;
	}
	
	
	
	private void makeHealthRewardTextField(){
		rewardHealthTextField = TextFieldFactory.makeTextField("", 
				e -> submitRewardHealth(rewardHealthTextField.getText()));
		rewardHealthTextField.setMaxWidth(75);
		HBox rewardHealthBox = BoxFactory.createHBoxWithLabelandNode(levelResource.getString("RewardHealthTextField"), rewardHealthTextField);
		
		root.getChildren().add(rewardHealthBox);
		
	}
	
	private void makeMoneyRewardTextField(){
		rewardMoneyTextField = TextFieldFactory.makeTextField("", 
				e -> submitRewardMoney(rewardMoneyTextField.getText()));
		rewardMoneyTextField.setMaxWidth(75);
		HBox rewardMoneyBox = BoxFactory.createHBoxWithLabelandNode(levelResource.getString("RewardMoneyTextField"), rewardMoneyTextField);
		
		root.getChildren().add(rewardMoneyBox);
		
	}
	
	private void makePointsRewardTextField(){
		rewardPointsTextField = TextFieldFactory.makeTextField("", 
				e -> submitRewardPoints(rewardPointsTextField.getText()));
		rewardPointsTextField.setMaxWidth(75);
		HBox rewardPointsBox = BoxFactory.createHBoxWithLabelandNode(levelResource.getString("RewardPointsTextField"), rewardPointsTextField);
		
		root.getChildren().add(rewardPointsBox);
		
	}
	
	private void submitRewardHealth(String healthString){
		try {
			rewardHealth = Double.parseDouble(healthString);
			delegate.onUserEnteredRewardHealth(activeLevelID, rewardHealth);
		}
		catch (NumberFormatException e){
			Alert inputError = DialogueBoxFactory.createErrorDialogueBox("Reward health must be a number", "Input error");
			inputError.show();
		}
	}
	
	
	private void submitRewardMoney(String moneyString){
		try {
			rewardMoney = Double.parseDouble(moneyString);
			delegate.onUserEnteredRewardMoney(activeLevelID, rewardMoney);
		}
		catch (NumberFormatException e){
			Alert inputError = DialogueBoxFactory.createErrorDialogueBox("Reward money must be a number", "Input error");
			inputError.show();
		}
	}
	
	
	
	private void submitRewardPoints(String pointsString){
		try {
			rewardPoints = Double.parseDouble(pointsString);
			delegate.onUserEnteredRewardPoints(activeLevelID, rewardPoints);
		}
		catch (NumberFormatException e){
			Alert inputError = DialogueBoxFactory.createErrorDialogueBox("Reward points must be a number", "Input error");
			inputError.show();
		}
	}
	

	public void setRewardHealth(double rewardHealth){
		this.rewardHealth = rewardHealth;
		rewardHealthTextField.setText(Double.toString(rewardHealth));
	}
	
	public void setRewardMoney(double rewardMoney){
		this.rewardMoney = rewardMoney;
		rewardMoneyTextField.setText(Double.toString(rewardMoney));
	}

	public void setRewardPoints(double points){
		this.rewardPoints = points;
		rewardPointsTextField.setText(Double.toString(rewardPoints));
	}
}
