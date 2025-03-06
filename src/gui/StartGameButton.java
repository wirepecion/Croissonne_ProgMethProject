package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class StartGameButton extends Pane {
	
	Button startBtn;
	Button howToPlayBtn;
	Button exitBtn;
	
	public StartGameButton() {
		//initialize button
		initializeStartButton();
		initializeHowToPlayBtn();
		initializeExitButton();
		
		setPrefHeight(750);
		setPrefWidth(1200);
		
		getChildren().addAll(startBtn, howToPlayBtn, exitBtn);
	}
	
	private void initializeStartButton() {
		
		startBtn = new Button();
		
		//set's button style
		startBtn.setLayoutX(275);
		startBtn.setLayoutY(310);
		startBtn.setPrefWidth(350);
		startBtn.setPrefHeight(90);
//		startBtn.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
		//set event-handler
		setOnMouseClicked(e -> {
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
//		howToPlayBtn.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		
		//set event-handler
		setOnMouseClicked(e -> {
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
//		exitBtn.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
		
		//set event-handler
		setOnMouseClicked(e -> {
			GameManager.getInstance().switchToSelectPlayerScene();
		});
	}
}
