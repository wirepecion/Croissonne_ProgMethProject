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
import logic.TileStorage;
import GUI.ControlPane;
import GUI.TilePane;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class Tile implements Rotatable {

	private static final int EDGE_DIRECTIONS = 4;
	private TilePane tilePane;
	private TileType tileType;
	private List<TileArea> edge;
	private int xPosition;
	private int yPosition;
	private boolean isPlace;
	private boolean isRemoved;
	// edge contains 4 TileArea 
	// (0) north edge
	// (1) east edge
	// (2) south edge
	// (3) west edge
	
	public Tile(TileType tiletype) {
		this.tileType = tiletype;
		this.edge = (new TileAreaDeterminer()).determineTileArea(tileType);
		setPlace(false);
		setRemoved(false);
		this.tilePane = new TilePane(this);
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
		tilePane.rotate();
	}
	
	public boolean isEmpty() {
		return tileType.equals(TileType.EMPTY);
	}
	
	private static boolean isOwnable(TileType tileType) {
		return tileType.toString().contains("CASTLE") ||
			   tileType.toString().contains("RIVER");
	}
	
	public void onClick() {
		if (GameLogic.getCurrentTile() != null && !GameLogic.getCurrentTile().isPlace()) {
			System.out.println(xPosition + " " + yPosition);
			if (GameLogic.getInstance().isPlaceable(xPosition, yPosition)) {
				System.out.println("get next tile");
				this.tileType = GameLogic.getCurrentTile().getTileType();
				this.edge = (new TileAreaDeterminer()).determineTileArea(tileType); 
				tilePane.setRotate(ControlPane.getTilePane().getRotate());
				tilePane.setCursor(Cursor.DEFAULT);
				ControlPane.resetTilepane();
				GameLogic.placeCurrentTile(xPosition, yPosition);
			}
		}
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

	public boolean isRemoved() {
		return isRemoved;
	}

	public void setRemoved(boolean isRemoved) {
		this.isRemoved = isRemoved;
	}

}
