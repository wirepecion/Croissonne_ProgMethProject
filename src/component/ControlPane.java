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
	
	private Button drawButton;
	
	public ControlPane() {
		setPrefHeight(800);
		setPrefWidth(500);
		
		Player player1 = new Player("player1", PlayerColor.BLUE);
		Player player2 = new Player("player2", PlayerColor.RED);
		
		getChildren().addAll(player1.getPlayerStatPane(), player2.getPlayerStatPane(), drawButton);
	}
	
	public void initializeDrawButton() {
		drawButton = new Button();
		drawButton.setPrefWidth(300);
		drawButton.setPrefHeight(100);
		drawButton.setBackground(new Background(new BackgroundFill(Color.DARKRED, CornerRadii.EMPTY, Insets.EMPTY)));
		drawButton.setOnMouseClicked(event -> drawButtonHandler());
	}
	
	public void drawButtonHandler() {
		//Gamelogic draw new tile
	}
	
}
