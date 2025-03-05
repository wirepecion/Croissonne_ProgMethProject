package gui;

import component.Tile;
import data.ResourceLoader;
import interfaces.Rotatable;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.GameLogic;
import utils.TileType;

public class TilePane extends Canvas implements Rotatable {
	
	private static final int TILE_SIZE = 50;
	Tile tile;
	
	public TilePane(Tile tile) {
		super(TILE_SIZE, TILE_SIZE);
		this.tile = tile;
		setOnMouseClicked(event -> MouseClickHandler());
		setOnMouseEntered(event -> MouseEnteredHandler());
		setOnMouseExited(event -> MouseExitedHandler());
	}
	
	public void draw() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.drawImage(ResourceLoader.getTileImage(tile.getTileType()), 0, 0, TILE_SIZE, TILE_SIZE);
//		setRotate(ControlPane.getTilePane().getRotate());
//		setCursor(Cursor.DEFAULT);
//		ControlPane.getTilePane().setRotate(0);
	}

	
	public void rotate() {
		setRotate(getRotate() + 90);
	}
	
	private void MouseClickHandler() {
		tile.onClick();
	}
	
	private void MouseEnteredHandler() {
		if (!GameLogic.getInstance().isGameEnd()) {
			if (tile.getTileType().equals(TileType.EMPTY)) {
				setCursor(Cursor.HAND);
			}
		}
	}
	
	private void MouseExitedHandler() {
		setCursor(Cursor.DEFAULT);
	}
	
	public static int getTileSize() {
		return TILE_SIZE;
	}
}
