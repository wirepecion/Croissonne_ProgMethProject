package component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import interfaces.Rotatable;
import utils.TileArea;
import utils.TileType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Tile extends Pane implements Rotatable {
	private static final int BORDER_DIRECTIONS = 4;
	private List<TileArea> border;
	private boolean isCastle;
	private TileType tileType;
//	private final Image boardImage = new Image(ClassLoader.getSystemResource("res/board.png").toString());
	// border contains 4 TileArea 
	// (0) north border
	// (1) east border
	// (2) south border
	// (3) west border
	
	public Tile(TileType tiletype, boolean isCastle) {
		
	}
	
	// rotate clockwise
	public void rotate() {
		
	}

	private static List<TileArea> determineTileArea(TileType tileType) {
		
		return null;
	}
}
