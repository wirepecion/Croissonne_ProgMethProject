package component;

import java.awt.event.MouseListener;
import java.lang.reflect.Field;
import java.util.Collections;

import java.util.List;

import data.ResourceLoader;
import interfaces.Rotatable;
import utils.TileArea;
import utils.TileType;
import logic.GameLogic;
import logic.TileAreaDeterminer;
import gui.ControlPane;
import gui.TilePane;
import javafx.scene.Cursor;

public abstract class Tile implements Rotatable {

	protected static final int EDGE_DIRECTIONS = 4;
	private TilePane tilePane;
	protected TileType tileType;
	protected List<TileArea> edge;
	protected int xPosition;
	protected int yPosition;
	private boolean isPlace;
	// edge contains 4 TileArea 
	// (0) north edge
	// (1) east edge
	// (2) south edge
	// (3) west edge
	
	public Tile(TileType tiletype) {
		this.tileType = tiletype;
		this.edge = (new TileAreaDeterminer()).determineTileArea(tileType);
		setPlace(false);
		this.tilePane = new TilePane(this);
	}

	public static Tile createTile(TileType tileType) {
		if (isScoreable(tileType)) {
			return new ScoreableTile(tileType);
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
		tilePane.rotate();
	}
	
	public boolean isEmpty() {
		return tileType.equals(TileType.EMPTY);
	}
	
	private static boolean isScoreable(TileType tileType) {
		return tileType.toString().contains("CASTLE") ||
			   tileType.toString().contains("RIVER");
	}
	
	public boolean onClick() {
		if (GameLogic.getCurrentTile() != null && !GameLogic.getCurrentTile().isPlace()) {
			System.out.println(xPosition + " " + yPosition);
			if (GameLogic.getInstance().isPlaceable(xPosition, yPosition)) {
				System.out.println("get next tile");
				
				this.tileType = GameLogic.getCurrentTile().getTileType();
				this.edge = (new TileAreaDeterminer()).determineTileArea(tileType); 
				
				return true;
			}
		}
		return false;
	}

	public static int getEdgeDirections() {
		return EDGE_DIRECTIONS;
	}
	
	public TilePane getTilePane() {
		return tilePane;
	}

	public TileType getTileType() {
		return tileType;
	}

	public List<TileArea> getEdge() {
		return edge;
	}
	
	public TileArea getEdge(int idx) {
		return edge.get(idx);
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	
	public void setPlace(boolean isPlace) {
		this.isPlace = isPlace;
	}

	public boolean isPlace() {
		return isPlace;
	}

}
