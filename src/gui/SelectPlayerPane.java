package gui;

import data.ResourceLoader;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.GameLogic;
import utils.MouseEventHandler;
import utils.PlayerColor;

public class SelectPlayerPane extends Pane {
	private MyButton twoPlayerButton;
	private MyButton threePlayerButton; 
	private MyButton fourPlayerButton;
	
//	private String[] twoPlayerName = new String[] { "Player 1", "Player 2" };
//	private String[] threePlayerName = new String[] { "Player 1", "Player 2", "Player 3" };
//	private String[] fourPlayerName = new String[] { "Player 1", "Player 2", "Player 3", "Player 4" };
	
	public SelectPlayerPane() {
		
		initializeTwoPlayerButton();
		initializeThreePlayerButton();
		initializeFourPlayerButton();
		
		setPrefHeight(750);
		setPrefWidth(1200);
		
		setBackground(new Background(new BackgroundImage(ResourceLoader.getSelectPlayerBackground(), null, null, null, null)));
		
		getChildren().addAll(twoPlayerButton, threePlayerButton, fourPlayerButton);
	}
	
	private void initializeTwoPlayerButton() {
		
		twoPlayerButton = new MyButton();
		
		//set's button style
		twoPlayerButton.setLayoutX(276);
		twoPlayerButton.setLayoutY(312);
		
		//set event-handler
		twoPlayerButton.setOnMouseClicked(e -> {
			GameLogic.setNumberOfPlayer(2);
			GameLogic.setPlayerName(getPlayerName(2));
			GameManager.getInstance().switchToSelectColorPane();
		});
		
		MouseEventHandler.applyHoverEffect(twoPlayerButton);
	}
	
	private void initializeThreePlayerButton() {
		
		threePlayerButton = new MyButton();
		
		//set's button style
		threePlayerButton.setLayoutX(276);
		threePlayerButton.setLayoutY(447);

		//set event-handler
		threePlayerButton.setOnMouseClicked(e -> {
			GameLogic.setNumberOfPlayer(3);
			GameLogic.setPlayerName(getPlayerName(3));
			GameManager.getInstance().switchToSelectColorPane();
		});
		
		MouseEventHandler.applyHoverEffect(threePlayerButton);
	}

	private void initializeFourPlayerButton() {
	
		fourPlayerButton = new MyButton();
		
		//set's button style
		fourPlayerButton.setLayoutX(276);
		fourPlayerButton.setLayoutY(587);

		
		//set event-handler
		fourPlayerButton.setOnMouseClicked(e -> {
			GameLogic.setNumberOfPlayer(4);
			GameLogic.setPlayerName(getPlayerName(4));
			GameManager.getInstance().switchToSelectColorPane();
		});
		
		MouseEventHandler.applyHoverEffect(fourPlayerButton);
	}
	
	private String[] getPlayerName(int num) {
		String[] playerNameList = new String[num];
		
		for(int i = 1; i <= num; i++) {
			playerNameList[i-1] = "PLayer " + i;
		}
		
		return playerNameList;
	}
}
