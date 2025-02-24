package component;

import java.awt.Graphics2D;

import data.ResourceLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import logic.TileStorage;
import utils.TileType;

public class Board extends GridPane {
	
	private static final int BOARD_SIZE = 12;
	private Tile[][] allTiles = new Tile[BOARD_SIZE + 1][BOARD_SIZE + 1];
	
	public Board() {
		
		setHgap(10); setVgap(10);
		setPadding(new Insets(10));
		setPrefWidth(800);
		setAlignment(Pos.CENTER);
		setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
		
		initializeBoard();
		paintComponent();
		
	}
	
	private void initializeBoard() {
		
		TileStorage.init();

		for(int row = 0; row < BOARD_SIZE; row++) {
			for(int col = 0; col < BOARD_SIZE; col++) {
				Tile tile = Tile.createTile();
				if (row == 6 && col == 6) {
					tile = Tile.createTile(TileType.CURVE_RIVER_TURN_LEFT_AT_ABYSS);
					tile.setPlace(true);
				}
				tile.setxPosition(row);
				tile.setyPosition(col);
				this.add(tile, col, row);
				ResourceLoader.getInstance().add(tile);
				allTiles[row][col] = tile;
			}
		}
	}
	
	public void addOnBoard(Tile tile, int x, int y) {
		this.add(tile, y, x);
		allTiles[x][y] = tile;
		paintComponent();
	}
	
	public void paintComponent() {
		for (Tile tile : ResourceLoader.getInstance().getTiles()) {
			tile.draw(tile.getGraphicsContext2D());
		}
	}
	
	public static int getBoardSize() {
		return BOARD_SIZE;
	}
	
	public Tile[][] getAllTiles() {
		return allTiles;
	}
	
	public Tile getTile(int row, int col) {
		if (row < 0 || col < 0 || row > BOARD_SIZE || col > BOARD_SIZE) return null;
		return allTiles[row][col];
	}
	
	public void setTileOnBoard(Tile tile, int row, int col) {
		allTiles[row][col] = tile; 
	}
}
