package component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import interfaces.Rotatable;
import utils.TileArea;
import utils.TileType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import logic.TileAreaDeterminer;

public class Tile extends Pane implements Rotatable {
	private static final int BORDER_DIRECTIONS = 4;
	private TileType tileType;
	private boolean isCastle;
	private List<TileArea> edge;
//	private final Image boardImage = new Image(ClassLoader.getSystemResource("res/board.png").toString());
	// edge contains 4 TileArea 
	// (0) north edge
	// (1) east edge
	// (2) south edge
	// (3) west edge
	
	public Tile(TileType tiletype) {
		this.tileType = tiletype;
		this.isCastle = (tiletype.toString().contains("CASTLE") ?
				true : false);
		this.edge = TileAreaDeterminer.determineTileArea(tileType);
	}
	
	public Tile() {
		this(TileType.EMPTY);
	}
	
	// rotate clockwise
	public void rotate() {
		Collections.rotate(edge, 1);
	}

	public static int getBorderDirections() {
		return BORDER_DIRECTIONS;
	}

	public TileType getTileType() {
		return tileType;
	}

	public boolean isCastle() {
		return isCastle;
	}

	public List<TileArea> getEdge() {
		return edge;
	}

}
