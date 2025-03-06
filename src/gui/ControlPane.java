package gui;

import component.Player;
import component.Tile;
import data.ResourceLoader;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;
import logic.TileStorage;
import utils.PlayerColor;

public class ControlPane extends VBox {
	
	private Pane gameControlPane;
	private static Canvas tilePane;
	private static Button remainingText;
	private Button passButton;
	
	public ControlPane() {
		setPrefHeight(750);
		setPrefWidth(400);
		setSpacing(10);
		setAlignment(Pos.CENTER);
		
		for (int i = 0; i < GameLogic.getPlayer().length; i++) {
			getChildren().addAll(GameLogic.getPlayer()[i].getPlayerStatPane());
		}
		
		initializeGameControlPane();
		
		getChildren().addAll(gameControlPane);
	}
	
	private void initializeGameControlPane() {
		gameControlPane = new Pane();
		gameControlPane.setPrefHeight(200);
		
		initializeRemainingText();
		initializeTilePane();
		initializePassButton();
		
		gameControlPane.getChildren().addAll(tilePane, remainingText, passButton);
	}
	
	private void initializeTilePane() {
		System.out.println("in process ...");
		tilePane = new Canvas(TilePane.getTileSize() * 3, TilePane.getTileSize() * 3);
		tilePane.setLayoutX(25);
		tilePane.setLayoutY(25);
		tilePane.setOnMouseClicked(event -> rotateTile());
		tilePane.setOnMouseEntered(event -> { setCursor(Cursor.HAND); });
		tilePane.setOnMouseExited(event -> { setCursor(Cursor.DEFAULT); });
		GameLogic.randomTile();
	}
	
	private void initializeRemainingText() {
		remainingText = new Button("Tiles Remaining : " + TileStorage.getTileCount());
		remainingText.setBackground(new Background(new BackgroundFill(
				Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		remainingText.setFont(new Font("Arial Bold", 20));
		remainingText.setStyle("-fx-text-fill: white;");
		remainingText.setLayoutX(180);
		remainingText.setLayoutY(40);
	}
	
	private void initializePassButton() {
		passButton = new Button("Pass");
		passButton.setLayoutX(205);
		passButton.setLayoutY(90);
		passButton.setPrefWidth(170);
		passButton.setPrefHeight(40);
		passButton.setBackground(new Background(new BackgroundFill(
				Color.FIREBRICK, CornerRadii.EMPTY, Insets.EMPTY)));
		passButton.setFont(new Font("Arial Bold", 40));
		passButton.setStyle("-fx-text-fill: white;");
		passButton.setOnMouseClicked(event -> onMouseClicked());
		passButton.setOnMouseEntered(event -> onMouseEnteredHandler());
		passButton.setOnMouseExited(event -> onMouseExitedHandler());
	}
	
	private void rotateTile() {
		GameLogic.getCurrentTile().rotate();
		tilePane.setRotate(tilePane.getRotate() + 90);
	}
	
	public static void showRandomTile() {
		tilePane.getGraphicsContext2D().drawImage(
				ResourceLoader.getTileImage(GameLogic.getCurrentTile().getTileType()), 
				0, 0, TilePane.getTileSize() * 3, TilePane.getTileSize() * 3);
	}
	
	public static void updateTileRemaining() {
		remainingText.setText("Tiles Remaining : " + TileStorage.getTileCount());
	}
	
	private void onMouseClicked() {
		GameLogic.getCurrentPlayer().updatePenalty(1);
		GameLogic.randomTile();
		GameLogic.nextPlayer();
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
