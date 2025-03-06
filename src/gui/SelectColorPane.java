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
import javafx.scene.text.Font;
import logic.GameLogic;
import utils.PlayerColor;
import utils.TileType;

public class SelectColorPane extends HBox {
	
	private static final int COLOR_SIZE = 50;
	private int chosenPlayerColor = 0;
	
	public SelectColorPane() {
		
		for (PlayerColor playerColor : PlayerColor.values()) {
			
			Canvas canvas = new Canvas(COLOR_SIZE, COLOR_SIZE);
			canvas.setOnMouseClicked(event -> chooseColor(playerColor, canvas));
			canvas.setOnMouseEntered(event -> { setCursor(Cursor.HAND); });
			canvas.setOnMouseExited(event -> { setCursor(Cursor.DEFAULT); });
			
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.setFill(Color.valueOf(playerColor.name()));
			gc.fillOval(0, 0, COLOR_SIZE, COLOR_SIZE);
			
			getChildren().addAll(canvas);
		}
		
		//set this pane's style
		setAlignment(Pos.CENTER);
		setSpacing(20);
		VBox.setMargin(this, new Insets(150, 0, 0, 0));
		
	}
	
	private void chooseColor(PlayerColor playerColor, Canvas canvas) {
		
		GameLogic.addPlayerColor(playerColor);
		chosenPlayerColor++;
		
		setCursor(Cursor.DEFAULT);
		
		canvas.setOnMouseEntered(null);
		canvas.setOnMouseClicked(null);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.LIGHTGREY);
		gc.fillOval(5, 5, 40, 40);
		gc.setFill(Color.BLACK);
		gc.setFont(new Font(20));
		gc.fillText("P" + chosenPlayerColor, 15, 32.5);
		
		if (chosenPlayerColor == GameLogic.getNumberOfPlayer()) 
			GameManager.getInstance().switchToInGameScene();
	}

}
