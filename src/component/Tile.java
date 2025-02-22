package component;

import java.util.Collections;
import java.util.List;

import interfaces.Rotatable;
import utils.TileArea;
import utils.TileType;
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
	private final String tileURL;
	// edge contains 4 TileArea 
	// (0) north edge
	// (1) east edge
	// (2) south edge
	// (3) west edge
	
	public Tile(TileType tiletype) {
		this.tileType = tiletype;
		this.edge = TileAreaDeterminer.determineTileArea(tileType);
		String path = "tempTilePic/" + tiletype.toString() + ".png";
		this.tileURL = ClassLoader.getSystemResource(path).toString();
		setPrefHeight(TILE_SIZE);
		setPrefWidth(TILE_SIZE);
		BackgroundFill bgFill = new BackgroundFill(Color.CHOCOLATE, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(TILE_SIZE, TILE_SIZE, false, false, false, false);
		Image img = new Image(tileURL);
		BackgroundImage bgImg = new BackgroundImage(img, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		setBackground(new Background(bgFillA, bgImgA));
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

}
