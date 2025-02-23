package component;

import java.awt.event.MouseListener;
import java.lang.reflect.Field;
import java.util.Collections;

import java.util.List;

import interfaces.Rotatable;
import utils.TileArea;
import utils.TileType;
import logic.GameLogic;
import logic.TileAreaDeterminer;
import sharedObject.RenderableHolder;
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

public abstract class Tile extends Canvas implements Rotatable {

	private static final int TILE_SIZE = 50;
	private static final int EDGE_DIRECTIONS = 4;
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
		super(TILE_SIZE, TILE_SIZE);
		this.tileType = tiletype;
		this.edge = TileAreaDeterminer.determineTileArea(tileType);
		setPlace(false);
		setRemoved(false);
		setOnMouseClicked(event -> MouseClickHandler());
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
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(getImageOfTile(), 0, 0, TILE_SIZE, TILE_SIZE);
	}
	
	public Image getImageOfTile() {
		String string = toCamelCase(tileType.toString());
		try {
			Field field = RenderableHolder.class.getField(string);
			Image img = (Image) field.get(RenderableHolder.class);
			return img;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// rotate clockwise
	public void rotate() {
		Collections.rotate(edge, 1);
	}
	
	private void MouseClickHandler() {
		new Thread(() -> {
			GameLogic.getInstance();
			if (GameLogic.getCurrentTile() != null && !GameLogic.getCurrentTile().isPlace()) {
				if (GameLogic.getInstance().isPlaceable(xPosition, yPosition)) {
					this.tileType = GameLogic.getCurrentTile().getTileType();
					this.edge = GameLogic.getCurrentTile().getEdge(); 
					GameLogic.getCurrentTile().setPlace(true);
					RenderableHolder.getInstance().add(GameLogic.getCurrentTile());
					GameLogic.getInstance().getBoard().addOnBoard(GameLogic.getCurrentTile(), xPosition, yPosition);
					draw(GameLogic.getCurrentTile().getGraphicsContext2D());
					GameLogic.getInstance().getBoard().paintComponent();
				}
			}
		}).start();
	}
	
	public boolean isEmpty() {
		return tileType.equals(TileType.EMPTY);
	}
	
	private static boolean isOwnable(TileType tileType) {
		return tileType.toString().contains("CASTLE") ||
			   tileType.toString().contains("RIVER");
	}
	
	public String toCamelCase(String str) {
        String[] words = str.split("_");
        StringBuilder camelCaseString = new StringBuilder(words[0].toLowerCase());

        for (int i = 1; i < words.length; i++) {
            camelCaseString.append(words[i].substring(0, 1).toUpperCase())
                           .append(words[i].substring(1).toLowerCase());
        }

        return camelCaseString.toString();
    }
	
	public static int getTileSize() {
		return TILE_SIZE;
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
