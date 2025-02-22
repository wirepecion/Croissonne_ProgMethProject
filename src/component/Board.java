package component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
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

public class Board extends GridPane {
	
	private static final int BOARD_SIZE = 12;
	private Tile[][] allTiles = new Tile[BOARD_SIZE + 1][BOARD_SIZE + 1];
	
	public Board() {
		
		setHgap(10); setVgap(10);
		setPadding(new Insets(10));
		setPrefWidth(800);
		setAlignment(Pos.CENTER);
		setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
		
		initializeBoard();
	}
	
	private void initializeBoard() {
		
		TileStorage.init();

		for(int row = 0; row < BOARD_SIZE; row++) {
			for(int col = 0; col < BOARD_SIZE; col++) {
				Tile tile = Tile.createTile();
				tile.setxPosition(row);
				tile.setyPosition(col);
				allTiles[row][col] = tile;
				this.add(tile, col, row);
			}
		}
	}
	
	public static int getBoardSize() {
		return BOARD_SIZE;
	}
	
	public Tile[][] getAllTiles() {
		return allTiles;
	}
	
	public Tile getTile(int row, int col) {
		if (row < 0 || col < 0) return null;
		return allTiles[row][col];
	}
	
	public void setTileOnBoard(Tile tile, int row, int col) {
		allTiles[row][col] = tile; 
	}
}
