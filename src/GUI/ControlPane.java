package gui;

import component.Player;
import component.Tile;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameLogic;
import logic.TileStorage;
import utils.PlayerColor;

public class ControlPane extends VBox {
	
	private static Canvas tilePane;
	private Button passButton;
	
	public ControlPane() {
		setPrefHeight(750);
		setPrefWidth(500);
		setSpacing(10);
		setAlignment(Pos.CENTER);
		
		for (int i = 0; i < GameLogic.getPlayer().length; i++) {
			getChildren().addAll(GameLogic.getPlayer()[i].getPlayerStatPane());
		}
		
		initializeTilePane();
		initializePassButton();
		
		getChildren().addAll( 
			tilePane,
			passButton
		);
	}
	
	public void initializeTilePane() {
		tilePane = new Canvas(TilePane.getTileSize() * 2, TilePane.getTileSize() * 2);
		tilePane.setOnMouseClicked(event -> rotateTile());
		tilePane.setOnMouseEntered(event -> onMouseEnteredHandler());
		tilePane.setOnMouseExited(event -> onMouseExitedHandler());
		GameLogic.randomTile();
		GameLogic.startGame();
	}
	
	public void initializePassButton() {
		passButton = new Button("Pass");
		passButton.setPrefWidth(300);
		passButton.setPrefHeight(100);
		passButton.setBackground(new Background(new BackgroundFill(
				Color.DARKRED, CornerRadii.EMPTY, Insets.EMPTY)));
		passButton.setFont(new Font("Arial Bold", 50));
		passButton.setStyle("-fx-text-fill: white;");
		passButton.setOnMouseClicked(event -> onMouseClicked());
		passButton.setOnMouseEntered(event -> onMouseEnteredHandler());
		passButton.setOnMouseExited(event -> onMouseExitedHandler());
	}
	
	private void rotateTile() {
		GameLogic.getCurrentTile().rotate();
		tilePane.setRotate(tilePane.getRotate() + 90);
	}
	
	private void onMouseClicked() {
		GameLogic.getCurrentPlayer().updatePenalty(1);
		GameLogic.randomTile();
	}
	
	public static void resetTilepane() {
		tilePane.setRotate(0);
	}
	
	private void onMouseEnteredHandler() {
		setCursor(Cursor.HAND);
	}
	
	private void onMouseExitedHandler() {
		setCursor(Cursor.DEFAULT);
	}

	public static Canvas getTilePane() {
		return tilePane;
	}
	
}
