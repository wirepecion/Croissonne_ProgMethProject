package component;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import utils.PlayerColor;

public class ControlPane extends VBox {
	
	private Button passButton;
	
	public ControlPane() {
		setPrefHeight(750);
		setPrefWidth(500);
		
		//For Test
		Player player1 = new Player("player1", PlayerColor.BLUE);
		Player player2 = new Player("player2", PlayerColor.RED);
		initializePassButton();
		
		getChildren().addAll(player1.getPlayerStatPane(), player2.getPlayerStatPane(), passButton);
	}
	
	public void initializePassButton() {
		passButton = new Button();
		passButton.setPrefWidth(300);
		passButton.setPrefHeight(100);
		passButton.setBackground(new Background(new BackgroundFill(Color.DARKRED, CornerRadii.EMPTY, Insets.EMPTY)));
		passButton.setOnMouseClicked(event -> drawButtonHandler());
	}
	
	public void drawButtonHandler() {
		//Gamelogic draw new tile
	}
	
}
