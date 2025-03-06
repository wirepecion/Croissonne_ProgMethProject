package gui;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameLogic;
import utils.PlayerColor;
import utils.TileType;

public class SelectColorPane extends HBox {
	
	private static final int COLOR_SIZE = 50;
	private int chosenPlayerColor = 0;
	
	public SelectColorPane() {
		
		for (PlayerColor playerColor : PlayerColor.values()) {
			Canvas canvas = new Canvas(COLOR_SIZE, COLOR_SIZE);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.setFill(Color.valueOf(playerColor.name()));
			gc.fillOval(0, 0, COLOR_SIZE, COLOR_SIZE);
			canvas.setOnMouseClicked(event -> chooseColor(playerColor));
			canvas.setOnMouseEntered(event -> MouseEnteredHandler());
			canvas.setOnMouseExited(event -> MouseExitedHandler());
			getChildren().addAll(canvas);
		}
		
		//set this pane's style
		setAlignment(Pos.CENTER);
		setSpacing(20);
		VBox.setMargin(this, new Insets(150, 0, 0, 0));
		
	}
	
	private void chooseColor(PlayerColor playerColor) {
		System.out.println(playerColor.name());
		GameLogic.addPlayerColor(playerColor);
		chosenPlayerColor++;
		if (chosenPlayerColor == GameLogic.getNumberOfPlayer()) 
			GameManager.getInstance().switchToInGameScene();
	}
	
	private void MouseEnteredHandler() {
		setCursor(Cursor.HAND);
	}
	
	private void MouseExitedHandler() {
		setCursor(Cursor.DEFAULT);
	}
	
}
