package gui;

import component.Tile;
import data.ImageLoader;
import data.AudioLoader;
import interfaces.Rotatable;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.GameLogic;
import utils.TileType;

public class TilePane extends Canvas implements Rotatable {

	private static final int TILE_SIZE = 50;
	private Tile tile;

	public TilePane(Tile tile) {
		super(TILE_SIZE, TILE_SIZE);
		this.tile = tile;
		setOnMouseClicked(event -> MouseClickHandler());
		setOnMouseEntered(event -> MouseEnteredHandler());
		setOnMouseExited(event -> MouseExitedHandler());
	}

	public void draw() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.drawImage(ImageLoader.getTileImage(tile.getTileType()), 0, 0, TILE_SIZE, TILE_SIZE);
	}

	public void rotate() {
		setRotate(getRotate() + 90);
	}

	private void MouseClickHandler() {
		if (tile.onClick()) {
			drawEmpty();
			draw();
			AudioLoader.playTileAudio();
			setRotate(ControlPane.getTilePane().getRotate());
			setCursor(Cursor.DEFAULT);
			ControlPane.getTilePane().setRotate(0);
			GameLogic.getInstance().placeCurrentTile(tile.getxPosition(), tile.getyPosition());
		}
	}

	private void MouseEnteredHandler() {
		if (!GameLogic.getInstance().isGameEnd()) {
			if (tile.getTileType().equals(TileType.EMPTY)) {
				setCursor(Cursor.HAND);
				drawEmptyAlert();
			}
		}
	}

	private void MouseExitedHandler() {
		setCursor(Cursor.DEFAULT);
		if (!GameLogic.getInstance().isGameEnd()) {
			if (tile.getTileType().equals(TileType.EMPTY)) {
				drawEmpty();
			}
		}
	}

	private void drawEmptyAlert() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.drawImage(ImageLoader.getTileEmptyAlert(), 0, 0, TILE_SIZE, TILE_SIZE);
	}

	private void drawEmpty() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.clearRect(0, 0, getWidth(), getHeight());
		draw();
	}

	public static int getTileSize() {
		return TILE_SIZE;
	}
}
