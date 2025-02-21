package component;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Board extends GridPane {
	private static final int BOARD_SIZE = 12;
	private List<List<Tile>> allTiles;
	
	public Board() {
		setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.SADDLEBROWN, 
				BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setBackground(new Background(new BackgroundFill(Color.DARKGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
		for(int row = 0; row < BOARD_SIZE; row++) {
			allTiles.add(new ArrayList<Tile>());
			for(int col = 0; col < BOARD_SIZE; col++) {
				allTiles.get(row).add(Tile.createTile());
			}
		}
	}
	
	public List<List<Tile>> getAllTiles() {
		return allTiles;
	}
	
	public void setTileInBoard(Tile tile, int row, int col) {
		allTiles.get(row).set(col, tile);
		this.add(tile, row, col);
	}
}
