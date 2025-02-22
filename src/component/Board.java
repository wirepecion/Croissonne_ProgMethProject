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
import utils.TileType;

public class Board extends GridPane {
	private static final int BOARD_SIZE = 12;
	private ArrayList<ArrayList<Tile>> allTiles;
	
	public Board() {
		setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.SADDLEBROWN, 
				BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setBackground(new Background(new BackgroundFill(Color.DARKGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
		setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.SADDLEBROWN, 
				BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setBackground(new Background(new BackgroundFill(Color.DARKGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
		setAlignment(Pos.CENTER);
		
		setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
		
		allTiles = new ArrayList<ArrayList<Tile>>();

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
	
	public boolean isEmpty(int row, int col) {
		return allTiles.get(row).get(col).equals(TileType.EMPTY);
	}
	
	public void setTileInBoard(Tile tile, int row, int col) {
		allTiles.get(row).set(col, tile);
		this.add(tile, row, col);
	}
}
