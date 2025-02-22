package component;

import java.util.Collections;
import java.util.List;

import interfaces.Rotatable;
import utils.TileArea;
import utils.TileType;
import logic.GameLogic;
import logic.TileAreaDeterminer;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class Tile extends Pane implements Rotatable {

	private static final int TILE_SIZE = 50;
	private static final int EDGE_DIRECTIONS = 4;
	private TileType tileType;
	private List<TileArea> edge;
	private String tileURL;
	private int xPosition;
	private int yPosition;
	private boolean isPlace;
	// edge contains 4 TileArea 
	// (0) north edge
	// (1) east edge
	// (2) south edge
	// (3) west edge
	
	public Tile(TileType tiletype) {
		
		this.tileType = tiletype;
		this.edge = TileAreaDeterminer.determineTileArea(tileType);
		this.tileURL = ClassLoader.getSystemResource(
				"tempTilePic/" + tiletype.toString() + ".png").toString();
		setPlace(false);
		updateTileImage(tileURL);
		setPrefHeight(TILE_SIZE);
		setPrefWidth(TILE_SIZE);
		setOnMouseClicked(event -> onTileClick());
		
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
	
	public void updateTileImage(String tileURL) {
		BackgroundFill bgFill = new BackgroundFill(Color.CHOCOLATE, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(TILE_SIZE, TILE_SIZE, false, false, false, false);
		BackgroundImage bgImg = new BackgroundImage(new Image(tileURL), null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		setBackground(new Background(bgFillA, bgImgA));
	}
	
	public void onTileClick() {
		if (GameLogic.getInstance().getCurrentTile() != null) {
			if (this != GameLogic.getInstance().getCurrentTile()) {
				if (!GameLogic.getInstance().getCurrentTile().isPlace()) {
					if (GameLogic.getInstance().isPlaceable(xPosition, yPosition)) {
						Tile newTile = GameLogic.getInstance().getCurrentTile();
						this.tileType = newTile.getTileType();
						this.edge = newTile.getEdge();
						this.tileURL = newTile.getTileURL();
						updateTileImage(newTile.getTileURL());
						newTile.setPlace(true);
						GameLogic.getInstance().getBoard().setTileOnBoard(newTile, xPosition, yPosition);
					}
				}
			}
		}
	}
	
	// rotate clockwise
	public void rotate() {
		Collections.rotate(edge, 1);
	}
	
	public boolean isEmpty() {
		return tileType.equals(TileType.EMPTY);
	}
	
	private static boolean isOwnable(TileType tileType) {
		return tileType.toString().contains("CASTLE") ||
			   tileType.toString().contains("RIVER");
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
	
	public String getTileURL() {
		return tileURL;
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
