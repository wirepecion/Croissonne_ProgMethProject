package gui;

import data.AudioLoader;
import data.ImageLoader;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import utils.MouseEventHandler;


public class StartGamePane extends Pane {
	
	MyButton startBtn;
	MyButton howToPlayBtn;
	MyButton exitBtn;
	
	public StartGamePane() {
		
		//initialize button
		initializeStartButton();
		initializeHowToPlayBtn();
		initializeExitButton();
		
		setPrefHeight(750);
		setPrefWidth(1200);
		
		setBackground(new Background(new BackgroundImage(ImageLoader.getStartGameBackgroundImage(), null, null, null, null)));
		
		getChildren().addAll(startBtn, howToPlayBtn, exitBtn);
	}
	
	private void initializeStartButton() {
		
		startBtn = new MyButton();
		
		//set's button position
		startBtn.setLayoutX(275);
		startBtn.setLayoutY(310);
		
		//set event-handler
		startBtn.setOnMouseClicked(e -> {
			GameManager.getInstance().switchToSelectPlayerPane();
		});
		
		MouseEventHandler.applyHoverEffect(startBtn);
	}
	
	private void initializeHowToPlayBtn() {
		
		howToPlayBtn = new MyButton();
		
		//set's button position
		howToPlayBtn.setLayoutX(275);
		howToPlayBtn.setLayoutY(476);
		
		//set event-handler
		howToPlayBtn.setOnMouseClicked(e -> {
			GameManager.getInstance().switchToHowToPlayScene();
		});
		
		MouseEventHandler.applyHoverEffect(howToPlayBtn);
	}

	private void initializeExitButton() {
	
		exitBtn = new MyButton();
		
		//set's button position
		exitBtn.setLayoutX(275);
		exitBtn.setLayoutY(603);
		
		//set event-handler
		exitBtn.setOnMouseClicked(e -> {
			Platform.exit();
		});
		exitBtn.setOnMouseEntered(event -> { setCursor(Cursor.HAND); });
		exitBtn.setOnMouseExited(event -> { setCursor(Cursor.DEFAULT); });
		
		MouseEventHandler.applyHoverEffect(exitBtn);
	}
}
