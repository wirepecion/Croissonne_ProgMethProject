package component;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
	private ArrayList<ArrayList<Tile>> allTiles;
	
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
		
		allTiles = new ArrayList<ArrayList<Tile>>();
		TileStorage.init();

		for(int row = 0; row < BOARD_SIZE; row++) {
			allTiles.add(new ArrayList<Tile>());
			for(int col = 0; col < BOARD_SIZE; col++) {
				Tile tile = Tile.createTile();
				allTiles.get(row).add(tile);
				this.add(tile, col, row);
			}
		}
	}
	
	public ArrayList<ArrayList<Tile>> getAllTiles() {
		return allTiles;
	}
	
	public Tile getTile(int row, int col) {
		return allTiles.get(row).get(col);
	}
	
	public boolean isEmpty(int row, int col) {
		return allTiles.get(row).get(col).getTileType().equals(TileType.EMPTY);
	}
	
	public void setTileInBoard(Tile tile, int row, int col) {
		allTiles.get(row).set(col, tile);
		this.add(tile, row, col);
	}
}
