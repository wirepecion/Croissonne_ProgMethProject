package GUI;

import java.lang.reflect.Field;

import component.Tile;
import data.ResourceLoader;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.GameLogic;
import utils.TileType;

public class TilePane extends Canvas {
	
	private static final int TILE_SIZE = 50;
	Tile tile;
	
	public TilePane(Tile tile) {
		super(TILE_SIZE, TILE_SIZE);
		this.tile = tile;
		ResourceLoader.getInstance().add(this);
		setOnMouseClicked(event -> MouseClickHandler());
		setOnMouseEntered(event -> MouseEnteredHandler());
		setOnMouseExited(event -> MouseExitedHandler());
	}
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(getImageOfTile(), 0, 0, TILE_SIZE, TILE_SIZE);
	}
	
	public Image getImageOfTile() {
		String string = toCamelCase(tile.getTileType().toString());
		try {
			Field field = ResourceLoader.class.getField(string);
			Image img = (Image) field.get(ResourceLoader.class);
			return img;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
