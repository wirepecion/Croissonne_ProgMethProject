package component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.TileStorage;
import utils.PlayerColor;

public class ControlPane extends VBox {
	
	private Canvas tilePane;
	private Button passButton;
	
	public ControlPane() {
		setPrefHeight(750);
		setPrefWidth(500);
		setSpacing(10);
		setAlignment(Pos.CENTER);
		
		//For Test
		Player player1 = new Player("player1", PlayerColor.BLUE);
		Player player2 = new Player("player2", PlayerColor.RED);
		initializeTilePane();
		initializePassButton();
		
		getChildren().addAll(
			player1.getPlayerStatPane(), 
			player2.getPlayerStatPane(), 
			tilePane,
			passButton
		);
	}
	
	public void initializeTilePane() {
		tilePane = new Canvas(Tile.getTileSize() * 2, Tile.getTileSize() * 2);
		tilePane.getGraphicsContext2D().drawImage(
				Tile.createTile().getTileImg(), 0, 0, Tile.getTileSize() * 2, Tile.getTileSize() * 2);
	}
	
	public void initializePassButton() {
		passButton = new Button("Pass");
		passButton.setPrefWidth(300);
		passButton.setPrefHeight(100);
		passButton.setBackground(new Background(new BackgroundFill(
				Color.DARKRED, CornerRadii.EMPTY, Insets.EMPTY)));
		passButton.setFont(new Font("Arial Bold", 50));
		passButton.setStyle("-fx-text-fill: white;");
		passButton.setOnMouseClicked(event -> drawButtonHandler());
	}
	
	public void drawButtonHandler() {
		Tile tile = TileStorage.getRandomTile();
		tilePane.getGraphicsContext2D().drawImage(
				tile.getTileImg(), 0, 0, Tile.getTileSize() * 2, Tile.getTileSize() * 2);
	}
	
}
