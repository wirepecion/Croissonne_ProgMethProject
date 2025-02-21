package component;

import java.util.Collections;
import java.util.List;

import interfaces.Rotatable;
import utils.TileArea;
import utils.TileType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import logic.TileAreaDeterminer;

public abstract class Tile extends Pane implements Rotatable {
	private static final int EDGE_DIRECTIONS = 4;
	private TileType tileType;
	private List<TileArea> edge;
//	private final Image tileImage = new Image(ClassLoader.getSystemResource("res/board.png").toString());
	// edge contains 4 TileArea 
	// (0) north edge
	// (1) east edge
	// (2) south edge
	// (3) west edge
	
	public Tile(TileType tiletype) {
		this.tileType = tiletype;
		this.edge = TileAreaDeterminer.determineTileArea(tileType);
	}
	
	public static Tile createTile(TileType tileType) {
		if (isOwnable(tileType)) {
			return new OwnableTile(tileType);
		} else {
			return new RegularTile(tileType);
		}
	}
	
	public static Tile createTile() {
		return new RegularTile(TileType.EMPTY);
	}
	
	// rotate clockwise
	public void rotate() {
		Collections.rotate(edge, 1);
	}

	public static int getEdgeDirections() {
		return EDGE_DIRECTIONS;
	}

	public TileType getTileType() {
		return tileType;
	}

	public List<TileArea> getEdge() {
		return edge;
	}

	private static boolean isOwnable(TileType tileType) {
		return tileType.toString().contains("CASTLE") ||
			   tileType.toString().contains("RIVER");
	}
	
	public String toString() {
		return tileType.name();
	}
}
