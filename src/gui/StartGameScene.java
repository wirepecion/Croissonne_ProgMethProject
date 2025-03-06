package gui;

import data.ResourceLoader;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class StartGameScene extends Pane {
	private static final String  TITLE_TEXT = "Croissonne";
	
	private StartGameButton startGameButton;
	private SelectPlayerPane selectPlayerPane;
	private SelectColorPane selectColorPane;
	
	Button startBtn;
	Button howToPlayBtn;
	Button exitBtn;
	
	Pane howToPlayPane;
	
	public StartGameScene() {
		
		//initialize component	
		
		initializeStartButton();
		initializeHowToPlayBtn();
		initializeExitButton();
		
		
		//set scene's style
		setBackground(new Background(new BackgroundImage(ResourceLoader.getStartGameBackgroundImage(), null, null, null, null)));
		setPrefHeight(750);
		setPrefWidth(1200);
//		setAlignment(Pos.CENTER);
		
		//add component in this scene
		getChildren().addAll(startBtn, howToPlayBtn, exitBtn);
	}
	
	
	
	public void addSelectPlayerButton() {
		selectPlayerPane = new SelectPlayerPane();
		getChildren().add(selectPlayerPane);
	}
	
	public void removeSelectPlayerButton() {
		getChildren().remove(selectPlayerPane);
	}
	
	public void addSelectColorButton() {
		selectColorPane = new SelectColorPane();
		getChildren().add(selectColorPane);
	}
	
	private void initializeStartButton() {
		
		startBtn = new Button();
		
		//set's button style
		startBtn.setLayoutX(275);
		startBtn.setLayoutY(310);
		startBtn.setPrefWidth(350);
		startBtn.setPrefHeight(90);
		startBtn.setOpacity(0);
//		startBtn.setVisible(false);
//		startBtn.setDisable(false);
//		startBtn.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
		//set event-handler
		startBtn.setOnMouseClicked(e -> {
			GameManager.getInstance().switchToSelectPlayerScene();
		});
	}
	
	private void initializeHowToPlayBtn() {
		
		howToPlayBtn = new Button();
		
		//set's button style
		howToPlayBtn.setLayoutX(275);
		howToPlayBtn.setLayoutY(476);
		howToPlayBtn.setPrefWidth(350);
		howToPlayBtn.setPrefHeight(90);
		howToPlayBtn.setOpacity(0);
//		howToPlayBtn.setVisible(false);
//		howToPlayBtn.setDisable(false);
//		howToPlayBtn.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		
		//set event-handler
		howToPlayBtn.setOnMouseClicked(e -> {
			GameManager.getInstance().switchToHowToPlayScene();
		});
	}

	private void initializeExitButton() {
	
		exitBtn = new Button();
		
		//set's button style
		exitBtn.setLayoutX(275);
		exitBtn.setLayoutY(603);
		exitBtn.setPrefWidth(350);
		exitBtn.setPrefHeight(90);
		exitBtn.setOpacity(0);
//		exitBtn.setVisible(false);
//		exitBtn.setDisable(false);
//		exitBtn.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
		
		//set event-handler
		exitBtn.setOnMouseClicked(e -> {
			Platform.exit();
		});
	}
}

