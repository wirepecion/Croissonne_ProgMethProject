package component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import utils.TileArea;
import utils.TileType;
import utils.Constant;
import interfaces.Rotatable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Tile extends Pane implements Rotatable {
	private TileType tileType;
	private static final int TILE_SIZE = 50;
//	private final Image boardImage = new Image(ClassLoader.getSystemResource("res/board.png").toString());
	// border contains 4 TileArea 
	// (1) north border
	// (2) east border
	// (3) south border
	// (4) west border
	
	public Tile() {
		setTileType(tileType.EMPTY);
		setPrefHeight(TILE_SIZE);
		setPrefWidth(TILE_SIZE);
		setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, CornerRadii.EMPTY, Insets.EMPTY)));
	}	
	
	public void setTileType(TileType tileType) {
		this.tileType = tileType;
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		
	}
}
