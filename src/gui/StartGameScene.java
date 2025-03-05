package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class StartGameScene extends VBox {
	private static final String  TITLE_TEXT = "Croissonne";
	private static final String  SUBTITLE_TEXT = "Click Start To Begin!";
	private Label titleLabel;
	private Label subtitleLabel;
	private StartGameButton startButton;
	private SelectPlayerPane selectPlayerPane;
	
	public StartGameScene() {
		
		//initialize component
		initializeLabel();
		startButton = new StartGameButton();	
		
		//set scene's style
		setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		setPrefHeight(750);
		setPrefWidth(1200);
		setAlignment(Pos.CENTER);
		
		//add component in this scene
		getChildren().addAll(titleLabel, subtitleLabel, startButton);
	}
	
	
	private void initializeLabel() {
		//set label's style
		
		//Title
		titleLabel = new Label(TITLE_TEXT);
		titleLabel.setFont(new Font("Georgia", 120));
		titleLabel.setPadding(new Insets(10));
		
		//Sub-title
		subtitleLabel = new Label(SUBTITLE_TEXT);
		subtitleLabel.setFont(new Font("Cambria", 36));
		VBox.setMargin(subtitleLabel, new Insets(0, 10, 70, 10));
	}
	
	public void removeStartButton() {
		getChildren().remove(startButton);
	}
	
	public void addSelectPlayerButton() {
		selectPlayerPane = new SelectPlayerPane();
		getChildren().add(selectPlayerPane);
	}

}

